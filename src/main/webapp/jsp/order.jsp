<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Order</title>
</head>
<body>
<h1>Order</h1>
<table>
    <tr>
        <th>Field</th>
        <th>Value</th>
    </tr>
    <tr>
        <th>Id</th>
        <td><a href="controller?command=order&id=${requestScope.order.id}">${requestScope.order.id}</a></td>
    </tr>
    <tr>
        <th>User</th>
        <td><a href="controller?command=user&id=${requestScope.order.user.id}">${requestScope.order.user.userEmail}</a></td>
    </tr>
    <tr>
        <th>Status</th>
        <td>${requestScope.order.status}</td>
    </tr>
    <tr>
        <th>Items</th>
        </td>
        <td>
            <table>
                <c:forEach items="${requestScope.order.items}" var="item">
                    <tr>
                        <td><a href="controller?command=book&id=${item.book.id}">${item.book.bookName}</a></td>
                        <td>$${item.price} x ${item.quantity}</td>
                    </tr>
                </c:forEach>
            </table>
        </td>
    </tr>
    <tr>
        <th>Total cost</th>
        <td>${requestScope.order.totalCost} USD</td>
    </tr>
</table>
</body>
</html>
