<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="style.css"/>
    <title>Insertar Socio</title>
</head>
<body>
<%--13.2.2. Insertar un nuevo socio.--%>

<div class="card-container">
    <form action="insertarSocios.jsp" method="post">
        <h1>Insertar un nuevo Socio</h1>

        <%--ID Socio--%>
        <label>No Socio: <input type="number" id="socioId" name="socioId" max="1000" placeholder="Ej: 1"
                                required/></label>
        <%--Nombre--%>
        <label>Nombre: <input type="text" id="nombre" name="nombre" max="50" placeholder="Ej: Saul" required/></label>
        <%--Estatura--%>
        <label>Estatura: <input type="number" id="estatura" name="estatura" max="3" step="0.01" placeholder="Ej: 1.72"
                                required/></label>
        <%--Edad--%>
        <label>Edad: <input type="number" id="edad" name="edad" min="0" max="120" placeholder="Ej: 40"
                            required/></label>
        <%--Localidad--%>
        <label>Localidad: <input type="text" id="localidad" name="localidad" max="50" placeholder="Ej: Montebello"
                                 required/></label>
        <%--Boton Aceptar--%>
        <input type="submit" value="Aceptar">


        <%
            String url = "jdbc:postgresql://localhost:5432/baloncesto_db";
            String usuario = "postgres";
            String password = "***";

            String socioIdStr = request.getParameter("socioId");

            if (socioIdStr != null) {
                int socioIdInt = Integer.parseInt(socioIdStr);
                String nombreStr = request.getParameter("nombre");
                double estaturaStr = Double.parseDouble(request.getParameter("estatura"));
                int edad = Integer.parseInt(request.getParameter("edad"));
                String localidadStr = request.getParameter("localidad");

                try {
                    Class.forName("org.postgresql.Driver");
                    Connection conexion = DriverManager.getConnection(url, usuario, password);

                    // 1. Inserción segura con PreparedStatement (sin pelear con comillas)
                    String sqlInsert = "INSERT INTO socio (socio_id, nombre, estatura, edad, localidad) VALUES (?, ?, ?, ?, ?)";

                    PreparedStatement preparedStatement = conexion.prepareStatement(sqlInsert);
                    preparedStatement.setInt(1, socioIdInt);
                    preparedStatement.setString(2, nombreStr);
                    preparedStatement.setDouble(3, estaturaStr);
                    preparedStatement.setInt(4, edad);
                    preparedStatement.setString(5, localidadStr);

                    // 2. ¡EJECUTAR la inserción!
                    preparedStatement.execute();
                    out.println("<div class='mensaje-exito'>¡Socio guardado correctamente! ✅</div>");

                    // 3. Mostrar la lista actualizada
                    Statement statement = conexion.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM socio ORDER BY socio_id ASC");

                    out.println("<h3>Listado de socios registrados</h3>");
                    out.println("<ul class='lista-socios'>");

                    while (resultSet.next()) {
                        out.println("<li>");
                        out.println("<span><span class='socio-id'>#" + resultSet.getInt("socio_id") + "</span> " + resultSet.getString("nombre") + "</span>");
                        out.println("<span class='socio-localidad'>" + resultSet.getString("localidad") + "</span>");
                        out.println("</li>");
                    }
                    out.println("</ul>");

                    conexion.close();

                } catch (Exception e) {
                    out.println("<div class='mensaje-error'>Ha ocurrido un error: " + e.getMessage() + "</div>");
                }

            }

        %>

    </form>
</div>

</body>
</html>