<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="style.css" />

    <title>Datos Personales</title>
</head>
<body>
<%--12.5.3. Escribe una aplicación que pida tu nombre. A continuación mostrará “Hola” seguido del nombre introducido.
El nombre se deberá recoger mediante un formulario.--%>

<form method="post" action="datos2.jsp">
    Nombre: <input type="text" name="nombre">
    <input type="submit" value="Enviar">

</form>
</body>
</html>