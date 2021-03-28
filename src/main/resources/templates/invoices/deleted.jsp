<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Art
  Date: 2020-11-29
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleted</title>
</head>
<body>
Your invoice was deleted
<c:forEach items="${companies}" var="company">
<br><a href="http://localhost:8080/invoice/all/${company.id}" style="text-decoration: none">Show all invoice</a>
</c:forEach>
</body>
</html>
