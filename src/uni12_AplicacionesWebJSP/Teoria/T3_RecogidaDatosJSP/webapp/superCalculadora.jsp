<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Super Calculadora</title>
</head>
<body>

<h1>Suma de dos números</h1>

<form method="post" action="calculadora.jsp">
    Introduzca dos números a sumar (puede tener decimales):
    <input type="number" name="primerNumero">
    <input type="number" name="segundoNumero">
    <input type="submit" value="OK">
</form>
</body>
</html>