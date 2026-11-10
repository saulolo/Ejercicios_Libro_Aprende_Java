<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Animales</title>
</head>
<body>

<h1>Seleccionando Animales</h1>

<form method="post" action="animales.jsp">
    Seleccione el animal a visualizar:
    <select name="animal">
        <option value="Gato">Gato</option>
        <option value="Caracol">Caracol</option>
        =
    </select>
    <br>
    Número de animales: <input type="text" name="numero" size="3">
    <br>
    <input type="submit" value="Enviar">

</form>
</body>
</html>