<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="no">
<head>
	<link rel="stylesheet" href="css/simple.css">
	<link rel="stylesheet" href="css/navbar.css">
	<title>Påmelding</title>
</head>

<body>
<fieldset class="navbar">
	<c:choose>
		<c:when test="${bruker eq null}">
			<div>
				<form action="/login" method="get">
					<button type="submit">Logg inn</button>
				</form>
			</div>
		</c:when>
		<c:otherwise>
			<div>
				<form action="/deltagerliste" method="get">
					<button type="submit">Deltagerliste</button>
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
		</c:otherwise>
	</c:choose>
</fieldset>
<h2>Påmelding</h2>
<p style="color:red;">${feilmeldinger}</p>
<form action="/paamelding" method="post">
	<fieldset id="rot">

		<label>Fornavn <br>
			<input type="text" name="fornavn" id="fornavn" value="${deltager.fornavn}"/><br></label>

		<label>Etternavn<br>
			<input type="text" name="etternavn" id="etternavn" value="${deltager.etternavn}"/><br></label>

		<label>Mobil (8 siffer)<br>
			<input type="text" name="mobil" id="mobil" value="${deltager.mobil}"/><br></label>

		<label>Passord<br>
			<input type="password" name="passord" id="passord"/><br></label>
		<label>Passord repetert<br>
			<input type="password" name="passordRepetert" id="passordRepetert"/><br></label>

		<label>Kjønn <br>
			<input type="radio" name="kjonn" value="mann" checked="checked" id="kjonnMann"/>mann
			<input type="radio" name="kjonn" value="kvinne" id="kjonnKvinne"/>kvinne <br></label>

		<br><br>
		<button id="submit-btn" type="submit">Meld meg på</button>
	</fieldset>
</form>
<script src="js/validering.js" defer></script>
</body>
</html>
