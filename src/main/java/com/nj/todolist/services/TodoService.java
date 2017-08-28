package com.nj.todolist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nj.todolist.dao.TodoDAO;
import com.nj.todolist.entities.Todo;

@Component
public class TodoService 
{
	private TodoDAO todoDAO;
	
	@Autowired
	public TodoService(TodoDAO todoDAO)
	{
		this.todoDAO = todoDAO;
	}
	
	public List<Todo> getAllToDo()
	{
		return todoDAO.getAllToDo();
	}
	
	public Todo createToDo(Todo todo)
	{
		return todoDAO.createToDo(todo);
	}
}
