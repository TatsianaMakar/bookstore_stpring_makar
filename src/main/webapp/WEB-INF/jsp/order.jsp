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
           <td><a href="controller?command=order&id=${order.id}">${order.id}</a></td>
       </tr>
<tr>
           <th>User</th>
           <td><a href="controller?command=user&id=${order.user.id}">${order.user.userEmail}</a>
           </td>
       </tr>
       <tr>
           <th>Status</th>
           <td>${order.status}</td>
       </tr>
       <tr>
           <th>Items</th>
           <td>
               <table>
               <c:forEach items="${order.orderItems}" var="item" varStatus="counter">
                       <tr>
                           <td>${counter.count}</td>
                           <td><a href="controller?command=book&id=${item.book.id}">${item.book.bookName}</a></td>
                           <td>$${item.price} x ${item.quantity}</td>
                       </tr>
                   </c:forEach>
               </table>
           </td>
       </tr>
       <tr>
           <th>Total cost</th>
           <td>${order.totalCost} USD</td>
       </tr>
</table>
</body>
</html>
