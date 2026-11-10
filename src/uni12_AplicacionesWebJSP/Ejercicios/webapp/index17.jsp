<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="style.css"/>

    <title>El Trile</title>
</head>
<body>

<%--12.5.17. Crea la aplicación “El Trile”. Deben aparecer tres cubiletes por pantalla y el usuario deberá seleccionar
uno de ellos. Para dicha selección se puede usar un formulario con radio-button, una lista desplegable, hacer clic en el
cubilete o lo que resulte más fácil. Se levantarán los tres cubiletes y se verá si estaba o no la bolita dentro del que
el usuario indicó, así mismo, se mostrará un mensaje diciendo “Lo siento, no has acertado” o “¡Enhorabuena!, has
encontrado la bolita”. La probabilidad de encontrar la bolita es de 1/3.--%>


<form action="index17.jsp" method="POST">
    <label for="usuario">Elije un cubilete:</label>
    <select id="usuario" name="usuario">
        <option value="cubileta1">Cubileta 1</option>
        <option value="cubileta2">Cubileta 2</option>
        <option value="cubileta3">Cubileta 3</option>
    </select><br><br>
    <input type="submit" value="Elegir">
</form>


<%
    String cubileteSeleccionado = request.getParameter("usuario");


    if (cubileteSeleccionado != null) {
        int eleccionUsuario = 1;
        if (cubileteSeleccionado.equals("cubileta2")) eleccionUsuario = 2;
        if (cubileteSeleccionado.equals("cubileta3")) eleccionUsuario = 3;

        int posicionBolita = (int) (Math.random() * 3) + 1;

        boolean acertado = (eleccionUsuario == posicionBolita);


%>

<div class="resultado" style="margin-top: 25px; text-align: center;">
    <h3>Resultado de la jugada</h3>

    <div style="display: flex; justify-content: center; gap: 15px; margin: 20px 0; background: none; box-shadow: none; padding: 0;">
        <%
            for (int i = 1; i <= 3; i++) {
                if (i == posicionBolita) {
        %>
        <div>
            <img src="img/cubiltete_bolita.jpg" width="100" alt="Con bolita"><br>
            <span>Cubilete <%= i %></span>
        </div>
        <%
        } else {
        %>
        <div>
            <img src="img/cubilete_vacio.jpg" width="100" alt="Vacío"><br>
            <span>Cubilete <%= i %></span>
        </div>
        <%
                }
            }
        %>
    </div>

    <p class="highlight">
        <%= acertado ? "🎉 ¡Enhorabuena!, has encontrado la bolita." : "❌ Lo siento, no has acertado." %>
    </p>
</div>

<%
    }
%>


</body>
</html>