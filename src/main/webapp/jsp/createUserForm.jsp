<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
</head>
<body>
<form method="post" action="controller">
    <input type="hidden" name="command" value="create_user">
    <input type="hidden" name="id" value="${requestScope.user.id}">
    <label>Name:
        <input type="text" name="userName" value="${requestScope.user.userName}">
    </label>
    <%--    <input type="submit" value="Save" name=controller?command=update_user&id=${user.id}"--%>
    <%--    <tr><th>Name</th><th>${requestScope.user.userName}</th></tr>--%>
    <%--    <td><a href="controller?command=update_user&id=${user.id}">"save"</a></td>--%>
</form>

</body>
</html>
