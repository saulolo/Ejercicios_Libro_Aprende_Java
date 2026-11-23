<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");

    String url = "jdbc:postgresql://localhost:5432/baloncesto_db";
    String dbUsuario = "postgres";
    String dbPassword = "***";

    String codigoStr = request.getParameter("codigo");

    if (codigoStr != null && !codigoStr.isBlank()) {
        try {
            int codigo = Integer.parseInt(codigoStr);
            String descripcion = request.getParameter("descripcion").trim();
            double precioCompra = Double.parseDouble(request.getParameter("precioCompra"));
            double precioVenta = Double.parseDouble(request.getParameter("precioVenta"));

            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url, dbUsuario, dbPassword);

            // Actualizamos la descripción y los precios en PostgreSQL
            String sqlUpdate = "UPDATE articulo SET descripcion = ?, precio_compra = ?, precio_venta = ? WHERE codigo = ?";
            PreparedStatement ps = conexion.prepareStatement(sqlUpdate);
            ps.setString(1, descripcion);
            ps.setDouble(2, precioCompra);
            ps.setDouble(3, precioVenta);
            ps.setInt(4, codigo);

            ps.executeUpdate();
            conexion.close();

            // Redirige al listado principal con los cambios actualizados
            response.sendRedirect("indexGestisimal.jsp");

        } catch (Exception e) {
            out.println("Error al actualizar el artículo: " + e.getMessage());
        }
    } else {
        response.sendRedirect("indexGestisimal.jsp");
    }
%>