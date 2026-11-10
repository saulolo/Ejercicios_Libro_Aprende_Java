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
    <link rel="stylesheet" type="text/css" href="style-tablero.css"/>

    <title>Tres en Raya</title>
    <style>

    </style>
</head>
<body>

<%--12.5.23. Realiza una aplicación que genere de forma aleatoria una partida finalizada del juego del tres en raya
teniendo en cuenta que el tablero tiene tres filas por tres columnas y hay tres círculos y tres cruces que no se pueden
solapar. No hay que programar el juego, simplemente mostrar cómo quedaría una partida una vez que ha finalizado.--%>



<%
    List<String> boardList = new ArrayList<>();

    for (int i = 0; i < 3; i++) {
        boardList.add("img/x_tres_raya.png");
        boardList.add("img/o_tres_raya.png");
        boardList.add("");
    }

    Collections.shuffle(boardList);
%>

<div class="contenedor-juego">
    <h1>Partida Finalizada</h1>

    <table class="tablero">
        <%
            for (int row = 0; row < 3; row++) {
        %>
        <tr>
            <%
                for (int col = 0; col < 3; col++) {
                    int cellIndex = (row * 3) + col;
                    String cellContent = boardList.get(cellIndex);
            %>
            <td>
                <% if (!cellContent.isEmpty()) { %>
                <img src="<%= cellContent %>" alt="ficha">
                <% } %>
            </td>
            <%
                }
            %>
        </tr>
        <%
            }
        %>
    </table>

    <a href="" class="btn-recargar">Nueva Partida</a>
</div>

</body>
</html>