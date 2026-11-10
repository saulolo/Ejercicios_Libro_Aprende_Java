<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="style.css"/>

    <title>Generador de Pirámide</title>
</head>
<body>

<%--12.5.9. Realiza una aplicación que pinte una pirámide. La altura se pedirá en un formulario. La pirámide estará
hecha de bolitas, ladrillos o cualquier otra imagen.--%>

<form method="post" action="index8.jsp">
    Ingresa la altura<input type="number" name="altura" min="1" max="7">
    <input type="submit" value="Dibujar Pirámide">
</form>

<%
    String alturaStr = request.getParameter("altura");

    if (alturaStr != null && !alturaStr.isEmpty()) {
        int altura = Integer.parseInt(alturaStr);
%>



<div class="resultado">
    <h3>Pirámide de altura <%= altura %></h3>
    <%

        for (int fila = 1; fila <= altura; fila++) {

            int numLadrillos = (2 * fila) - 1;

            // Bucle interior: dibuja los ladrillos de esta fila
            for (int col = 0; col < numLadrillos; col++) {
                out.print("🧱");
            }
    %>

<br>
<%
    }
%>


<%
    }
%>
</div>

</body>
</html>