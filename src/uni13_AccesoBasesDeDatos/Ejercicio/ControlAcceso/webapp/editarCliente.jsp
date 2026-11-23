<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");

    String url = "jdbc:postgresql://localhost:5432/baloncesto_db";
    String dbUsuario = "postgres";
    String dbPassword = "***";

    String codigoStr = request.getParameter("codigo");
    if (codigoStr == null || codigoStr.isBlank()) {
        response.sendRedirect("indexCRUDGestibank.jsp");
        return;
    }

    int codigo = Integer.parseInt(codigoStr);

    try {
        Class.forName("org.postgresql.Driver");
        Connection conexion = DriverManager.getConnection(url, dbUsuario, dbPassword);

        String sql = "SELECT * FROM cliente WHERE codigo = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String nombre = rs.getString("nombre");
            String direccion = rs.getString("direccion");
            String telefono = rs.getString("telefono");
            Date fecha = rs.getDate("fecha_nacimiento");
%>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificación de Cliente</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body class="bg-light p-4">

<div class="container" style="max-width: 650px; margin-top: 50px;">
    <div class="card shadow-sm border-0">
        <div class="card-header text-center bg-info text-white font-weight-bold">
            Modificación de Cliente #<%= codigo %>
        </div>
        <div class="card-body p-4">
            <form action="actualizaCliente.jsp" method="post">
                <input type="hidden" name="codigo" value="<%= codigo %>">

                <div class="form-group">
                    <label class="font-weight-bold">Nombre completo:</label>
                    <input type="text" name="nombre" class="form-control" value="<%= nombre %>" required>
                </div>

                <div class="form-group">
                    <label class="font-weight-bold">Dirección:</label>
                    <input type="text" name="direccion" class="form-control" value="<%= direccion != null ? direccion : "" %>">
                </div>

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label class="font-weight-bold">Teléfono:</label>
                        <input type="text" name="telefono" class="form-control" value="<%= telefono != null ? telefono : "" %>">
                    </div>
                    <div class="form-group col-md-6">
                        <label class="font-weight-bold">Fecha de nacimiento:</label>
                        <input type="date" name="fechaNacimiento" class="form-control" value="<%= fecha %>" required>
                    </div>
                </div>

                <div class="d-flex justify-content-between mt-4">
                    <a href="indexCRUDGestibank.jsp" class="btn btn-danger font-weight-bold">Cancelar</a>
                    <button type="submit" class="btn btn-success font-weight-bold">Aceptar</button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
<%
        }
        conexion.close();
    } catch (Exception e) {
        out.println("Error: " + e.getMessage());
    }
%>