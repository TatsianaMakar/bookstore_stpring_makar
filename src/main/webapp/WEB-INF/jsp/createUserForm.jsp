<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
</head>
<body>
<ul>
    <li><a href="/">Home</a></li>
</ul>
<form class="login-form" action="/user/create" method="post">
    <label>Name: <input name="userName" type="text"></label>
    <label>Email: <input name="userEmail" type="text"></label>
    <label>Password: <input name="userPassword" type="text"></label>
    <button>Save</button>
</form>

</body>
</html>
