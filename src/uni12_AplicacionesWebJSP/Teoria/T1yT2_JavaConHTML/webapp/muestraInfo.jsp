<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Muestra Información</title>
</head>
<body>

<h1>Información del Entrono de Trabajo</h1>

<%
    out.print("Fabricante de Java: " + System.getProperty("java.vendor"));
    out.print("<br>Url del Fabricante: " + System.getProperty("java.vendor.url"));
    out.print("<br>Version: " + System.getProperty("java.version"));
    out.print("<br>Sistema Operativo: " + System.getProperty("os.name"));
    out.print("<br>Usuario: " + System.getProperty("user.name"));
%>

</body>
</html>