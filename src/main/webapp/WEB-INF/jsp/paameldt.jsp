<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="no">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/simple.css">
    <link rel="stylesheet" href="css/navbar.css">
    <title>Påmeldingsbekreftelse</title>
</head>
<body>
<table class="navbar">
    <tr>
        <td>
            <form action="/paamelding" method="get">
                <button type="submit">Registrer ny Påmelding</button>
            </form>
        </td>
        <td>
            <form action="/logut" method="post">
                <button type="submit">Logg ut</button>
            </form>
        </td>
        <td>
            Du er logget inn som ${bruker.fornavn} ${bruker.etternavn}
        </td>
    </tr>
</table>
<h2>Påmeldingsbekreftelse</h2>
<p>Påmeldingen er mottatt for</p>

<p> ${deltager.fornavn} ${deltager.etternavn} <br>
    ${deltager.mobil} <br>
    <c:choose>
        <c:when test="${deltager.kjonn eq 'mann'}">
            Mann
        </c:when>
        <c:when test="${deltager.kjonn eq 'kvinne'}">
            Kvinne
        </c:when>
        <c:otherwise>
            Annet
        </c:otherwise>
    </c:choose>
</p>

<a href="/deltagerliste">Gå til deltagerlisten</a>
</body>
</html>
