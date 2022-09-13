<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
</head>
<body>
<form  class="login-form" action="/user/edit/${user.id}" method="post">
    <input type="hidden" name="command" value="update_user">
    <input type="hidden" name="id" value="${user.id}">
    <label>Login: <input name="userName" type="text" value="${user.userName}"></label>
       <label>Email: <input name="userEmail" type="text" value="${user.userEmail}"></label>
       <label>Password: <input name="userPassword" type="text" value="${user.userPassword}"></label>
       <button>Save</button>
</form>
</body>
</html>
