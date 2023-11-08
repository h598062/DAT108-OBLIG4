<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="no">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/simple.css">
	<link rel="stylesheet" href="css/navbar.css">
	<title>Deltagerliste</title>
</head>
<body>
<fieldset class="navbar">
	<div>
		<form action="/paamelding" method="get">
			<button type="submit">Registrer ny Påmelding</button>
		</form>
	</div>
	<div>
		<form action="/logut" method="post">
			<button type="submit">Logg ut</button>
		</form>
	</div>
	<div>
		<p>Innlogget som ${bruker.fornavn} ${bruker.etternavn}</p>
	</div>
</fieldset>
<p>Innlogget som: ${bruker.mobil} / ${bruker.fornavn} ${bruker.etternavn}</p>
<h2>Deltagerliste</h2>
<fieldset>
	<table>
		<tr>
			<th>Kjønn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
		</tr>
		<c:forEach var="deltager" items="${deltagere}">
			<tr style=<c:if test="${deltager.mobil eq bruker.mobil}">"background-color:#418941"</c:if>>
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
	</table>
	<br>
	<form action="/logut" method="post">
		<button type="submit">Logg ut</button>
	</form>
</fieldset>
</body>
</html>
