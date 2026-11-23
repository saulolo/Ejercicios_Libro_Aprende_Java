<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="style.css?v=2"/>
    <title>Listado de Socios</title>
</head>
<body>

<div class="card-container">
    <h1>Listado de Socios</h1>

    <%
        String url = "jdbc:postgresql://localhost:5432/baloncesto_db";
        String usuario = "postgres";
        String password = "***";

        String borrarIdStr = request.getParameter("borrarId");

        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(url, usuario, password);

            // =========================================================
            // 1. SI SE PULSÓ EL BOTÓN "BORRAR" DE CUALQUIER FILA
            // =========================================================
            if (borrarIdStr != null && !borrarIdStr.isBlank()) {
                int idAEliminar = Integer.parseInt(borrarIdStr);

                String sqlDelete = "DELETE FROM socio WHERE socio_id = ?";
                PreparedStatement psDelete = conexion.prepareStatement(sqlDelete);
                psDelete.setInt(1, idAEliminar);

                int eliminados = psDelete.executeUpdate();
                if (eliminados > 0) {
                    out.println("<div class='mensaje-exito'>¡Socio #" + idAEliminar + " eliminado con éxito! 🗑️</div>");
                }
            }

            // =========================================================
            // 2. CONSULTAR Y LISTAR TODOS LOS SOCIOS
            // =========================================================
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM socio ORDER BY socio_id ASC");

            out.println("<ul class='lista-socios'>");

            boolean haySocios = false;
            while (rs.next()) {
                haySocios = true;
                int id = rs.getInt("socio_id");
                String nombre = rs.getString("nombre");
                String localidad = rs.getString("localidad");
    %>
    <li>
                    <span>
                        <span class="socio-id">#<%= id %></span>
                        <strong><%= nombre %></strong>
                        <span class="socio-localidad">(<%= localidad %>)</span>
                    </span>

        <!-- Mini formulario invisible por cada socio con su ID -->
        <form action="" method="post" class="form-eliminar-fila">
            <input type="hidden" name="borrarId" value="<%= id %>">
            <button type="submit" class="btn-borrar-item"
                    onclick="return confirm('¿Seguro que deseas eliminar a <%= nombre %>?');">
                🗑️ Borrar
            </button>
        </form>
    </li>
    <%
            }
            out.println("</ul>");

            if (!haySocios) {
                out.println("<p style='text-align: center; color: #888;'>No quedan socios en el club.</p>");
            }

            conexion.close();

        } catch (Exception e) {
            out.println("<div class='mensaje-error'>Error: " + e.getMessage() + "</div>");
        }
    %>
</div>

</body>
</html>