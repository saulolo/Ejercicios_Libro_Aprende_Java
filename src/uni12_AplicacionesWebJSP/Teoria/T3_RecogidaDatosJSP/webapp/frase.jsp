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
Me gusta mucho comer
<% out.print(request.getParameter("cadenaIntro")); %>

</body>
</html>