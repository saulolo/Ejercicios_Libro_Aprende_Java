<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="style-helados.css"/>

    <title>Domicilios Vegetarianos</title>
    <style>

    </style>
</head>
<body>

<%--12.5.22. Una empresa que sirve comida vegetariana a domicilio necesita una aplicación para que los clientes puedan
hacer sus pedidos por internet. La primera versión incluirá cuatro comidas y tres bebidas. A continuación se muestra una
tabla con las diferentes opciones y precios. (Libro, pag 278).--%>

<form action="index21.jsp" method="post">
    <h1><strong>Pide la comida mas sana a domicilio</strong></h1>
    <fieldset>
        <div class="helados-container">
            <%--Hamburguesa--%>
            <div class="helado-card">
                <img src="img/hamburguesa.jpeg" width="90" alt="Hamburguesa Vegetariana">
                <label for="hamburguesa">Hamburguesa vegetariana</label>
                <input type="number" id="hamburguesa" name="hamburguesa" value="0" min="0">
            </div>

            <%--Pasta--%>
            <div class="helado-card">
                <img src="img/pasta.jpeg" width="90" alt="Pasta al Pesto"><br>
                <label for="pasta">Pasta al Pesto</label>
                <input type="number" id="pasta" name="pasta" value="0" min="0">
            </div>

            <%--Pizza--%>
            <div class="helado-card">
                <img src="img/pizza.jpeg" width="90" alt="Pizza Caprese"><br>
                <label for="pizza">Pizza Caprese</label>
                <input type="number" id="pizza" name="pizza" value="0" min="0">
            </div>

            <%--Quinoa--%>
            <div class="helado-card">
                <img src="img/quinua.jpeg" width="90" alt="Quinoa con verdura"><br>
                <label for="quinoa">Quinoa con verdura</label>
                <input type="number" id="quinoa" name="quinoa" value="0" min="0">
            </div>

            <%--Agua--%>
            <div class="helado-card">
                <img src="img/agua.jpeg" width="90" alt="Agua"><br>
                <label for="agua">Agua</label>
                <input type="number" id="agua" name="agua" value="0" min="0">
            </div>

            <%--Cerveza--%>
            <div class="helado-card">
                <img src="img/cerveza.jpeg" width="90" alt="Cerveza"><br>
                <label for="cerveza">Cerveza</label>
                <input type="number" id="cerveza" name="cerveza" value="0" min="0">
            </div>

            <%--Regresco--%>
            <div class="helado-card">
                <img src="img/refresco.jpeg" width="90" alt="Regresco"><br>
                <label for="refresco">Refresco</label>
                <input type="number" id="refresco" name="refresco" value="0" min="0">
            </div>
        </div>
    </fieldset>
    <input type="submit" value="Hacer Pedido">
</form>

<%
    String hamburgesaStr = request.getParameter("hamburguesa");

    if (hamburgesaStr != null && !hamburgesaStr.isEmpty()) {
        //Cantidades
        int cantidadHamburguesa = Integer.parseInt(hamburgesaStr);
        int cantidadPasta = Integer.parseInt(request.getParameter("pasta"));
        int cantidadPizza = Integer.parseInt(request.getParameter("pizza"));
        int cantidadQuinoa = Integer.parseInt(request.getParameter("quinoa"));
        int cantidadAgua = Integer.parseInt(request.getParameter("agua"));
        int cantidadCerveza = Integer.parseInt(request.getParameter("cerveza"));
        int cantidadRefresco = Integer.parseInt(request.getParameter("refresco"));

        //Precios
        double precioHamburguesa = 6.20;
        double precioPasta = 4.90;
        double precioPizza = 5.50;
        double precioQuinoa = 6.95;
        double precioAgua = 1.00;
        double precioCerveza = 1.50;
        double precioRefresco = 1.40;

        //Total alimentos
        double totalHamburguesa = cantidadHamburguesa * precioHamburguesa;
        double totalPasta = cantidadPasta * precioPasta;
        double totalPizza = cantidadPizza * precioPizza;
        double totalQuinoa = cantidadQuinoa * precioQuinoa;
        double totalAgua = cantidadAgua * precioAgua;
        double totalCerveza = cantidadCerveza * precioCerveza;
        double totalRefresco = cantidadRefresco * precioRefresco;

        double total = totalHamburguesa + totalPasta + totalPizza + totalQuinoa + totalAgua + totalCerveza + totalRefresco;
%>

<%-- Resultado --%>
<div class="contenedor-resultado">
    <div class="tabla-resultado">
        <h2>Aquí tiene su pedido</h2>

        <table border="0" cellpadding="5">
            <thead>
            <tr>
                <th align="left">Comida / bebida</th>
                <th align="right">PVP</th>
                <th align="center">Cantidad</th>
                <th align="right">Subtotal</th>
            </tr>
            </thead>
            <tbody>
            <% if (cantidadHamburguesa > 0) { %>
            <tr>
                <td>Hamburguesa vegetariana</td>
                <td align="right"><%= String.format("%.2f", precioHamburguesa) %> €</td>
                <td align="center"><%= cantidadHamburguesa %>
                </td>
                <td align="right"><%= String.format("%.2f", totalHamburguesa) %> €</td>
            </tr>
            <% } %>

            <% if (cantidadPasta > 0) { %>
            <tr>
                <td>Pasta al pesto</td>
                <td align="right"><%= String.format("%.2f", precioPasta) %> €</td>
                <td align="center"><%= cantidadPasta %>
                </td>
                <td align="right"><%= String.format("%.2f", totalPasta) %> €</td>
            </tr>
            <% } %>

            <% if (cantidadPizza > 0) { %>
            <tr>
                <td>Pizza caprese</td>
                <td align="right"><%= String.format("%.2f", precioPizza) %> €</td>
                <td align="center"><%= cantidadPizza %>
                </td>
                <td align="right"><%= String.format("%.2f", totalPizza) %> €</td>
            </tr>
            <% } %>

            <% if (cantidadQuinoa > 0) { %>
            <tr>
                <td>Quinoa con verdura</td>
                <td align="right"><%= String.format("%.2f", precioQuinoa) %> €</td>
                <td align="center"><%= cantidadQuinoa %>
                </td>
                <td align="right"><%= String.format("%.2f", totalQuinoa) %> €</td>
            </tr>
            <% } %>

            <% if (cantidadAgua > 0) { %>
            <tr>
                <td>Agua</td>
                <td align="right"><%= String.format("%.2f", precioAgua) %> €</td>
                <td align="center"><%= cantidadAgua %>
                </td>
                <td align="right"><%= String.format("%.2f", totalAgua) %> €</td>
            </tr>
            <% } %>

            <% if (cantidadCerveza > 0) { %>
            <tr>
                <td>Cerveza</td>
                <td align="right"><%= String.format("%.2f", precioCerveza) %> €</td>
                <td align="center"><%= cantidadCerveza %>
                </td>
                <td align="right"><%= String.format("%.2f", totalCerveza) %> €</td>
            </tr>
            <% } %>

            <% if (cantidadRefresco > 0) { %>
            <tr>
                <td>Refresco</td>
                <td align="right"><%= String.format("%.2f", precioRefresco) %> €</td>
                <td align="center"><%= cantidadRefresco %>
                </td>
                <td align="right"><%= String.format("%.2f", totalRefresco) %> €</td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
    <h3>Total: <%= String.format("%.2f", total) %> €</h3>
</div>

<%
    }
%>


</body>
</html>