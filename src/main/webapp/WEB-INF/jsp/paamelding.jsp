<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="no">
<head>
    <link href="css/simple.css" rel="stylesheet" type="text/css" />
    <title>Påmelding</title>
</head>

<body>
    <h2>Påmelding</h2>
    <p style="color:red;">Påmeldingsdetaljer er ugyldige</p>
    <form method="post">
        <fieldset>

            <label>Fornavn <br>
            <input type="text" name="fornavn" /><br></label>

            <label>Etternavn<br>
            <input type="text" name="etternavn" /><br></label>

            <label>Mobil (8 siffer)<br>
            <input type="text" name="mobil" /><br></label>

            <label>Passord<br>
            <input type="password" name="passord" /><br></label>
            <label>Passord repetert<br>
            <input type="password" name="passordRepetert" /><br></label>

            <label>Kjønn <br>
            <input type="radio" name="kjonn" value="mann" checked="checked" />mann
            <input type="radio" name="kjonn" value="kvinne" />kvinne <br></label>

            <br><br><button type="submit">Meld meg på</button>
        </fieldset>
    </form>
</body>
</html>
