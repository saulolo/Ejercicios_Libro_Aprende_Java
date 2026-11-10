<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Librería Chart.js vía CDN -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <link rel="stylesheet" type="text/css" href="style-votos.css"/>

    <title>Resutados Electorales España</title>
    <style>

    </style>
</head>
<body>

<%--12.5.24. Realiza una aplicación en JSP que recoja mediante un formulario los votos de los diferentes partidos
políticos que concurren a las elecciones. A continuación, se debe mostrar una gráfica circular y una tabla con los votos
y los porcentajes tal y como se muestra en el ejemplo. Se recomienda usar la librería ChartJs6.--%>

<form action="index23.jsp" method="post">
    <h1><strong>Resultados Electorales</strong></h1>
    <h4>Introduzca el número de votos de los partidos políticos</h4>
    <%--PP--%>
    <label>
        PP <input type="number" id="pp" name="pp" min="0" max="9999999" value="0" required/>
    </label> <br><br>
    <%--PSOE--%>
    <label>
        PSOE <input type="number" id="psoe" name="psoe" min="0" max="9999999" value="0" required/>
    </label>
    <%--Ciudadanos--%>
    <label><br><br>
        Ciudadanos <input type="number" id="ciudadanos" name="ciudadanos" min="0" max="9999999" value="0" required/>
    </label>
    <%--Vox--%>
    <label><br><br>
        Vox <input type="number" id="vox" name="vox" min="0" max="9999999" value="0" required/>
    </label>
    <%--PACMA--%>
    <label><br><br>
        PACMA <input type="number" id="pacma" name="pacma" min="0" max="9999999" value="0" required/>
    </label>
    <%--Podemos--%>
    <label><br><br>
        Podemos <input type="number" id="podemos" name="podemos" min="0" max="9999999" value="0" required/>
    </label><br><br>
    <input type="submit" value="Ver gráfica">
</form>

<%
    String ppStr = request.getParameter("pp");

    if (ppStr != null) {
        long votosPP = Long.parseLong(ppStr);
        long votosPSOE = Long.parseLong(request.getParameter("psoe"));
        long votosCs = Long.parseLong(request.getParameter("ciudadanos"));
        long votosVox = Long.parseLong(request.getParameter("vox"));
        long votosPacma = Long.parseLong(request.getParameter("pacma"));
        long votosPodemos = Long.parseLong(request.getParameter("podemos"));

        long totalVotos = votosPP + votosPSOE + votosCs + votosVox + votosPacma + votosPodemos;

        // 3. Cálculo de porcentajes (evitando división por cero)
        double pctPP = (totalVotos > 0) ? (votosPP * 100.0) / totalVotos : 0;
        double pctPSOE = (totalVotos > 0) ? (votosPSOE * 100.0) / totalVotos : 0;
        double pctCs = (totalVotos > 0) ? (votosCs * 100.0) / totalVotos : 0;
        double pctVox = (totalVotos > 0) ? (votosVox * 100.0) / totalVotos : 0;
        double pctPacma = (totalVotos > 0) ? (votosPacma * 100.0) / totalVotos : 0;
        double pctPodemos = (totalVotos > 0) ? (votosPodemos * 100.0) / totalVotos : 0;
%>

<div style="width: 450px; height: 450px; margin: 30px auto;">
    <canvas id="graficaVotos"></canvas>
</div>

<script>
    const ctx = document.getElementById('graficaVotos').getContext('2d');
    new Chart(ctx, {
        type: 'pie',
        data: {
            labels: ['PP', 'PSOE', 'Ciudadanos', 'Vox', 'PACMA', 'Podemos'],
            datasets: [{
                // Inyectamos los votos desde Java a JavaScript:
                data: [<%= votosPP %>, <%= votosPSOE %>, <%= votosCs %>, <%= votosVox %>, <%= votosPacma %>, <%= votosPodemos %>],
                backgroundColor: [
                    '#12579b', // Azul PP
                    '#ef1923', // Rojo PSOE
                    '#fa5000', // Naranja Cs
                    '#5bc035', // Verde Vox
                    '#ffcc00', // Amarillo PACMA
                    '#6b2e68'  // Morado Podemos
                ]
            }]
        },
        options: {
            responsive: true,
            plugins: {
                legend: {
                    position: 'top'
                }
            }
        }
    });
</script>


<%
    }
%>


</body>
</html>