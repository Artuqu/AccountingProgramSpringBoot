<%--
  Created by IntelliJ IDEA.
  User: Art
  Date: 2020-12-05
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Invoice edited success full</title>
</head>
<body>
Your invoice was edited.
<c:forEach items="${companies}" var="company">
    <br><a href="http://localhost:8080/admin/company/all" style="text-decoration: none">Back to all company list</a>
</c:forEach>

</body>
</html>
