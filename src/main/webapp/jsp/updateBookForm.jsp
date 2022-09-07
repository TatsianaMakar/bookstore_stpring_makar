<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update book</title>
</head>
<body>
<form method="post" action="controller">
    <input type="hidden" name="command" value="update_book">
    <input type="hidden" name="id" value="${requestScope.book.id}">
    <label>Name:</label>
    <input type="text" name="book_name" value="${requestScope.book.bookName}">

    <label>Author: </label>
    <input type="text" name="author" value="${requestScope.book.author}">
    <label>Year: </label>
    <input type="text" name="year" value="${requestScope.book.year}">
    <label>Price: </label>
    <input type="text" name="price" value="${requestScope.book.price}">
    <label>ISBN: </label>
    <input type="text" name="isbn" value="${requestScope.book.isbn}">
    <label>cover: </label>
    <input type="text" name="cover" value="${requestScope.book.cover}">

    <input type="submit" value="Save">

</form>

</body>
</html>
