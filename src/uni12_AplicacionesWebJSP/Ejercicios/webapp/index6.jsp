<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="style.css"/>

    <title>Conversor de Euros a Pesetas y Viceversa</title>
</head>
<body>
<%--12.5.7. Combina las dos aplicaciones anteriores en una sola de tal forma que en la página principal se pueda elegir
pasar de euros a pesetas o de pesetas a euros. Adorna la página con alguna foto o dibujo..--%>



<form method="post" action="index6.jsp">
    <select name="tipoMoneda">
        <option value="euro">EUR</option>
        <option value="peseta">PESETA</option>
    </select>

    Ingresa la modena: <input type="text" name="moneda">
    <input type="submit" value="Enviar">
</form>


<%
    String tipoMoneda = request.getParameter("tipoMoneda");
    String monedaStr = request.getParameter("moneda");

    double resultado = 0;
    String textoOrigen = "";
    String textoDestino = "";

    if (monedaStr != null && !monedaStr.isEmpty()) {
        double cantidad = Double.parseDouble(monedaStr);

        if (tipoMoneda.equals("euro")) {
            resultado = Double.parseDouble(monedaStr);
            textoOrigen = cantidad + " Euros";
            textoDestino = String.format("%.2f", resultado) + " Pesetas";
      } else {
            resultado = cantidad / 166.386;
            textoOrigen = cantidad + " Pesetas";
            textoDestino = String.format("%.2f", resultado) + " Euros";
      }
%>
<div class="resultado">
    <h3>Resultado</h3>
    <p><%= textoOrigen %> equivalen a:</p>
    <p class="highlight"><%= textoDestino %></p>
</div>

<%
    }
%>


</body>
</html>