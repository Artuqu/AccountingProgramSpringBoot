<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%--
  Created by IntelliJ IDEA.
  User: Art
  Date: 2020-11-21
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Invoices Database</title>
</head>
<body>

<div>
    <a href=http://localhost:8080/admin/company/all style="text-decoration:none">Back to company list</a>
</div>
<br>

<div>There are all invoiced for your company:</div>
<br>
<table border="5" color="blue">

    <thead>
    <th>Lp.</th>
    <th>Number</th>
    <%--    <th>Company name</th>--%>
    <th>Date</th>
    <th>Direction</th>
    <th>Netto</th>
    <th>Vat</th>
    <th>Brutto</th>
    <th>Action</th>

    </thead>

    <tbody>

    <c:forEach items="${invoices}" var="invoice">
        <tr>
            <td><c:out value="${invoice.id}"/></td>
            <td><c:out value="${invoice.invoiceNumber}"/></td>
                <%--            <td><c:out value="${invoice.company.id}"/></td>--%>
            <td><c:out value="${invoice.date}"/></td>
            <td><c:out value="${invoice.invoiceDirection.direction}"/></td>
            <td id="aN"><c:out value="${invoice.amountNetto}"/></td>
            <td><c:out value="${invoice.vat.percents}"/></td>
            <td><c:out value="${invoice.amountBrutto}"/></td>
            <td>
                <br><a href="http://localhost:8080/invoice/delete/${invoice.id}" style="text-decoration:none">Delete</a>
                <br><a href="http://localhost:8080/invoice/edit/${invoice.id}"
                       style="text-decoration: none">Edit</a>
            </td>
        </tr>

        <link rel="stylesheet" href="../css/style.css">
    </c:forEach>


    </tbody>

</table>

<%--selling view--%>
<br>
<table border="3">

    <th>
        Here is count of your sell invoices
    </th>


</table>
<table border="3">
    <thead>
    <th>Total of brutto</th>
    <th>Total of netto</th>
    <th>Total of vat</th>

    </thead>

    <tbody>
    <tr>
        <c:forEach items="${bruttosSell}" var="bruttosSell">

            <td><c:out value="${bruttosSell}"/></td>
        </c:forEach>

        <c:forEach items="${nettosSell}" var="nettosSell">
            <td><c:out value="${nettosSell}"/></td>
        </c:forEach>

        <c:forEach items="${allVatSell}" var="allVatSell">
            <td><c:out value="${allVatSell}"/></td>
        </c:forEach>


    </tr>

    </tbody>
</table>



<%--buying view--%>
<br>
<table border="3">

    <th>
        Here is count of your buy invoices
    </th>


</table>
<table border="3">
    <thead>
    <th>Total of brutto</th>
    <th>Total of netto</th>
    <th>Total of vat</th>

    </thead>

    <tbody>
    <tr>
        <c:forEach items="${bruttosBuy}" var="bruttosBuy">

        <td><c:out value="${bruttosBuy}"/></td>
        </c:forEach>


        <c:forEach items="${nettosBuy}" var="nettosBuy">
        <td><c:out value="${nettosBuy}"/></td>
        </c:forEach>


        <c:forEach items="${allVatBuy}" var="allVatBuy">
        <td><c:out value="${allVatBuy}"/></td>
        </c:forEach>


            </tr>

            </tbody>
        </table>

</body>
</html>