<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="style.css"/>
    <title>Promedio Notas</title>
</head>
<body>

<div class="resultado">

    <%
        double nota1 = Double.parseDouble(request.getParameter("nota1"));
        double nota2 = Double.parseDouble(request.getParameter("nota2"));
        double nota3 = Double.parseDouble(request.getParameter("nota3"));

        double promedio = (nota1 + nota2 + nota3) / 3;

        out.print("El promedio de las notas ingresada es: " + promedio);

    %>

</div>

</body>
</html>