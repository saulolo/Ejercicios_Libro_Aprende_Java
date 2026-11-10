<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="style.css"/>

    <title>Apuesta y gana</title>
</head>
<body>

<%--12.5.18. Crea el juego “Apuesta y gana”. El usuario debe introducir inicialmente una cantidad de dinero.
A continuación aparecerá por pantalla una imagen de forma aleatoria. Si sale una calavera, el usuario pierde todo su
dinero y termina el juego. Si sale medio limón, el usuario pierde la mitad del dinero y puede seguir jugando con esa
cantidad o puede dejar de jugar. Si sale el gato chino de la suerte, el usuario multiplica por dos su dinero y puede
seguir jugando con esa cantidad o puede dejar de jugar.--%>


<%
    // 1. Gestionamos el saldo a través de la sesión para que no se pierda entre jugadas
    Integer dinero = (Integer) session.getAttribute("saldo");
    String dineroStr = request.getParameter("dinero");
    String accion = request.getParameter("accion");

    // Si el usuario le da a "Reiniciar", borramos la sesión
    if ("reiniciar".equals(accion)) {
        session.invalidate();
        response.sendRedirect("index18.jsp");
        return;
    }

    // Si es la primera vez y envía el dinero inicial
    if (dineroStr != null && !dineroStr.isEmpty() && dinero == null) {
        dinero = Integer.parseInt(dineroStr);
        session.setAttribute("saldo", dinero);
    }
%>

<div class="resultado" style="margin-top: 25px; text-align: center;">
    <h1>Apuesta y Gana</h1>

    <%
        // Si aún no hay dinero en sesión, mostramos el formulario inicial
        if (dinero == null) {
    %>
    <form action="index18.jsp" method="post">
        <label>Introduce tu dinero inicial:</label><br>
        <input type="number" name="dinero" min="1" required /><br><br>
        <button type="submit">Empezar a Jugar</button>
    </form>
    <%
    } else {
    %>
    <!-- Si ya hay dinero, mostramos el saldo y las opciones de juego -->
    <h2>Tu saldo actual: <%= dinero %> $</h2>

    <%
        // Si el usuario hizo clic en "Tirar" y aún tiene dinero
        String jugar = request.getParameter("jugar");
        int resultadoTirada = 0;

        if (jugar != null && dinero > 0) {
            resultadoTirada = (int) (Math.random() * 3) + 1;

            if (resultadoTirada == 1) {
                dinero = 0;
            } else if (resultadoTirada == 2) {
                dinero = dinero / 2;
            } else {
                dinero = dinero * 2;
            }

            // Actualizamos el saldo en la sesión
            session.setAttribute("saldo", dinero);
        }
    %>

    <% if (dinero > 0) { %>
    <!-- Si sigue teniendo dinero, mostramos los botones de acción -->
    <form action="index18.jsp" method="post">
        <input type="hidden" name="jugar" value="1">
        <button type="submit" style="background-color: #2196F3;">¡Tirar la suerte!</button>
    </form>
    <br>
    <form action="index18.jsp" method="post">
        <input type="hidden" name="accion" value="reiniciar">
        <button type="submit" style="background-color: #f44336;">Retirarse y Cobrar</button>
    </form>
    <% } else { %>
    <!-- Si el dinero llegó a 0 -->
    <h2 style="color: red;">¡GAME OVER! Has perdido todo tu dinero.</h2>
    <form action="index18.jsp" method="post">
        <input type="hidden" name="accion" value="reiniciar">
        <button type="submit">Jugar de nuevo</button>
    </form>
    <% } %>

    <%
        // Mostramos la imagen solo si se acaba de hacer una tirada
        if (jugar != null && resultadoTirada > 0) {
    %>
    <div style="margin-top: 20px;">
        <% if (resultadoTirada == 1) { %>
        <img src="img/calavera.gif" width="120" alt="Calavera"><br>
        <p class="highlight" style="color: red;">¡Ha salido una Calavera! Has perdido todo tu dinero. Tienes: <%= dinero%></p>
        <% } else if (resultadoTirada == 2) { %>
        <img src="img/medio_limon.gif" width="120" alt="Medio Limón"><br>
        <p class="highlight" style="color: orange;">¡Ha salido Medio Limón! Pierdes la mitad de tu dinero. Tienes: <%= dinero%></p>
        <% } else { %>
        <img src="img/gato_chino.gif" width="120" alt="Gato Chino"><br>
        <p class="highlight" style="color: green;">¡Ha salido el Gato Chino de la Suerte! ¡Has duplicado tu dinero! Tieens: <%= dinero%></p>
        <% } %>
    </div>
    <%
        }
    %>

    <%
        }
    %>

</div>

</body>
</html>