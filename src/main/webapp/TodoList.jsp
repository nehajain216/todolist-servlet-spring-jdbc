<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>To-do List</title>
</head>
<body>
	<h3>To-do List</h3>
	<table border="1" width="600">
		<tr>
			<td>Title</td>
			<td>Description</td>
			<td colspan="2"><a href="NewTodoList.jsp">New To-Do-List</a></td>
		</tr>

		<c:if test="${todos.isEmpty()}">
			<tr>
				<td colspan="4">No Todo found</td>
			</tr>
		</c:if>
		<c:forEach var="todo" items="${todos}">
			<tr>
				<td><c:out value="${todo.title}" /></td>
				<td><c:out value="${todo.description}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>