<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Book</title>
</head>
<body>
<form method="post" action="controller">
    <input type="hidden" name="command" value="create_book">
    <input type="hidden" name="id">
    <label>Name:</label>
    <input type="text" name="book_name">
    <label>Author: </label>
    <input type="text" name="author">
    <label>Year: </label>
    <input type="text" name="year">
    <label>Price: </label>
    <input type="text" name="price">
    <label>ISBN: </label>
    <input type="text" name="isbn">
    <label>cover: </label>
    <input type="text" name="cover">

    <input type="submit" value="Save">
</form>

</body>
</html>
