<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
</head>
<body>
<form method="post" action="controller">
    <input type="hidden" name="command" value="update_user">
    <input type="hidden" name="id" value="${requestScope.user.id}">
    <label>Name:
        <input type="text" name="user_name" value="${requestScope.user.userName}">
    </label>
    <label>Email:
        <input type="text" name="user_email" value="${requestScope.user.userName}">
    </label>
    <label>Password:
        <input type="text" name="user_password" value="${requestScope.user.userName}">
    </label>
    <input type="submit" value="Save">

</form>

</body>
</html>
