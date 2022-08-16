<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Book</title>
</head>
<body>
<h1>Book</h1>
<table>
<tr><th>Field</th><th>Value</th></tr>
<tr><th>Id</th><th>${requestScope.book.id}</th></tr>
<tr><th>Title</th><th>${requestScope.book.bookName}</th></tr>
<tr><th>Author</th><th>${requestScope.book.author}</th></tr>
</table>
</body>
</html>