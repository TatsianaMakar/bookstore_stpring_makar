<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Main Page</title>
</head>
<body>
<h1>Welcome to Demo App</h1>
<div>This is a demo application for Java Professional Training Course</div>
<ul>
     <li><a href="${pageContext.request.contextPath}/user/getAll">All Users</a></li>
    <li><a href="${pageContext.request.contextPath}/user/create">Create User</a></li>
    <li><a href="${pageContext.request.contextPath}/book/getAll">All Books</a></li>
    <li><a href="${pageContext.request.contextPath}/book/create">Create Book</a></li>
</ul>
</body>
</html>
