<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="style.css" />

    <title>Promedio Notas</title>
</head>
<body>
<%--12.5.4. Realiza una aplicación que calcule la media de tres notas.--%>

<form method="post" action="promedioNotas.jsp">
    Nota 1: <input type="text" name="nota1">
    Nota 2: <input type="text" name="nota2">
    Nota 3: <input type="text" name="nota3">
    <input type="submit" value="Enviar">

</form>
</body>
</html>