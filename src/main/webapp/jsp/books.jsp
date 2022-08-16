<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Books</title>
</head>
<body>
<h1>Book</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Author</th>
    </tr>
    <tr>
        <c:forEach items="${requestScope.books}" var="book" varStatus="counter">
    <tr>
        <td>${counter.count}</td>
        <td><a href="controller?command=book&id=${book.id}">${book.bookName}</a></td>
        <td>${book.author}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>