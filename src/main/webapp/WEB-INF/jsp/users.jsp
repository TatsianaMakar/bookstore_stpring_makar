<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h1>User</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
    </tr>
    <c:forEach items="${users}" var="user" varStatus="counter">
        <tr>
            <td>${counter.count}</td>
            <td><a href="controller?command=user&id=${user.id}"><c:out value="${user.userName}"/></a></td>
            <td><c:out value="${user.userEmail}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>