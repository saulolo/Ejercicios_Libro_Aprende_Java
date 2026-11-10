<%@ page import="javax.swing.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="style.css"/>

    <title>Tirando dados</title>
</head>
<body>

<%--12.5.16. Realiza una aplicación que muestre la tirada aleatoria de tres dados de póker.
Utiliza imágenes de dados reales.--%>

<form method="post" action="index15.jsp">
    <input type="submit" name="dados" value="Tirar dados">
</form>

<%
    Integer contador = (Integer) session.getAttribute("conteoDados");

    if (contador == null) {
        contador = 0;
    }

    String dadosStr = request.getParameter("dados");

    if (dadosStr != null) {
        contador++;
        session.setAttribute("conteoDados", contador);

        int dado1 = (int) (Math.random() * 6) + 1;
        int dado2 = (int) (Math.random() * 6) + 1;
        int dado3 = (int) (Math.random() * 6) + 1;

%>

<div class="resultado">
    <h3>Lanzamiento número: <%= contador %></h3>
    <img src="img/dadoC<%= dado1 %>.png" width="100" alt="Dado <%= dado1 %>">
    <img src="img/dadoC<%= dado2 %>.png" width="100" alt="Dado <%= dado2 %>">
    <img src="img/dadoC<%= dado3 %>.png" width="100" alt="Dado <%= dado3 %>">
</div>


<%
    }
%>


</body>
</html>