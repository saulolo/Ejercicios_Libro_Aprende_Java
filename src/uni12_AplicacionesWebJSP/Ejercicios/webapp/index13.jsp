<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="style.css"/>

    <title>Fibonacci</title>
</head>
<body>

<%--12.5.14. Escribe un programa que muestre los n primeros términos de la serie de Fibonacci. El primer término de la
serie de Fibonacci es 0, el segundo es 1 y el resto se calcula sumando los dos anteriores, por lo que tendríamos que los
términos son 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144… El número n se debe introducir por teclado.--%>


<form method="post" action="index13.jsp">
    <label>
        Intoduzca el número n: <input type="number" name="numberIntro" min="0">
    </label>

    <input type="submit" value="Calcular">
</form>

<%
    String numberStr = request.getParameter("numberIntro");

    if (numberStr != null && !numberStr.isEmpty()) {
        int n = Integer.parseInt(numberStr);
        String resultado = "";

        if (n >= 1) {
            long f1 = 0;
            long f2 = 1;

            for (int i = 1; i <= n; i++) {
                if (i == 1) {
                    resultado += f1 + " ";
                } else if (i == 2) {
                    resultado += f2 + " ";
                } else {
                    long siguiente = f1 + f2;
                    resultado += siguiente + " ";
                    f1 = f2;
                    f2 = siguiente;
                }
            }
        }

%>

<div class="resultado" style="margin-top: 25px">
    <h3>Resultado (Serie de <%= n %> términos)</h3>
    <p class="highlight"><%= resultado%>
    </p>
</div>


<%
    }
%>


</body>
</html>