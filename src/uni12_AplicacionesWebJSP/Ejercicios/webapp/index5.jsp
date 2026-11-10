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
<%--12.5.6. Realiza un conversor de Euros a Pesetas.--%>

<form method="post" action="index5.jsp">
    Ingresa los Euros: <input type="text" name="euros">
    <input type="submit" value="Enviar">
</form>


<%
    String eurosStr = request.getParameter("euros");

    if (eurosStr != null && !eurosStr.isEmpty()) {
        double euros = Double.parseDouble(eurosStr);
        double eurosToPesetas = euros * 166.386;
%>
<div class="resultado">
    <h3>Resultado</h3>
    <p><%= euros %> Euros equivalen a:</p>
    <p class="highlight"><%= String.format("%.2f", eurosToPesetas) %> Pesetas</p>
</div>

<%
    }
%>

</body>
</html>