<%@ page import="daw.GatosConClaseYBocadillos" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Gatos con clase y bocadillos</title>
    <link rel="stylesheet" type="text/css" href="estilos.css" />
</head>
<body>

<h1>Gatos con clase y bocadillos</h1>
<br>

<%
    GatosConClaseYBocadillos gato1 = new GatosConClaseYBocadillos("Menino", "img/gato.png");
    GatosConClaseYBocadillos gato2 = new GatosConClaseYBocadillos("Garfield", "img/garfield.jpg");
    GatosConClaseYBocadillos gato3 = new GatosConClaseYBocadillos("Tom", "img/tom.jpg");

    out.print(gato1);
    out.print(gato2);
    out.print(gato3);
    out.print(gato1.maulla());
    out.print(gato2.come("Atun."));
%>

</body>
</html>