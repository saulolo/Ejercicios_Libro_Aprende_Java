<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="style.css"/>

    <title>Cuestionario</title>
</head>
<body>

<%--12.5.10. Realiza un cuestionario con 10 preguntas tipo test sobre las asignaturas que se imparten en el curso.
Cada pregunta acertada sumará un punto. El programa mostrará al final la calificación obtenida. Pásale el cuestionario
a tus compañeros y pídeles que lo hagan para ver qué tal andan de conocimientos en las diferentes asignaturas del curso.
Utiliza radio buttons en las preguntas del cuestionario.--%>

<form method="post" action="index9.jsp">

    <%--Pregunta 1.--%>
    <p><strong>1. ¿Qué tipo de dato se usa para almacenar un solo carácter en Java?</strong></p>
    <label>
        <input type="radio" name="pregunta1" value="a"> a) String
    </label> <br>
    <label>
        <input type="radio" name="pregunta1" value="b"> b) char
    </label> <br>
    <label>
        <input type="radio" name="pregunta1" value="c"> c) byte
    </label> <br>
    <label>
        <input type="radio" name="pregunta1" value="d"> d) int
    </label> <br>

    <%--Pregunta 2.--%>
    <p><strong>2. ¿Cuál es el valor por defecto de una variable de tipo boolean?</strong></p>
    <label>
        <input type="radio" name="pregunta2" value="a"> a) null
    </label> <br>
    <label>
        <input type="radio" name="pregunta2" value="b"> b) true
    </label> <br>
    <label>
        <input type="radio" name="pregunta2" value="c"> c) false
    </label> <br>
    <label>
        <input type="radio" name="pregunta2" value="d"> d) void
    </label> <br>

    <%--Pregunta 3.--%>
    <p><strong>3. ¿Qué palabra clave se usa para crear un objeto en Java?</strong></p>
    <label>
        <input type="radio" name="pregunta3" value="a"> a) class
    </label> <br>
    <label>
        <input type="radio" name="pregunta3" value="b"> b) make
    </label> <br>
    <label>
        <input type="radio" name="pregunta3" value="c"> c) new
    </label> <br>
    <label>
        <input type="radio" name="pregunta3" value="d"> d) build
    </label> <br>

    <%--Pregunta 4.--%>
    <p><strong>4. ¿Qué palabra clave indica que un método no devuelve ningún valor?</strong></p>
    <label>
        <input type="radio" name="pregunta4" value="a"> a) null
    </label> <br>
    <label>
        <input type="radio" name="pregunta4" value="b"> b) void
    </label> <br>
    <label>
        <input type="radio" name="pregunta4" value="c"> c) static
    </label> <br>
    <label>
        <input type="radio" name="pregunta4" value="d"> d) empty
    </label> <br>

    <%--Pregunta 5.--%>
    <p><strong>5. ¿Qué estructura de datos indexada tiene un tamaño fijo en Java?</strong></p>
    <label>
        <input type="radio" name="pregunta5" value="a"> a) Array
    </label> <br>
    <label>
        <input type="radio" name="pregunta5" value="b"> b) List
    </label> <br>
    <label>
        <input type="radio" name="pregunta5" value="c"> c) Set
    </label> <br>
    <label>
        <input type="radio" name="pregunta5" value="d"> d) Map
    </label> <br>

    <%--Pregunta 6.--%>
    <p><strong>6. ¿Qué palabra clave se usa para heredar una clase en Java?</strong></p>
    <label>
        <input type="radio" name="pregunta6" value="a"> a) implements
    </label> <br>
    <label>
        <input type="radio" name="pregunta6" value="b"> b) imports
    </label> <br>
    <label>
        <input type="radio" name="pregunta6" value="c"> c) extends
    </label> <br>
    <label>
        <input type="radio" name="pregunta6" value="d"> d) inherits
    </label> <br>

    <%--Pregunta 7.--%>
    <p><strong>6. ¿Qué palabra clave se usa para importar clases clases en Java?</strong></p>
    <label>
        <input type="radio" name="pregunta7" value="a"> a) implements
    </label> <br>
    <label>
        <input type="radio" name="pregunta7" value="b"> b) imports
    </label> <br>
    <label>
        <input type="radio" name="pregunta7" value="c"> c) extends
    </label> <br>
    <label>
        <input type="radio" name="pregunta7" value="d"> d) inherits
    </label> <br>


    <%--Pregunta 8.--%>
    <p><strong>8. ¿Qué palabra clave hace que una variable sea una constante (no modificable)?</strong></p>
    <label>
        <input type="radio" name="pregunta8" value="a"> a) static
    </label> <br>
    <label>
        <input type="radio" name="pregunta8" value="b"> b) final
    </label> <br>
    <label>
        <input type="radio" name="pregunta8" value="c"> c) const
    </label> <br>
    <label>
        <input type="radio" name="pregunta8" value="d"> d) stable
    </label> <br>

    <%--Pregunta 9.--%>
    <p><strong>9. ¿Cuál es la clase base oculta de la que heredan todas las clases en Java?</strong></p>
    <label>
        <input type="radio" name="pregunta9" value="a"> a) Class
    </label> <br>
    <label>
        <input type="radio" name="pregunta9" value="b"> b) System
    </label> <br>
    <label>
        <input type="radio" name="pregunta9" value="c"> c) Object
    </label> <br>
    <label>
        <input type="radio" name="pregunta9" value="d"> d) Super
    </label> <br>

    <%--Pregunta 10.--%>
    <p><strong>10. ¿Qué palabra clave se usa para llamar al constructor de la clase padre?</strong></p>
    <label>
        <input type="radio" name="pregunta10" value="a"> a) super
    </label> <br>
    <label>
        <input type="radio" name="pregunta10" value="b"> b) this
    </label> <br>
    <label>
        <input type="radio" name="pregunta10" value="c"> c) parent
    </label> <br>
    <label>
        <input type="radio" name="pregunta10" value="d"> d) base
    </label> <br>


    <%--Botón Enviar--%>
    <br>
    <input type="submit" value="Enviar">


    <%
        if (request.getParameter("pregunta1") != null) {
            int nota = 0;

            if ("b".equals(request.getParameter("pregunta1"))) nota++;
            if ("c".equals(request.getParameter("pregunta2"))) nota++;
            if ("c".equals(request.getParameter("pregunta3"))) nota++;
            if ("b".equals(request.getParameter("pregunta4"))) nota++;
            if ("a".equals(request.getParameter("pregunta5"))) nota++;
            if ("c".equals(request.getParameter("pregunta6"))) nota++;
            if ("b".equals(request.getParameter("pregunta7"))) nota++;
            if ("b".equals(request.getParameter("pregunta8"))) nota++;
            if ("c".equals(request.getParameter("pregunta9"))) nota++;
            if ("a".equals(request.getParameter("pregunta10"))) nota++;
    %>

    <div class="resultado" style="margin-top: 25px">
        <h3>Calificación Final</h3>
        <p>Has Acertado <strong><%= nota%>
        </strong> de 10 preguntas</p>
        <p class="highlight">
            <%= (nota >= 5) ? "\uD83C\uDF89 ¡Felicidades, has aprobado!" : "❌ Necesitas repasar los conceptos."%>
        </p>

    </div>

    <%
        }
    %>


</form>


</body>
</html>