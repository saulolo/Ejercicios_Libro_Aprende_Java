<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Club de Baloncesto - Socios</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>

<%--13.6.1 CRUD con Boostrap--%>

<body class="bg-light">

<div class="container-fluid mt-4">
    <!-- Tarjeta principal -->
    <div class="card shadow-sm">

        <!-- Cabecera Azul del Club -->
        <div class="card-header bg-primary text-white text-center py-3">
            <h2 class="mb-0 font-weight-bold">Club de Baloncesto</h2>
        </div>

        <div class="card-body p-0">
            <%
                String url = "jdbc:postgresql://localhost:5432/baloncesto_db";
                String usuario = "postgres";
                String password = "***";

                String accion = request.getParameter("accion");

                try {
                    Class.forName("org.postgresql.Driver");
                    Connection conexion = DriverManager.getConnection(url, usuario, password);

                    // =========================================================
                    // 1. LÓGICA DE BORRADO (Si se pulsó el botón rojo Eliminar)
                    // =========================================================
                    if ("eliminar".equals(accion)) {
                        int idEliminar = Integer.parseInt(request.getParameter("socioId"));
                        String sqlDelete = "DELETE FROM socio WHERE socio_id = ?";
                        PreparedStatement psDelete = conexion.prepareStatement(sqlDelete);
                        psDelete.setInt(1, idEliminar);
                        psDelete.executeUpdate();
                        out.println("<div class='alert alert-warning m-3'>Socio #" + idEliminar + " eliminado correctamente.</div>");
                    }

                    // =========================================================
                    // 2. LÓGICA DE INSERCIÓN CON COMPROBACIÓN DE ID DUPLICADO
                    // =========================================================
                    if ("anadir".equals(accion)) {
                        int nuevoId = Integer.parseInt(request.getParameter("nuevoSocioId"));
                        String nombre = request.getParameter("nombre");
                        double estatura = Double.parseDouble(request.getParameter("estatura"));
                        int edad = Integer.parseInt(request.getParameter("edad"));
                        String localidad = request.getParameter("localidad");

                        // Comprobar si el ID ya existe en PostgreSQL
                        String sqlCheck = "SELECT COUNT(*) FROM socio WHERE socio_id = ?";
                        PreparedStatement psCheck = conexion.prepareStatement(sqlCheck);
                        psCheck.setInt(1, nuevoId);
                        ResultSet rsCheck = psCheck.executeQuery();
                        rsCheck.next();

                        if (rsCheck.getInt(1) > 0) {
                            // Alerta roja de Bootstrap si ya existe
                            out.println("<div class='alert alert-danger m-3 font-weight-bold'>"
                                    + "Error: El número de socio " + nuevoId + " ya existe en la base de datos.</div>");
                        } else {
                            // Inserción segura si no existe
                            String sqlInsert = "INSERT INTO socio (socio_id, nombre, estatura, edad, localidad) VALUES (?, ?, ?, ?, ?)";
                            PreparedStatement psInsert = conexion.prepareStatement(sqlInsert);
                            psInsert.setInt(1, nuevoId);
                            psInsert.setString(2, nombre);
                            psInsert.setDouble(3, estatura);
                            psInsert.setInt(4, edad);
                            psInsert.setString(5, localidad);
                            psInsert.executeUpdate();
                            out.println("<div class='alert alert-success m-3'>Socio " + nombre + " añadido con éxito.</div>");
                        }
                    }
            %>
            <!-- =========================================================
                 3. TABLA BOOTSTRAP CON FORMULARIO EN LÍNEA
                 ========================================================= -->
            <table class="table table-striped table-hover mb-0">
                <thead class="thead-light">
                <tr>
                    <th style="width: 10%;">Nº de socio</th>
                    <th style="width: 25%;">Nombre</th>
                    <th style="width: 10%;">Estatura</th>
                    <th style="width: 8%;">Edad</th>
                    <th style="width: 20%;">Localidad</th>
                    <th style="width: 27%;">Acciones</th>
                </tr>
                </thead>
                <tbody>
                <!-- FILA 1: FORMULARIO PARA AÑADIR NUEVO SOCIO -->
                <tr class="table-info">
                    <form action="index.jsp" method="post">
                        <input type="hidden" name="accion" value="anadir">
                        <td><input type="number" name="nuevoSocioId" class="form-control form-control-sm" required></td>
                        <td><input type="text" name="nombre" class="form-control form-control-sm" required></td>
                        <td><input type="number" step="0.01" name="estatura" class="form-control form-control-sm" required></td>
                        <td><input type="number" name="edad" class="form-control form-control-sm" required></td>
                        <td><input type="text" name="localidad" class="form-control form-control-sm" required></td>
                        <td>
                            <button type="submit" class="btn btn-primary btn-sm font-weight-bold">
                                <i class="fas fa-plus"></i> Añadir
                            </button>
                        </td>
                    </form>
                </tr>

                <!-- FILAS SIGUIENTES: DATOS DE LA BASE DE DATOS -->
                <%
                    Statement s = conexion.createStatement();
                    ResultSet rs = s.executeQuery("SELECT * FROM socio ORDER BY socio_id ASC");

                    while (rs.next()) {
                        int id = rs.getInt("socio_id");
                        String nombre = rs.getString("nombre");
                        double estatura = rs.getDouble("estatura");
                        int edad = rs.getInt("edad");
                        String localidad = rs.getString("localidad");
                %>
                <tr>
                    <td class="align-middle font-weight-bold"><%= id %></td>
                    <td class="align-middle"><%= nombre %></td>
                    <td class="align-middle"><%= estatura %></td>
                    <td class="align-middle"><%= edad %></td>
                    <td class="align-middle"><%= localidad %></td>
                    <td class="align-middle">
                        <!-- Botón Modificar (lleva a modificaSocio.jsp) -->
                        <a href="modificaSocio.jsp?socioId=<%= id %>" class="btn btn-info btn-sm text-white mr-1">
                            <i class="fas fa-pencil-alt"></i> Modificar
                        </a>

                        <!-- Botón Eliminar con confirmación -->
                        <form action="index.jsp" method="post" class="d-inline">
                            <input type="hidden" name="accion" value="eliminar">
                            <input type="hidden" name="socioId" value="<%= id %>">
                            <button type="submit" class="btn btn-danger btn-sm"
                                    onclick="return confirm('¿Seguro que deseas eliminar a <%= nombre %>?');">
                                <i class="fas fa-times"></i> Eliminar
                            </button>
                        </form>
                    </td>
                </tr>
                <%
                        } // Fin del while
                        conexion.close();
                    } catch (Exception e) {
                        out.println("<div class='alert alert-danger m-3'>Error de base de datos: " + e.getMessage() + "</div>");
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>