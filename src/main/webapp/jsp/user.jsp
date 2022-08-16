<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>User</title>
</head>
<body>
<h1>User</h1>
<table>
<tr><th>Field</th><th>Value</th></tr>
<tr><th>Id</th><th>${requestScope.user.id}</th></tr>
<tr><th>Title</th><th>${requestScope.user.userName}</th></tr>
<tr><th>Author</th><th>${requestScope.user.userEmail}</th></tr>
</table>
</body>
</html>