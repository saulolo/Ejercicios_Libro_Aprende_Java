<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    request.setCharacterEncoding("UTF-8");

    String url = "jdbc:postgresql://localhost:5432/baloncesto_db";
    String dbUsuario = "postgres";
    String dbPassword = "***";

    String accion = request.getParameter("accion");
    String alerta = null;
    String tipoAlerta = "success";

    Connection conexion = null;

    try {
        Class.forName("org.postgresql.Driver");
        conexion = DriverManager.getConnection(url, dbUsuario, dbPassword);

        // =========================================================
        // 1. LÓGICA DE BORRADO
        // =========================================================
        if ("borrar".equals(accion)) {
            int codigoBorrar = Integer.parseInt(request.getParameter("codigo"));
            String sqlDelete = "DELETE FROM cliente WHERE codigo = ?";
            PreparedStatement psDelete = conexion.prepareStatement(sqlDelete);
            psDelete.setInt(1, codigoBorrar);
            psDelete.executeUpdate();
            alerta = "Cliente #" + codigoBorrar + " eliminado correctamente.";
            tipoAlerta = "warning";
        }

        // =========================================================
        // 2. LÓGICA DE ALTA (AÑADIR CLIENTE)
        // =========================================================
        if ("anadir".equals(accion)) {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            String nombre = request.getParameter("nombre").trim();
            String direccion = request.getParameter("direccion").trim();
            String telefono = request.getParameter("telefono").trim();
            String nacimiento = request.getParameter("fechaNacimiento");

            // Comprobar si el código ya existe
            String sqlCheck = "SELECT COUNT(*) FROM cliente WHERE codigo = ?";
            PreparedStatement psCheck = conexion.prepareStatement(sqlCheck);
            psCheck.setInt(1, codigo);
            ResultSet rsCheck = psCheck.executeQuery();
            rsCheck.next();

            if (rsCheck.getInt(1) > 0) {
                alerta = "Error: El cliente con código " + codigo + " ya existe.";
                tipoAlerta = "danger";
            } else {
                String sqlInsert = "INSERT INTO cliente (codigo, nombre, direccion, telefono, fecha_nacimiento) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement psInsert = conexion.prepareStatement(sqlInsert);
                psInsert.setInt(1, codigo);
                psInsert.setString(2, nombre);
                psInsert.setString(3, direccion);
                psInsert.setString(4, telefono);
                psInsert.setDate(5, java.sql.Date.valueOf(nacimiento)); // Formato YYYY-MM-DD
                psInsert.executeUpdate();
                alerta = "Cliente " + nombre + " añadido con éxito.";
                tipoAlerta = "success";
            }
        }
%>

<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CRUD Gestibank</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="style-gestibank.css?v=1"/>

</head>

<%--13.7.4 Crea una aplicación web que permita hacer listado, alta, baja y modificación sobre la tabla cliente de la
base de datos banco. Un cliente tiene su identificador, nombre completo, dirección, teléfono y fecha de nacimiento.--%>



<body class="bg-light">

<div class="main-card">
    <div class="brand-title">G e s t i b a n k</div>

    <% if (alerta != null) { %>
    <div class="alert alert-<%= tipoAlerta %> alert-dismissible fade show mb-4 text-center">
        <%= alerta %>
    </div>
    <% } %>

    <div class="table-responsive">
        <table class="table table-custom">
            <thead>
            <tr>
                <th style="width: 12%;">Código</th>
                <th style="width: 18%;">Nombre</th>
                <th style="width: 22%;">Dirección</th>
                <th style="width: 14%;">Teléfono</th>
                <th style="width: 16%;">Fecha de<br>nacimiento</th>
                <th style="width: 18%;"></th>
            </tr>
            </thead>
            <tbody>
            <%
                Statement s = conexion.createStatement();
                ResultSet rs = s.executeQuery("SELECT * FROM cliente ORDER BY codigo ASC");

                while (rs.next()) {
                    int cod = rs.getInt("codigo");
                    String nom = rs.getString("nombre");
                    String dir = rs.getString("direccion");
                    String tel = rs.getString("telefono");
                    Date fecha = rs.getDate("fecha_nacimiento");
            %>
            <tr>
                <td><%= cod %>
                </td>
                <td><%= nom %>
                </td>
                <td><%= dir != null ? dir : "" %>
                </td>
                <td><%= tel != null ? tel : "" %>
                </td>
                <td><%= fecha %>
                </td>
                <td>
                    <!-- Botón EDITAR -->
                    <a href="editarCliente.jsp?codigo=<%= cod %>" class="btn-action-edit mr-1">EDITAR</a>

                    <!-- Botón BORRAR con confirmación -->
                    <form action="indexCRUDGestibank.jsp" method="post" style="display: inline;">
                        <input type="hidden" name="accion" value="borrar">
                        <input type="hidden" name="codigo" value="<%= cod %>">
                        <button type="submit" class="btn-action-delete"
                                onclick="return confirm('¿Seguro que deseas eliminar al cliente <%= nom %>?');">
                            BORRAR
                        </button>
                    </form>
                </td>
            </tr>
            <%
                } // Fin del while
            %>
            <!-- FILA INFERIOR: ALTA DE NUEVO CLIENTE (INPUTS SUBRAYADOS) -->
            <tr>
                <form action="indexCRUDGestibank.jsp" method="post">
                    <input type="hidden" name="accion" value="anadir">
                    <td><input type="number" name="codigo" class="input-underline" placeholder="código" required></td>
                    <td><input type="text" name="nombre" class="input-underline" placeholder="nombre" required></td>
                    <td><input type="text" name="direccion" class="input-underline" placeholder="dirección"></td>
                    <td><input type="text" name="telefono" class="input-underline" placeholder="teléfono"></td>
                    <td><input type="date" name="fechaNacimiento" class="input-underline" required></td>
                    <td>
                        <button type="submit" class="btn-action-add">AÑADIR</button>
                    </td>
                </form>
            </tr>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
<%
        conexion.close();
    } catch (Exception e) {
        out.println("<div class='alert alert-danger m-4 text-center'>Error de conexión: " + e.getMessage() + "</div>");
    }
%>