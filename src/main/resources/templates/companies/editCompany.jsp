<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Art
  Date: 2020-11-21
  Time: 09:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit your company</title>
</head>
<body>
<div>
<a href= "http://localhost:8080/admin/company/all" style="text-decoration:none">Back to company list</a>
</div>
<br>
Eneter new data:

<div>

    <c:url var="edit_url" value="/admin/company/edit"/>
    <form:form method="post" modelAttribute="company" action="${edit_url}">
        <form:hidden path="id"/>
    <div>
        <label for="name">Company Name:</label>
        <form:input path="name"/>
        <form:errors path="name"/>
    </div>

    <div>
        <label for="address">Address:</label>
        <form:input path="address"/>
        <form:errors path="address"/>
    </div>
    <div>
        <label for="email">E-mail:</label>
        <form:input path="email"/>
        <form:errors path="email"/>
    </div>

    <div>
        <label for="NIP">NIP:</label>
        <form:input path="NIP"/>
        <form:errors path="NIP"/>
    </div>
    <div>
        <label for="bankAccount">Bank Account:</label>
        <form:input path="bankAccount"/>
        <form:errors path="bankAccount"/>
    </div>


    <br>
    <div>
        <input type="submit" value="Edit company">
    </div>


        <link rel="stylesheet" href="../css/style.css">
    </form:form>


</body>
</html>
