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

<%--12.5.11. Escribe una aplicación que genere el calendario de un mes. Se pedirá el nombre del mes, el año, el texto que
queremos que aparezca sobre el calendario, el día de la semana en que cae el día 1 y el número de días que tiene el mes.--%>

<form method="post" action="index10.jsp">
    <label>
        Mes: <input type="text" name="mes" placeholder="ej: Noviembre">
    </label> <br>

    <label>
        Año: <input type="text" name="anio" placeholder="ej: 2024" min="0">
    </label> <br>

    <label>
        Texto: <input type="text" name="texto">
    </label> <br>

    <label>
        Dia 1 de la semana: <input type="number" name="diaUno" min="1" max=7>
    </label> <br>

    <label>
        Número de dias del mes: <input type="number" name="diasMes" min="1" max="31">
    </label> <br>

    <label>
        <input type="submit" value="Generar Calendario">
    </label>
</form>

<%
    String mes = request.getParameter("mes");

    if (mes != null && !mes.isEmpty()) {
      int anio = Integer.parseInt(request.getParameter("anio"));
      String texto = request.getParameter("texto");
      int diaUno = Integer.parseInt(request.getParameter("diaUno"));
      int diasMes = Integer.parseInt(request.getParameter("diasMes"));
%>

<div class="resultado-calendario" style="width: 450px; margin-top: 25px;">
    <h3><%= mes.toUpperCase() %> <%= anio %></h3>
    <p><strong><%= texto %></strong></p>

    <table border="1" style="width: 100%; border-collapse: collapse; text-align: center;">
        <thead>
        <tr style="background-color: #4CAF50; color: white;">
            <th>L</th><th>M</th><th>X</th><th>J</th><th>V</th><th>S</th><th>D</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <%
                // 1. Celdas vacías antes del día 1
                int columnaActual = 1;

                for (int i = 1; i < diaUno; i++) {
                    out.print("<td></td>");
                    columnaActual++;
                }

                // 2. Pintar los días del mes
                for (int dia = 1; dia <= diasMes; dia++) {
                    out.print("<td>" + dia + "</td>");

                    if (columnaActual == 7 && dia < diasMes) {
                        out.print("</tr><tr>"); // Cierra fila y abre nueva
                        columnaActual = 1;
                    } else {
                        columnaActual++;
                    }
                }

                // 3. Celdas vacías al final para cerrar la última semana
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