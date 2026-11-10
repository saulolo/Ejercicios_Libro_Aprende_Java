<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="style-ajedrez.css"/>

    <title>Tablero de Ajedrez - Alfil y Caballo</title>
    <style>

    </style>
</head>
<body>

<%--12.5.19. Crea una aplicación que dibuje un tablero de ajedrez mediante una tabla HTML generada con bucles usando JSP
y que sitúe dentro del tablero un alfil y un caballo en posiciones aleatorias. Las dos figuras no pueden estar colocadas
en la misma casilla. Las filas y las columnas del tablero deben estar etiquetadas correctamente.--%>



<h1>Tablero de Ajedrez Aleatorio</h1>

<%
    // 1. Generamos la posición aleatoria del ALFIL (Filas de 1 a 8, Columnas de 1 a 8)
    int filaAlfil = (int) (Math.random() * 8) + 1;
    int colAlfil = (int) (Math.random() * 8) + 1;

    // 2. Generamos la posición del CABALLO asegurando que NO colisione con el alfil
    int filaCaballo;
    int colCaballo;
    do {
        filaCaballo = (int) (Math.random() * 8) + 1;
        colCaballo = (int) (Math.random() * 8) + 1;
    } while (filaCaballo == filaAlfil && colCaballo == colAlfil);

    // Array auxiliar para mapear números de columna a letras oficiales
    char[] letrasColumnas = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
%>

<p>
    <strong>Alfil (♝):</strong> <%= letrasColumnas[colAlfil - 1] %><%= filaAlfil %> |
    <strong>Caballo (♞):</strong> <%= letrasColumnas[colCaballo - 1] %><%= filaCaballo %>
</p>

<div class="tablero-container">
    <table>
        <!-- Fila superior de coordenadas (letras) -->
        <tr>
            <th></th> <!-- Esquina vacía -->
            <% for (char letra : letrasColumnas) { %>
            <th><%= letra %></th>
            <% } %>
            <th></th>
        </tr>

        <%
            // 3. Bucle de Filas: en ajedrez la fila 8 está arriba y la 1 abajo
            for (int fila = 8; fila >= 1; fila--) {
        %>
        <tr>
            <!-- Etiqueta de número de fila a la izquierda -->
            <th><%= fila %></th>

            <%
                // Bucle de Columnas: de la 1 ('a') a la 8 ('h')
                for (int col = 1; col <= 8; col++) {

                    // Algoritmo para alternar colores blanco y negro
                    String claseColor = ((fila + col) % 2 == 0) ? "negra" : "blanca";
            %>
            <td class="<%= claseColor %>">
                <%
                    // Comprobamos si esta casilla coincide con alguna de las dos piezas
                    if (fila == filaAlfil && col == colAlfil) {
                        out.print("<span class='pieza'>♝</span>"); // Alfil
                    } else if (fila == filaCaballo && col == colCaballo) {
                        out.print("<span class='pieza'>♞</span>"); // Caballo
                    }
                %>
            </td>
            <%
                }
            %>

            <!-- Etiqueta de número de fila a la derecha -->
            <th><%= fila %></th>
        </tr>
        <%
            }
        %>

        <!-- Fila inferior de coordenadas (letras) -->
        <tr>
            <th></th>
            <% for (char letra : letrasColumnas) { %>
            <th><%= letra %></th>
            <% } %>
            <th></th>
        </tr>
    </table>
</div>

<br>
<form method="get" action="">
    <button type="submit" style="padding: 10px 20px; font-size: 16px; cursor: pointer; border-radius: 6px; background-color: #4CAF50; color: white; border: none;">
        Nueva Tirada Aleatoria
    </button>
</form>


</body>
</html>