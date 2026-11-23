<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    // Asegurar que las tildes y caracteres especiales en español (Málaga, Bermúdez) no se corrompan
    request.setCharacterEncoding("UTF-8");

    String url = "jdbc:postgresql://localhost:5432/baloncesto_db";
    String usuario = "postgres";
    String password = "***";

    String socioIdStr = request.getParameter("socioId");

    if (socioIdStr != null && !socioIdStr.isBlank()) {
        try {
            int socioId = Integer.parseInt(socioIdStr);
            String nombre = request.getParameter("nombre");
            double estatura = Double.parseDouble(request.getParameter("estatura"));
            int edad = Integer.parseInt(request.getParameter("edad"));
            String localidad = request.getParameter("localidad");

            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url, usuario, password);

            // 1. Sentencia SQL UPDATE con PreparedStatement
            String sqlUpdate = "UPDATE socio SET nombre = ?, estatura = ?, edad = ?, localidad = ? WHERE socio_id = ?";
            PreparedStatement ps = conexion.prepareStatement(sqlUpdate);

            ps.setString(1, nombre);
            ps.setDouble(2, estatura);
            ps.setInt(3, edad);
            ps.setString(4, localidad);
            ps.setInt(5, socioId);

            // 2. Ejecutar la actualización en PostgreSQL
            ps.executeUpdate();

            conexion.close();

            // 3. Redirección instantánea a indexAcceso.jsp (El usuario ve los cambios de inmediato)
            response.sendRedirect("indexAcceso.jsp");

        } catch (Exception e) {
            // Solo muestra pantalla si ocurre algún error grave de conexión
%>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <title>Error de Actualización</title>
</head>
<body class="bg-light p-5">
<div class="container text-center">
    <div class="alert alert-danger shadow-sm">
        <h4>Error al actualizar los datos</h4>
        <p><%= e.getMessage() %></p>
    </div>
    <a href="index.jsp" class="btn btn-primary">Volver al Listado</a>
</div>
</body>
</html>
<%
        }
    } else {
        // Si entraron al archivo directamente sin enviar datos, los regresamos al inicio
        response.sendRedirect("indexAcceso.jsp");
    }
%>