<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Art
  Date: 2020-11-30
  Time: 09:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit your invoice</title>
</head>
<body>
<div>

    <c:url var="edit_url" value="/invoice/edit"/>
    <form:form method="post" modelAttribute="invoice" action="${edit_url}">
        <form:hidden path="id"/>
        <form:hidden path="company"/>


    <div>
        <label for="invoiceNumber">Enter new invoice number:</label>
        <form:input path="invoiceNumber"/>
        <form:errors path="invoiceNumber"/>
    </div>
    <div>
        <label for="date" datatype="dd/MM/yyyy">Enter new date:</label>
        <form:input path="date" type="date"/>
        <form:errors path="date"/>
    </div>

        <div>
            <label for="invoiceDirection">Select new direction:</label>
            <form:select path="invoiceDirection" items="${directions}" id="invoiceDirection" itemLabel="direction" itemValue="id"/>
            <form:errors path="invoiceDirection"/>
        </div>

    <div>
        <label for="amountNetto">Enter new amount netto:</label>
        <form:input path="amountNetto"/>
        <form:errors path="amountNetto"/>
    </div>

        <div>
        <label for="vat">Select new rate of vat:</label>
        <form:select path="vat" items="${vates}" id="vat" itemValue="id" itemLabel="percents"/>
        <form:errors path="vat"/>
    </div>

        <div>
        <label for="amountBrutto">Enter new amount brutto:</label>
        <form:input path="amountBrutto"/>
        <form:errors path="amountBrutto"/>
    </div>


    <br>
    <div>
        <input type="submit" value="Edit invoice">
    </div>


    </form:form>
        <script type="text/javascript" src="../../js/counting.js"></script>

</body>
</html>
