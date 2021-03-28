<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Art
  Date: 2020-11-15
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create a new company</title>
</head>
<body>
    <div>
    <a href= "http://localhost:8080" style="text-decoration:none">Back to main menu</a>
    </div>
    <br>
<div>
    Please type your data:
</div>

<form:form method="post" modelAttribute="company">

        <br>
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

<%--    <div>--%>
<%--        <form:errors path="*"/>--%>
<%--    </div>--%>


    <br>
    <div>
        <input type="submit" value="Add company">
    </div>

    <link rel="stylesheet" href="../css/style.css">

</form:form>

</body>
</html>
