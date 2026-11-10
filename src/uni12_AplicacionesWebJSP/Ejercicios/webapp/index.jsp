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
<%--12.5.1. Crea una aplicación web en Java que muestre tu nombre y tus datos personales por pantalla. La página principal
debe ser un archivo con la extensión jsp. Comprueba que se lanzan bien el servidor y el navegador web. Observa los mensajes
que da el servidor. Fíjate en la dirección que aparece en la barra de direcciones del navegador.

12.5.2. Mejora el programa anterior de tal forma que la apariencia de la página web que muestra el navegador luzca más
bonita mediante la utilización de CSS (utiliza siempre ficheros independientes para CSS para no mezclarlo con HTML).--%>

<form method="post" action="datos.jsp">
    <br>
    Nombre: <input type="text" name="nombre">
    <br>
    Apellido: <input type="text" name="apellido">
    <br>
    Edad: <input type="number" name="edad">
    <br>
    Email: <input type="email" name="email">
    <br>
    <input type="submit" value="Enviar">

</form>
</body>
</html>