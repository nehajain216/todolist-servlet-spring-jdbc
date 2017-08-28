package com.nj.todolist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.nj.todolist.entities.Todo;

@Component
public class TodoDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public TodoDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Todo> getAllToDo() {
		String sql = "select * from todolist";
		List<Todo> todos = jdbcTemplate.query(sql, new TodoRowMapper());
		return todos;
	}

	public Todo createToDo(Todo todo) 
	{
		String sql = "insert into todolist(userid, title,description) values(?,?,?)";

		final PreparedStatementCreator psc = new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
				final PreparedStatement ps = connection.prepareStatement(sql,
						Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1,  todo.getUserid());
				ps.setString(2,  todo.getTitle());
				ps.setString(3,  todo.getDescription());
				return ps;
			}
		};

		// The newly generated key will be saved in this object
		final KeyHolder holder = new GeneratedKeyHolder();

		jdbcTemplate.update(psc, holder);

		final int todoId = holder.getKey().intValue();
		todo.setId(todoId);
		return todo;
	}
}

class TodoRowMapper implements RowMapper<Todo> {

	@Override
	public Todo mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Todo todo=new Todo();
		todo.setId(rs.getInt("id"));
		todo.setUserid(rs.getInt("userid"));
		todo.setTitle(rs.getString("title"));
		todo.setDescription(rs.getString("description"));
		return todo;
	}

}
