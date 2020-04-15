<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 15/04/2020
  Time: 1:37 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<p>Resuilt : ${condiment[0]}</p>--%>
<%--<p>Resuilt : ${condiment[1]}</p>--%>
<c:forEach var = "i" begin = "0" end = "5">
Item <c:out value = "${condiment[i]}"/><p>
    </c:forEach>
</body>
</html>
