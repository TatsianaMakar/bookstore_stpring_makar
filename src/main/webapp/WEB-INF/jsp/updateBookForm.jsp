<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update book</title>
</head>
<body>
<form  class="login-form" action="/book/edit/${book.id}" method="post">
    <input type="hidden" name="command" value="update_book">
    <input type="hidden" name="id" value="${book.id}">
    <label>BookName: <input name="bookName" type="text" value="${book.bookName}"></label>
       <label>Author: <input name="author" type="text" value="${book.author}"></label>
       <label>Year: <input name="year" type="text" value="${book.year}"></label>
       <label>Price: <input name="price" type="text" value="${book.price}"></label>
       <label>ISBN: <input name="isbn" type="text" value="${book.isbn}"></label>
       <label>Cover: <input name="cover" type="text" value="${book.cover}"></label>
       <button>Save</button>
</form>
</body>
</html>
