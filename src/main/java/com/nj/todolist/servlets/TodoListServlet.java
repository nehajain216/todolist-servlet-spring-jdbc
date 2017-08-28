package com.nj.todolist.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nj.todolist.entities.Todo;
import com.nj.todolist.services.TodoService;
import com.nj.todolist.utils.SpringContext;

public class TodoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TodoListServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		TodoService todoService = SpringContext.getBean(TodoService.class);
		List<Todo> allToDo = todoService.getAllToDo();
		request.setAttribute("todos", allToDo);
		request.getRequestDispatcher("TodoList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
