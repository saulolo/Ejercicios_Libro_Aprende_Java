<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Paso de Cadena</title>
</head>
<body>

<% request.setCharacterEncoding("UTF-8"); %>
<%
    String nombreAnimal = request.getParameter("animal");
    String nombreImagen;

    if (nombreAnimal.equals("Gato")) {
        nombreImagen = "img/gato.png";
    } else {
        nombreImagen = "img/caracol.jpg";
    }

    int veces = Integer.parseInt(request.getParameter("numero"));

    for (int i = 0; i < veces; i++) {
      out.print("<img src='" + nombreImagen + "' width='100'>");
    }
%>


</body>
</html>