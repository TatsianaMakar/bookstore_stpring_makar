<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Orders</title>
</head>
<body>
<h1>Orders</h1>
<table>
    <tr>
        <th>Id</th>
        <th>User</th>
        <th>Status</th>
        <th>Items</th>
        <th>TotalCost</th>
    </tr>
    <c:forEach items="${requestScope.orders}" var="order" varStatus="counter">
        <tr>
            <td>${counter.count}</td>
            <td><a href="controller?command=user&id=${order.id}">${order.user.userEmail}</a></td>
            <td>${order.status}</td>
            <td>
                <table>
                    <c:forEach items="${order.items}" var="item">
                        <tr>
                            <td><a href="controller?command=book&id=${item.book.id}">${item.book.bookName}</a></td>
                            <td>$${item.price} x ${item.quantity}</td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
            <td>${order.totalCost}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
