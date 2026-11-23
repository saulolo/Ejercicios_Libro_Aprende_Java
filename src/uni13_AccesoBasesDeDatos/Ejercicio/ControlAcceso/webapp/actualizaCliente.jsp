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
            String nombre = request.getParameter("nombre").trim();
            String direccion = request.getParameter("direccion").trim();
            String telefono = request.getParameter("telefono").trim();
            String nacimiento = request.getParameter("fechaNacimiento");

            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url, dbUsuario, dbPassword);

            String sql = "UPDATE cliente SET nombre = ?, direccion = ?, telefono = ?, fecha_nacimiento = ? WHERE codigo = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, direccion);
            ps.setString(3, telefono);
            ps.setDate(4, java.sql.Date.valueOf(nacimiento));
            ps.setInt(5, codigo);

            ps.executeUpdate();
            conexion.close();

            response.sendRedirect("indexCRUDGestibank.jsp");

        } catch (Exception e) {
            out.println("Error al actualizar: " + e.getMessage());
        }
    } else {
        response.sendRedirect("index.jsp");
    }
%>