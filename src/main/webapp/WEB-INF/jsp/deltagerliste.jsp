<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="no">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/simple.css">
    <title>Deltagerliste</title>
</head>
<body>
<p>Innlogget som: 90123456 / Arne Arnesen</p>
<h2>Deltagerliste</h2>
<table>
    <tr>
        <th>Kjønn</th>
        <th align="left">Navn</th>
        <th align="left">Mobil</th>
    </tr>
    <c:forEach var="deltager" items="${deltagere}">
        <tr style="">
            <td align="center">&#9792;</td>
            <td>${deltager.fornavn} ${deltager.etternavn}</td>
            <td>${deltager.mobil}</td>
        </tr>
    </c:forEach>
    <%--  Beholder denne for referanse, fjernes når innlogging er fungerende  --%>
    <tr style="background-color:#aaffaa">
        <td align="center">&#9794;</td>
        <td>Arne Arnesen</td>
        <td>901 23 456</td>
    </tr>
</table>
<br>
<form action="utlogging" method="post">
    <button type="submit">Logg ut</button>
</form>
</body>
</html>
