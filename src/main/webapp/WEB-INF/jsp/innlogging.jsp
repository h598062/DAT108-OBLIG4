<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/simple.css">
    <link rel="stylesheet" href="css/navbar.css">
    <title>Logg inn</title>
</head>
<body>
<table class="navbar">
    <tr>
        <td><a href="/">Hjem</a></td>
        <td><a href="/paamelding">Registrer ny Påmelding</a></td>
        <td><a href="/deltagerliste">Deltagerliste</a></td>
        <td><a href="/logut">Logg ut</a></td>
        <td><a href="/login">Logg inn</a></td>
    </tr>
</table>
<h2>Logg inn</h2>
<p style="color:red;">${feilmelding}</p>
<form method="post" action="/login">
    <fieldset>
        <label for="mobil">Mobil:</label> <input type="text" name="mobil" id="mobil"/>
        <label for="passord">Passord:</label> <input type="password" name="passord" id="passord"/>
        <br><br>
        <button type="submit">Logg inn</button>
    </fieldset>
</form>

</body>
</html>
