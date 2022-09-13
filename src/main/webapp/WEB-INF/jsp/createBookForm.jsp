<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Book</title>
</head>
<body>
<ul>
    <li><a href="/">Home</a></li>
</ul>
<form class="login-form" action="/book/create" method="post">
    <label>BookName: <input name="bookName" type="text"></label>
    <label>Author: <input name="author" type="text"></label>
    <label>Year: <input name="year" type="text"></label>
    <label>Price: <input name="price" type="text"></label>
    <label>ISBN: <input name="isbn" type="text"></label>
    <label>Cover: <input name="cover" type="text"></label>
    <button>Save</button>
</form>

</body>
</html>
