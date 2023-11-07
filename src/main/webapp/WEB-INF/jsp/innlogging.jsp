<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/simple.css">
<title>Logg inn</title>
</head>
<body>
	<h2>Logg inn</h2>
	<p style="color:red;">Du er logget ut</p>
	<form method="post" action="/login">
		<fieldset>
			<label for="mobil">Mobil:</label> <input type="text" name="mobil" id="mobil"/>
			<label for="passord">Passord:</label> <input type="password" name="passord" id="passord"/>
			<br><br><button type="submit">Logg inn</button>
		</fieldset>
	</form>

</body>
</html>
