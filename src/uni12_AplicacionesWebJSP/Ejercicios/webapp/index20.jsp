<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="style-helados.css"/>

    <title>Maquina de Helados</title>
    <style>

    </style>
</head>
<body>

<%--12.5.20. Implementa una máquina de helados. El usuario indica los porcentajes de helado de chocolate, de fresa y de
vainilla. Los porcentajes deben ser números comprendidos entre 0 y 100. Si los porcentajes suman más de 100, se debe dar
un mensaje al usuario que diga “La suma de los porcentajes debe ser menor o igual que 100. Por favor, introduzca de nuevo
los porcentajes”. En caso de que los porcentajes sean correctos, se mostrará la tarrina con los sabores adecuados y los
tamaños bien dimensionados según los porcentajes, tal y como se muestra en los ejemplos. Hay que tener en cuenta que si
los sabores no suman el 100% de la tarrina, se debe mostrar el hueco correspondiente. En caso de que no se incluya algún
sabor (sabor al 0%), no debe aparecer ninguna referencia a dicho sabor en la tarrina.--%>


<form method="post" action="index20.jsp">
    <h1>Máquina de helados</h1>
    <fieldset>
        <legend><strong>Selecciona los porcentajes para preparar un helado a gusto:</strong></legend>
        <br>
        <div class="helados-container">
            <div class="helado-card">
                <img src="img/helado_chocolate.jpeg" width="90" alt="Helado de Chocolate">
                <br>
                <label>Chocolate</label>
                <input type="number" name="chocolate" value="0" min="0" max="100" required> %
            </div>

            <div class="helado-card">
                <img src="img/helado_fresa.jpeg" width="90" alt="Helado de Fresa">
                <br>
                <label>Fresa</label>
                <input type="number" name="fresa" value="0" min="0" max="100" required> %
            </div>

            <div class="helado-card">
                <img src="img/helado_vainilla.jpeg" width="90" alt="Helado de Vainilla">
                <br>
                <label>Vainilla</label>
                <input type="number" name="vainilla" value="0" min="0" max="100" required> %
            </div>
        </div>
        <br>
        <input type="submit" value="Preparar helado">
    </fieldset>
</form>

<%
    String chocolateStr = request.getParameter("chocolate");

    if (chocolateStr != null && !chocolateStr.isEmpty()) {
        int porcentajeChocolate = Integer.parseInt(chocolateStr);
        int porcentajeFresa = Integer.parseInt(request.getParameter("fresa"));
        int porcentajeVainilla = Integer.parseInt(request.getParameter("vainilla"));

        int sumaSabores = porcentajeChocolate + porcentajeFresa + porcentajeVainilla;

        if (sumaSabores > 100) {
%>
<div class="contenedor-resultado">
    <div class="mensaje-error">
        <p>La suma de los porcentajes no puede ser mayor que el 100%.</p>
        <p>Por favor, introduzca de nuevo los porcentajes.</p>
    </div>
</div>
<%
} else {
%>
<div class="contenedor-resultado">
    <h3>Aquí tiene su tarrina de helado</h3>

    <!-- Contenedor del vaso de la tarrina -->
    <div class="vaso-tarrina" style="display: flex; flex-direction: column-reverse; justify-content: flex-end;">

        <% if (porcentajeVainilla > 0) { %>
        <div class="sabor-vainilla" style="height: <%= porcentajeVainilla %>%;">
            Vainilla <%= porcentajeVainilla %>%
        </div>
        <% } %>

        <% if (porcentajeFresa > 0) { %>
        <div class="sabor-fresa" style="height: <%= porcentajeFresa %>%;">
            Fresa <%= porcentajeFresa %>%
        </div>
        <% } %>

        <% if (porcentajeChocolate > 0) { %>
        <div class="sabor-chocolate" style="height: <%= porcentajeChocolate %>%;">
            Chocolate <%= porcentajeChocolate %>%
        </div>
        <% } %>

    </div>
</div>
<%
        }
    }
%>

</body>
</html>