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

    <title>Configuración Interior Vehiculo</title>
</head>
<body>

<%--12.5.17. Realiza un configurador del interior de un vehículo. El usuario puede elegir, mediante un formulario, el
color de la tapicería – blanco, negro o berenjena - y el material de las molduras – madera o carbono. Se debe mostrar el
interior del coche tal y como lo quiere el usuario.--%>

<form method="POST" action="index16.jsp">
    <h1>Interior del Coche</h1>
    <fieldset>
        <label>
            <legend><strong>Elige el color de la tapicerica: </strong></legend>
            Blanco <input type="radio" name="tapiceria" value="blanco">
            Negro <input type="radio" name="tapiceria" value="negro" checked>
            Berenjena <input type="radio" name="tapiceria" value="berenjena">
        </label><br><br>

        <label>
            <legend><strong>Elige el material de las molduras: </strong></legend>
            Madera <input type="radio" name="material" value="madera">
            Carbono <input type="radio" name="material" value="carbono" checked>
        </label>
    </fieldset><br>
    <input type="submit" value="Enviar">
</form>


<%
    String tapiceria = request.getParameter("tapiceria");
    String material = request.getParameter("material");

    if (tapiceria != null && material != null) {
       String nombreImagen = "img/" + tapiceria + "_" + material + ".jpg";
%>

<div class="resultado" style="margin-top: 25px; text-align: center;">
    <h3>Tu Configuración Personalizada</h3>
    <p>Tapicería: <strong><%= tapiceria.toUpperCase() %></strong> | Molduras: <strong><%= material.toUpperCase() %></strong></p>

    <img src="<%= nombreImagen %>" width="450" style="border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.2);" alt="Interior del coche">
</div>



<%
    }
%>


</body>
</html>