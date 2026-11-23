<%@ page import="daw.Gato" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Gatos POO</title>
</head>
<body>

<h1>Gatos con Clase</h1>
<br>

<%
    Gato gato1 = new Gato("Menino", "img/gato.png");
    Gato gato2 = new Gato("Garfield", "img/garfield.jpg");
    Gato gato3 = new Gato("Tom", "img/tom.jpg");

    out.print(gato1);
    out.print(gato2);
    out.print(gato3);
    out.print(gato1.maulla());
    out.print(gato2.come("Atun."));
%>

</body>
</html>