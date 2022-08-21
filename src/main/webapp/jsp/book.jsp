<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book</title>
</head>
<body>
<h1>Book</h1>
<table>
    <tr>
        <th>Field</th>
        <th>Value</th>
    </tr>
    <tr>
        <th>Id</th>
        <th>${requestScope.book.id}</th>
    </tr>
    <tr>
        <th>Title</th>
        <th>${requestScope.book.bookName}</th>
    </tr>
    <tr>
        <th>Author</th>
        <th>${requestScope.book.author}</th>
    </tr>
    <tr>
        <th>Year</th>
        <th>${requestScope.book.year}</th>
    </tr>
<%--    <tr>--%>
<%--        <th>Price</th>--%>
<%--        <th>${requestScope.book.price}</th>--%>
<%--    </tr>--%>
    <tr>
        <th>ISBN</th>
        <th>${requestScope.book.isbn}</th>
    </tr>
<%--    <tr>--%>
<%--        <th>Cover</th>--%>
<%--        <th>${requestScope.book.cover}</th>--%>
<%--    </tr>--%>
</table>
</body>
</html>