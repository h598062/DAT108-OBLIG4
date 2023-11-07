<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="no">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/simple.css">
    <title>Påmeldingsbekreftelse</title>
</head>
<body>
<h2>Påmeldingsbekreftelse</h2>
<p>Påmeldingen er mottatt for</p>

<p> ${deltager.fornavn} ${deltager.etternavn} <br>
    ${deltager.mobil} <br>
    ${deltager.kjonn}
</p>

<a href="/deltagerliste">Gå til deltagerlisten</a>
</body>
</html>
