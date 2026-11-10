<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="style-calendario.css"/>

    <title>Calendario</title>
</head>
<body>

<%--12.5.12. Mejora la aplicación anterior de tal forma que no haga falta introducir el día de la semana en que cae el
día 1 y el número de días que tiene el mes. El programa debe deducir estos datos del mes y el año. Pista: puedes usar la
clase Calendar (java.util.Calendar).--%>

<form method="post" action="index11.jsp">
    <label>Mes:
        <select name="mes">
            <option value="0">Enero</option>
            <option value="1">Febrero</option>
            <option value="2">Marzo</option>
            <option value="3">Abril</option>
            <option value="4">Mayo</option>
            <option value="5">Junio</option>
            <option value="6">Julio</option>
            <option value="7">Agosto</option>
            <option value="8">Septiembre</option>
            <option value="9">Octubre</option>
            <option value="10">Noviembre</option>
            <option value="11">Diciembre</option>
        </select>
    </label>

    <label>Año: <input type="number" name="anio" placeholder="ej: 2026"></label>
    <label>Texto: <input type="text" name="texto"></label>

    <input type="submit" value="Generar Calendario">
</form>

<%
    String mesStr = request.getParameter("mes");

    if (mesStr != null && !mesStr.isEmpty()) {
        int mesNum = Integer.parseInt(mesStr);
        int anio = Integer.parseInt(request.getParameter("anio"));
        String texto = request.getParameter("texto");

        Calendar calendar = new GregorianCalendar(anio, mesNum, 1);

        int diasMes = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        int diaSemanaJava = calendar.get(Calendar.DAY_OF_WEEK);
        int diaUno = (diaSemanaJava == Calendar.SUNDAY) ? 7 : diaSemanaJava - 1;

        String[] nombresMeses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        String nombreMesTexto = nombresMeses[mesNum];
%>

<div class="resultado-calendario" style="width: 450px; margin-top: 25px;">
    <h3><%= nombreMesTexto.toUpperCase() %> <%= anio %></h3>
    <p><strong><%= texto %></strong></p>

    <table border="1" style="width: 100%; border-collapse: collapse; text-align: center;">
        <thead>
        <tr style="background-color: #4CAF50; color: white;">
            <th>L</th>
            <th>M</th>
            <th>X</th>
            <th>J</th>
            <th>V</th>
            <th>S</th>
            <th>D</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <%
                int columnaActual = 1;

                for (int i = 1; i < diaUno; i++) {
                    out.print("<td></td>");
                    columnaActual++;
                }

                for (int dia = 1; dia <= diasMes; dia++) {
                    out.print("<td>" + dia + "</td>");

                    if (columnaActual == 7 && dia < diasMes) {
                        out.print("</tr><tr>");
                        columnaActual = 1;
                    } else {
                        columnaActual++;
                    }
                }

                while (columnaActual > 1 && columnaActual <= 7) {
                    out.print("<td></td>");
                    columnaActual++;
                }
            %>
        </tr>
        </tbody>
    </table>
</div>

<%
    }
%>

</body>
</html>