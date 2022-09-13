<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete User</title>
</head>
<body>
<form  class="login-form" action="/user/delete/${user.id}" method="post">
    <input type="hidden" name="command" value="delete_user">
    <input type="hidden" name="id" value="${user.id}">
    <label>Login: <input name="userName" type="text" value="${user.userName}"></label>
       <label>Email: <input name="userEmail" type="text" value="${user.userEmail}"></label>
       <label>Password: <input name="userPassword" type="text" value="${user.userPassword}"></label>
       <button>DELETE</button>
</form>
</body>
</html>
