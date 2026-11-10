<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="style.css"/>

    <title>Tabla de Multiplicar</title>
</head>
<body>
<%--12.5.8. Realiza una aplicación que pida un número y que luego muestre la tabla de multiplicar de ese número. El resultado se
debe mostrar en una tabla (<table> en HTML).--%>


<form method="post" action="index7.jsp">
    Ingresa el número: <input type="text" name="numero">
    <input type="submit" value="Enviar">
</form>


<%
    String numeroStr = request.getParameter("numero");

    if (numeroStr != null && !numeroStr.isEmpty()) {
        int numero = Integer.parseInt(numeroStr);
%>
<div class="resultado">
    <h3>Tabla del <%= numero %>
    </h3>
    <table border="1" style="margin: 0 auto; border-collapse: collapse; width: 100%;">
        <tr>
            <th>Operación</th>
            <th>Resultado</th>
        </tr>
        <%
            for (int i = 1; i <= 10; i++) {
        %>
        <tr>
            <td><%= numero %> x <%= i %>
            </td>
            <td><%= numero * i %>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</div>
<%
    }
%>


</body>
</html>