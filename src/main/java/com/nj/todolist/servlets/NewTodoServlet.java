package com.nj.todolist.servlets;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nj.todolist.entities.Todo;
import com.nj.todolist.services.TodoService;
import com.nj.todolist.utils.SpringContext;


public class NewTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public NewTodoServlet() {
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Todo todo = new Todo();
		todo.setTitle(request.getParameter("title"));
		todo.setDescription(request.getParameter("description"));
		todo.setUserid(1);
		TodoService todoService = SpringContext.getBean(TodoService.class);
		todoService.createToDo(todo);
		response.sendRedirect("TodoListServlet");
	}

}
