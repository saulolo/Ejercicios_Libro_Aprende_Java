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

Resultado:

<%
    int resultado = Integer.parseInt(request.getParameter("primerNumero")) + Integer.parseInt(request.getParameter("segundoNumero"));
    out.print(resultado);
%>

</body>
</html>