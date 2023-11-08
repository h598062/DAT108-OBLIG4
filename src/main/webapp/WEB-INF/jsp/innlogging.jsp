<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/simple.css">
    <link rel="stylesheet" href="css/navbar.css">
    <title>Logg inn</title>
</head>
<body>
<fieldset class="navbar">
    <div>
        <form action="/paamelding" method="get">
            <button type="submit">Registrer ny Påmelding</button>
        </form>
    </div>
</fieldset>
<h2>Logg inn</h2>
<p style="color:red;">${feilmelding}</p>
<form method="post" action="/login">
    <fieldset>
        <label for="mobil">Mobil: </label><input type="text" name="mobil" id="mobil" value="${mobil}"/>
        <label for="pass">Passord: </label><input type="password" name="passord" id="pass"/>
        <br>
        <button id="submit-btn" type="submit">Logg inn</button>
    </fieldset>
</form>
<script src="js/validering.js" defer></script>
</body>
</html>
