<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="style.css"/>

    <title>Test de Infidelidad</title>
</head>
<body>

<%--12.5.13. Transforma el test de infidelidad realizado anteriormente para consola en una aplicación web.--%>

<form method="post" action="index12.jsp">
    <h1>DETECCIÓN DE INFIDELIDAD</h1>

    <fieldset>
        <label>
            <legend><strong>1. Tu pareja parece estar más inquieta de lo normal sin ningún motivo aparente?</strong>
            </legend>
            Verdadero <input type="radio" name="pregunta1" value="v" required>
            Falso <input type="radio" name="pregunta1" value="f">
        </label><br><br>

        <label>
            <legend><strong>2. Ha aumentado sus gastos de vestuario?</strong></legend>
            Verdadero <input type="radio" name="pregunta2" value="v" required>
            Falso <input type="radio" name="pregunta2" value="f">
        </label><br><br>

        <label>
            <legend><strong>3. Ha perdido el interés que mostraba anteriormente por ti?</strong></legend>
            Verdadero <input type="radio" name="pregunta3" value="v" required>
            Falso <input type="radio" name="pregunta3" value="f">
        </label><br><br>

        <label>
            <legend><strong>4. Ahora se afeita y se asea con más frecuencia (si es hombre) o ahora se arregla el pelo y
                se asea con más frecuencia (si es mujer)?</strong></legend>
            Verdadero <input type="radio" name="pregunta4" value="v" required>
            Falso <input type="radio" name="pregunta4" value="f">
        </label><br><br>

        <label>
            <legend><strong>5. No te deja que mires la agenda de su teléfono móvil?</strong></legend>
            Verdadero <input type="radio" name="pregunta5" value="v" required>
            Falso <input type="radio" name="pregunta5" value="f">
        </label><br><br>

        <label>
            <legend><strong>6. A veces tiene llamadas que dice no querer contestar cuando estás tú delante?</strong>
            </legend>
            Verdadero <input type="radio" name="pregunta6" value="v" required>
            Falso <input type="radio" name="pregunta6" value="f">
        </label><br><br>

        <label>
            <legend><strong>7. Últimamente se preocupa más en cuidar la línea y/o estar bronceado/a?</strong></legend>
            Verdadero <input type="radio" name="pregunta7" value="v" required>
            Falso <input type="radio" name="pregunta7" value="f">
        </label><br><br>

        <label>
            <legend><strong>8. Muchos días viene tarde después de trabajar porque dice tener mucho más trabajo?</strong>
            </legend>
            Verdadero <input type="radio" name="pregunta8" value="v" required>
            Falso <input type="radio" name="pregunta8" value="f">
        </label><br><br>

        <label>
            <legend><strong>9. Has notado que últimamente se perfuma más?</strong></legend>
            Verdadero <input type="radio" name="pregunta9" value="v" required>
            Falso <input type="radio" name="pregunta9" value="f">
        </label><br><br>

        <label>
            <legend><strong>10. Se confunde y te dice que ha estado en sitios donde no ha ido contigo?</strong></legend>
            Verdadero <input type="radio" name="pregunta10" value="v" required>
            Falso <input type="radio" name="pregunta10" value="f">
        </label><br><br>
    </fieldset>
    <br>

    <input type="submit" value="Enviar">
</form>


<%
    if (request.getParameter("pregunta1") != null) {
        int acumulador = 0;

        if ("v".equals(request.getParameter("pregunta1"))) acumulador = acumulador + 3;
        if ("v".equals(request.getParameter("pregunta2"))) acumulador = acumulador + 3;
        if ("v".equals(request.getParameter("pregunta3"))) acumulador = acumulador + 3;
        if ("v".equals(request.getParameter("pregunta4"))) acumulador = acumulador + 3;
        if ("v".equals(request.getParameter("pregunta5"))) acumulador = acumulador + 3;
        if ("v".equals(request.getParameter("pregunta6"))) acumulador = acumulador + 3;
        if ("v".equals(request.getParameter("pregunta7"))) acumulador = acumulador + 3;
        if ("v".equals(request.getParameter("pregunta9"))) acumulador = acumulador + 3;
        if ("v".equals(request.getParameter("pregunta8"))) acumulador = acumulador + 3;
        if ("v".equals(request.getParameter("pregunta10"))) acumulador = acumulador + 3;
%>


<%
    String diagnostico = "";
    if (acumulador <= 10) {
        diagnostico = ("¡Enhorabuena! tu pareja parece ser totalmente fiel.");
    }

    if (acumulador > 10 && acumulador <= 22) {
        diagnostico = (" Quizás exista el peligro de otra persona  su vida o en su mente, aunque seguramente será algo sin " +
                "importancia. No bajes la guardia.");
    }

    if (acumulador > 22 && acumulador <= 30) {
        diagnostico = (" Tu pareja tiene todos los ingredientes para estar viviendo un romance con otra persona. " +
                "Te aconsejamos que indagues un poco más y averigües que es lo que está pasando por su cabeza.");
    }

%>
<div class="resultado" style="margin-top: 25px">
    <h3>Resultado (Puntaje: <%= acumulador %> /30)</h3>
    <p class="highlight"><%= diagnostico%>
    </p>

</div>

<%
    }
%>


</body>
</html>