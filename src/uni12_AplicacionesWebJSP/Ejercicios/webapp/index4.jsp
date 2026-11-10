<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="style.css"/>

    <title>Conversor de Euros a Pesetas</title>
</head>
<body>
<%--12.5.5. Realiza un conversor de pesetas a euros.--%>

<form method="post" action="index4.jsp">
    Ingresa las pesetas: <input type="text" name="peseta">
    <input type="submit" value="Enviar">
</form>


<%
    String pesetasStr = request.getParameter("peseta");

    if (pesetasStr != null && !pesetasStr.isEmpty()) {
        double pesetas = Double.parseDouble(pesetasStr);
        double pesetasToEuros = pesetas / 166.386;
%>
<div class="resultado">
    <h3>Resultado</h3>
    <p><%= pesetas %> Pesetas equivalen a:</p>
    <p class="highlight"><%= String.format("%.2f", pesetasToEuros) %> €</p>
</div>

<%
    }
%>

</body>
</html>