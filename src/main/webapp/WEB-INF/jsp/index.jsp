<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Main Page</title>
</head>
<body>
<h1>Welcome to Demo App</h1>
<c:if test="${sessionScope.user != null}">
     <h2>Glad to see you again, ${sessionScope.user.userEmail}</h2>
 </c:if>
<div>This is a demo application for Java Professional Training Course</div>
 <ul>
    <li><a href="/user/getAll">All Users</a></li>
    <li><a href="/book/getAll">All Books</a></li>
    <li><a href="/book/create">Create Book</a></li>
    <li><a href="/order/getAll">All Orders</a></li>
    <c:if test="${sessionScope.user!=null}">
    <li><a href="/logout">Logout</a></li>
    <li><a href="/user/create">Create New User</a></li>
    </c:if>
    <c:if test="${sessionScope.user==null}">
    <li><a href="/user/create">Register</a></li>
    <li><a href="/login">Login</a></li>
    </c:if>

</ul>
</body>
</html>
