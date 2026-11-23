<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="style.css"/>
    <title>Listado Socios</title>
</head>
<body>
<%--13.2.1. Listar los socios de un equipo de Baloncesto.--%>

<form action="listadoSocios.jsp" method="post">
    <h1>Listado Socios</h1>


    <%
        String url = "jdbc:postgresql://localhost:5432/baloncesto_db";
        String usuario = "postgres";
        String password = "***";

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url, usuario, password);
            Statement s = conexion.createStatement();
            ResultSet listado = s.executeQuery("SELECT * FROM socio");
            while (listado.next()) {
                out.println(listado.getString("socio_id") + " " + listado.getString("nombre") + "<br>");
            }
            conexion.close();

        } catch (Exception e) {
            out.println("Ha courrido un error: " + e.getMessage());
        }

    %>

</form>


</body>


</body>
</html>