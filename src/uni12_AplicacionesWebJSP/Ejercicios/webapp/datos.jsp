<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="style.css"/>
    <title>Document</title>
</head>
<body>

<div class="resultado">

    <%
        String nombre = request.getParameter("nombre");

        if (nombre != null) {
            String apellido = request.getParameter("apellido");
            int edad = Integer.parseInt(request.getParameter("edad"));
            String email = request.getParameter("email");

            out.print("Nombre: " + nombre + "<br>");
            out.print("Apellido: " + apellido + "<br>");
            out.print("\nEdad: " + edad + "<br>");
            out.print("\nEmail: " + email + "<br>");
        }
    %>

</div>

</body>
</html>