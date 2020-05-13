<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 07/04/2020
  Time: 10:17 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer Management Application</title>
</head>
<body>
<h1 style="text-align: center">Customer Management</h1>
<h2 style="text-align: center">
    <div style="text-align: center">
        <table border="1" cellpadding="5">
            <caption><h2>LIST CUSTOMER</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Action</th>
            </tr>
            <%--      //show list customer--%>
            <c:forEach items='${requestScope["listCus"]}' var="customer">
                <tr>
                    <td><c:out value="${customer.getId}"></c:out></td>
                    <td><c:out value="${customer.getName}"></c:out></td>
                    <td><c:out value="${customer.getPhone}"></c:out></td>
                    <td>
                        <a href="#">Edit</a>
                        <a href="#">Delete</a>c
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>


</h2>
</body>
</html>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%--<html>--%>
<%--<head>--%>
<%--    <title>Customer List</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Customers</h1>--%>
<%--<p><a href="/customers?action=create">Create new customer</a></p>--%>

<%--<table border="1">--%>
<%--    <tr>--%>
<%--        <th>ID</th>--%>
<%--        <th>Name</th>--%>
<%--        <th>Phone</th>--%>
<%--        <th>Email</th>--%>
<%--        <th>Action</th>--%>
<%--    </tr>--%>
<%--    <c:forEach items='${requestScope["listCus"]}' var="customer">--%>
<%--        <tr>--%>
<%--            <td><a href="/customers?action=view&id=${customer.getId()}">--%>
<%--            </a>${customer.getId()}</td>--%>
<%--            <td>${customer.getName()}</td>--%>
<%--            <td>${customer.getPhone()}</td>--%>
<%--            <td>${customer.getEmail()}</td>--%>
<%--            <td><a href="/customers?action=edit&id=${customer.getId()}">Edit</a>--%>
<%--            <a href="/customers?action=delete&id=${customer.getId()}">Delete</a>--%>
<%--            <a href="/customers?action=view&id=${customer.getId()}">view detail</a></td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>
<%--</body>--%>
<%--</html>--%>