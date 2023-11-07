<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="no">
<head>
    <link href="css/simple.css" rel="stylesheet" type="text/css" />
    <title>Påmelding</title>
</head>

<body>
    <h2>Påmelding</h2>
    <form action="/paamelding" method="post" >
        <fieldset id="rot">

            <label>Fornavn <br>
            <input type="text" name="fornavn" id="fornavn" /><br></label>

            <label>Etternavn<br>
            <input type="text" name="etternavn" id="etternavn" /><br></label>

            <label>Mobil (8 siffer)<br>
            <input type="text" name="mobil" id="mobil" /><br></label>

            <label>Passord<br>
            <input type="password" name="passord" id="passord" /><br></label>
            <label>Passord repetert<br>
            <input type="password" name="passordRepetert" id="passordRepetert" /><br></label>

            <label>Kjønn <br>
            <input type="radio" name="kjonn" value="mann" checked="checked" id="kjonnMann"/>mann
            <input type="radio" name="kjonn" value="kvinne" id="kjonnKvinne" />kvinne <br></label>

            <br><br><button id="submit-btn" type="submit">Meld meg på</button>
        </fieldset>
    </form>
    <script src="js/validering.js" defer></script>
</body>
</html>
