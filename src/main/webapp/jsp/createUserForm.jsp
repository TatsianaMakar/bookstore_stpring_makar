<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
</head>
<body>
<form method="post" action="controller">
    <input type="hidden" name="command" value="create_user">
    <input type="hidden" name="id">
    <label>Name:
        <input type="text" name="user_name">
    </label>
    <label>Email:
        <input type="text" name="user_email">
    </label>
    <label>Password:
        <input type="text" name="user_password">
    </label>
    <input type="submit" value="Save">
</form>

</body>
</html>
