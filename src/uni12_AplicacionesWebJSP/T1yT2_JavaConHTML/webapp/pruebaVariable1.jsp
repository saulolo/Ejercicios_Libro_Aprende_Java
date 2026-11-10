<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Prueba Variable 1</title>
</head>
<body>

<%
    for (int i = 1; i < 7; i++)
        out.println("<h" + (7-i) + ">"+ i + "</h" + (7-i) + ">");
%>

</body>
</html>