<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Art
  Date: 2020-11-15
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All companies</title>
</head>
<body>
<div>
    <a href="http://localhost:8080" style="text-decoration:none">Back to main menu</a>
</div>
<br>
<div>This is the list of all companies allowed in program:</div>
<br>
<table border="2" color="blue">

    <thead>
    <th>Lp.</th>
    <th>Name</th>
    <th>Address</th>
    <th>E-Mail</th>
    <th>Nip</th>
    <th>Bank Account</th>
    <th>Action</th>

    </thead>

    <tbody>

    <c:forEach items="${companies}" var="company">
        <tr>
            <td><c:out value="${company.id}"/></td>
            <td><c:out value="${company.name}"/></td>
            <td><c:out value="${company.address}"/></td>
            <td><c:out value="${company.email}"/></td>
            <td><c:out value="${company.NIP}"/></td>
            <td><c:out value="${company.bankAccount}"/></td>
            <td>


                <a href="http://localhost:8080/invoice/all/${company.id}" style="text-decoration: none">Show all invoice</a>
                <br>
                <br><a href="http://localhost:8080/invoice/add/${company.id}" style="text-decoration: none">Add invoice</a>
                <br>
                <br><a href="http://localhost:8080/admin/company/edit/${company.id}"
                       style="text-decoration: none">Edit Company</a>
                <br>
                <br><a href="http://localhost:8080/admin/company/delete/${company.id}" style="text-decoration:none">Delete Company</a>

            </td>
        </tr>

    <link rel="stylesheet" href="../css/style.css">
    </c:forEach>


    </tbody>
</table>


</body>
</html>
