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

    <title>Números Aleatorios</title>
</head>
<body>

<%--12.5.15. Realiza una aplicación que genere 100 números aleatorios del 1 al 200. Los primos deberán aparecer en un
color diferente al resto.--%>

<form method="POST" action="index14.jsp">
    <input type="submit" name="generar" value="Generar Números">
</form>

<div class="resultado">
    <h3>Números Aleatorios (100)</h3>
    <%
        if (request.getParameter("generar") != null) {

            for (int i = 0; i < 100; i++) {
                int num = (int) (Math.random() * 200) + 1;
                boolean esPrimo = true;

                if (num < 2) esPrimo = false;
                for (int j = 2; j <= Math.sqrt(num); j++) {
                    if (num % j == 0) esPrimo = false;
                }

                if (esPrimo) {
                    out.print("<span style='color: red; font-weight: bold;'>" + num + " </span>");
                } else {
                    out.print("<span style='color: black;'>" + num + " </span>");
                }
            }
        }
    %>
</div>

</body>
</html>