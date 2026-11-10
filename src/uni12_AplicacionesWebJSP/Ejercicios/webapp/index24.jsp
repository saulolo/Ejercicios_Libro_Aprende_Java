<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="style-dados.css"/>

    <title>Tirada de Dados</title>
    <style>

    </style>
</head>
<body>

<%--12.5.25. Realiza un programa en JSP que haga tiradas consecutivas de tres dados (en la misma pantalla). El programa
parará cuando, en la misma tirada, los tres dados tengan el mismo valor.--%>

<div class="contenedor-dados">
    <h1>Tirada Consecutiva de Dados</h1>
    <p>El juego se detendrá automáticamente cuando los tres dados coincidan.</p>

    <div class="tiradas-lista">
        <%
            int dado1, dado2, dado3;
            int totalTiradas = 0;

            do {
                totalTiradas++;

                // Generamos 3 números aleatorios entre 1 y 6
                dado1 = (int) (Math.random() * 6) + 1;
                dado2 = (int) (Math.random() * 6) + 1;
                dado3 = (int) (Math.random() * 6) + 1;
        %>
        <!-- Mostramos la fila con la tirada actual -->
        <div class="fila-tirada">
            <span class="numero-tirada">Tirada <%= totalTiradas %>:</span>
            <img src="img/dado_<%= dado1 %>.png" alt="Dado <%= dado1 %>">
            <img src="img/dado_<%= dado2 %>.png" alt="Dado <%= dado2 %>">
            <img src="img/dado_<%= dado3 %>.png" alt="Dado <%= dado3 %>">
        </div>
        <%
                // La condición de parada: continúa si NO son los tres iguales
            } while (dado1 != dado2 || dado2 != dado3);
        %>
    </div>

    <div class="resultado-final">
        <h3>¡Trío conseguido! 🎉</h3>
        <p>Los tres dados han sacado el número <strong><%= dado1 %>
        </strong>.</p>
        <p>Se necesitaron <strong><%= totalTiradas %>
        </strong> tiradas en total.</p>
        <a href="" class="btn-tirar">Lanzar de nuevo</a>
    </div>
</div>

</body>
</html>