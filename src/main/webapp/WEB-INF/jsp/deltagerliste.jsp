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
<p>Innlogget som: ${bruker.mobil} / ${bruker.fornavn} ${bruker.etternavn}</p>
<h2>Deltagerliste</h2>
<table>
    <tr>
        <th>Kjønn</th>
        <th align="left">Navn</th>
        <th align="left">Mobil</th>
    </tr>
    <c:forEach var="deltager" items="${deltagere}">
        <tr style="">
            <c:choose>
                <c:when test="${deltager.kjonn eq 'mann'}">
                    <td align="center">&#9794;</td>
                </c:when>
                <c:when test="${deltager.kjonn eq 'kvinne'}">
                    <td align="center">&#9792;</td>
                </c:when>
                <c:otherwise>
                    <td align="center">x</td>
                </c:otherwise>
            </c:choose>

            <td>${deltager.fornavn} ${deltager.etternavn}</td>
            <td>${deltager.mobil}</td>
        </tr>
    </c:forEach>
    <%--  Beholder denne for referanse, fjernes når innlogging er fungerende  --%>
    <tr style="background-color:#418941">
        <td align="center">&#9794;</td>
        <td>Arne Arnesen</td>
        <td>901 23 456</td>
    </tr>
</table>
<br>
<form action="/logut" method="post">
    <button type="submit">Logg ut</button>
</form>
</body>
</html>
