<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete order</title>
</head>
<body>
<form  class="login-form" action="/bookstore/order/delete/${order.id}" method="post">
<input type="hidden" name="command" value="delete_order">

       <button>DELETE</button>
</form>
</body>
</html>