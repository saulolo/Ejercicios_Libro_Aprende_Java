<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");

    String url = "jdbc:postgresql://localhost:5432/baloncesto_db";
    String dbUsuario = "postgres";
    String dbPassword = "***";

    String codigoStr = request.getParameter("codigo");
    if (codigoStr == null || codigoStr.isBlank()) {
        response.sendRedirect("indexGestisimal.jsp");
        return;
    }

    int codigo = Integer.parseInt(codigoStr);

    try {
        Class.forName("org.postgresql.Driver");
        Connection conexion = DriverManager.getConnection(url, dbUsuario, dbPassword);

        String sql = "SELECT * FROM articulo WHERE codigo = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String descripcion = rs.getString("descripcion");
            double precioCompra = rs.getDouble("precio_compra");
            double precioVenta = rs.getDouble("precio_venta");
            int stock = rs.getInt("stock");
%>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificar Artículo - GESTISIMAL</title>
    <!-- Bootstrap 4 y FontAwesome -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<body class="bg-light p-4">

<div class="container" style="max-width: 620px; margin-top: 40px;">
    <div class="card shadow-sm border-0">

        <div class="card-header bg-info text-white font-weight-bold text-center py-3">
            <h5 class="mb-0"><i class="fas fa-edit mr-2"></i>Modificar Artículo #<%= codigo %></h5>
        </div>

        <div class="card-body p-4">
            <form action="actualizaArticulo.jsp" method="post">
                <input type="hidden" name="codigo" value="<%= codigo %>">

                <!-- Código y Stock (Solo lectura) -->
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label class="font-weight-bold">Código del artículo:</label>
                        <input type="text" class="form-control" value="#<%= codigo %>" readonly style="background-color: #f1f3f5;">
                    </div>
                    <div class="form-group col-md-6">
                        <label class="font-weight-bold">Stock actual en almacén:</label>
                        <input type="text" class="form-control font-weight-bold text-primary" value="<%= stock %> unidades" readonly style="background-color: #f1f3f5;">
                    </div>
                </div>

                <!-- Descripción -->
                <div class="form-group">
                    <label class="font-weight-bold">Descripción del producto:</label>
                    <input type="text" name="descripcion" class="form-control" value="<%= descripcion %>" required>
                </div>

                <!-- Precios de Compra y Venta -->
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label class="font-weight-bold">Precio de Compra (€):</label>
                        <div class="input-group">
                            <input type="number" step="0.01" min="0" name="precioCompra" class="form-control" value="<%= precioCompra %>" required>
                            <div class="input-group-append">
                                <span class="input-group-text">€</span>
                            </div>
                        </div>
                    </div>
                    <div class="form-group col-md-6">
                        <label class="font-weight-bold">Precio de Venta (€):</label>
                        <div class="input-group">
                            <input type="number" step="0.01" min="0" name="precioVenta" class="form-control" value="<%= precioVenta %>" required>
                            <div class="input-group-append">
                                <span class="input-group-text">€</span>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Botones de Acción -->
                <div class="d-flex justify-content-between mt-4">
                    <a href="indexGestisimal.jsp" class="btn btn-danger font-weight-bold">
                        <i class="fas fa-times mr-1"></i> Cancelar
                    </a>
                    <button type="submit" class="btn btn-success font-weight-bold">
                        <i class="fas fa-save mr-1"></i> Guardar Cambios
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
<%
        } else {
            response.sendRedirect("indexGestisimal.jsp");
        }
        conexion.close();
    } catch (Exception e) {
        out.println("Error: " + e.getMessage());
    }
%>