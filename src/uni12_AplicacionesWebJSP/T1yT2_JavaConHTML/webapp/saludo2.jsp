<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Saludo2</title>
</head>
<body>

<%--1ra.Forma de mostrar mensaje--%>
<% out.println("<h1>¡Hola Mundo!</h1>"); %>

<%--2ra.Forma de mostrar mensaje (correcta)--%>
<% String saludo = "Hola mundo desde una variable"; %>

<h1><%= saludo %></h1>


</body>
</html>