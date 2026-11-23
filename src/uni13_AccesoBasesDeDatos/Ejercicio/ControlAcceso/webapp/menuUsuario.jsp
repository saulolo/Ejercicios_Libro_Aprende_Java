<%@ page import="java.sql.*" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    // =========================================================================
    // 1. SEGURIDAD: Solo el ADMIN puede asignar permisos
    // =========================================================================
    String rolActual = (String) session.getAttribute("rol");
    if (!"ADMIN".equals(rolActual)) {
        response.sendRedirect("indexAcceso.jsp");
        return;
    }

    request.setCharacterEncoding("UTF-8");

    String url = "jdbc:postgresql://localhost:5432/baloncesto_db";
    String dbUsuario = "postgres";
    String dbPassword = "***";

    // Usuario que estamos configurando (viene por URL o por formulario)
    String usuarioConfigurar = request.getParameter("usuario");
    String accion = request.getParameter("accion");
    String mensajeAlerta = null;

    Connection conexion = null;

    try {
        Class.forName("org.postgresql.Driver");
        conexion = DriverManager.getConnection(url, dbUsuario, dbPassword);

        // =========================================================================
        // 2. GUARDAR PERMISOS (Si se envió el formulario)
        // =========================================================================
        if ("guardar".equals(accion) && usuarioConfigurar != null) {
            String[] ejerciciosSeleccionados = request.getParameterValues("ejercicios");

            // A. Borrar permisos anteriores de este usuario
            String sqlDelete = "DELETE FROM permiso WHERE usuario = ?";
            PreparedStatement psDelete = conexion.prepareStatement(sqlDelete);
            psDelete.setString(1, usuarioConfigurar);
            psDelete.executeUpdate();

            // B. Insertar los nuevos checkboxes marcados
            if (ejerciciosSeleccionados != null) {
                String sqlInsert = "INSERT INTO permiso (usuario, ejercicio) VALUES (?, ?)";
                PreparedStatement psInsert = conexion.prepareStatement(sqlInsert);

                for (String numEj : ejerciciosSeleccionados) {
                    psInsert.setString(1, usuarioConfigurar);
                    psInsert.setInt(2, Integer.parseInt(numEj));
                    psInsert.executeUpdate();
                }
            }
            mensajeAlerta = "¡Permisos actualizados con éxito para <strong>" + usuarioConfigurar + "</strong>! ✅";
        }

        // =========================================================================
        // 3. CONSULTAR PERMISOS ACTUALES DEL USUARIO (Para marcar con 'checked')
        // =========================================================================
        Set<Integer> permisosActuales = new HashSet<>();
        if (usuarioConfigurar != null && !usuarioConfigurar.isBlank()) {
            String sqlPermisos = "SELECT ejercicio FROM permiso WHERE usuario = ?";
            PreparedStatement psPermisos = conexion.prepareStatement(sqlPermisos);
            psPermisos.setString(1, usuarioConfigurar);
            ResultSet rsPermisos = psPermisos.executeQuery();

            while (rsPermisos.next()) {
                permisosActuales.add(rsPermisos.getInt("ejercicio"));
            }
        }
%>


<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu Usuarios</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>

<body class="bg-light">

<!-- Barra Superior -->
<nav class="navbar navbar-dark bg-dark">
    <div class="container">
        <span class="navbar-brand mb-0 h1">
            <i class="fas fa-shield-alt text-warning mr-2"></i> Gestión de Permisos
        </span>
        <a href="gestionUsuarios.jsp" class="btn btn-outline-light btn-sm">
            <i class="fas fa-arrow-left"></i> Volver a Usuarios
        </a>
    </div>
</nav>

<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-7">

            <% if (mensajeAlerta != null) { %>
            <div class="alert alert-success alert-dismissible fade show shadow-sm">
                <%= mensajeAlerta %>
            </div>
            <% } %>

            <div class="card shadow-sm border-0">
                <div class="card-header bg-primary text-white font-weight-bold">
                    <i class="fas fa-tasks mr-1"></i> Configurar Permisos por Ejercicio
                </div>
                <div class="card-body">

                    <!-- Formulario de Selección de Usuario -->
                    <form action="permisos.jsp" method="get" class="mb-4">
                        <label class="font-weight-bold">Selecciona el usuario a configurar:</label>
                        <div class="input-group">
                            <select name="usuario" class="custom-select" onchange="this.form.submit()">
                                <option value="">-- Elige un usuario --</option>
                                <%
                                    Statement sUser = conexion.createStatement();
                                    ResultSet rsUsers = sUser.executeQuery("SELECT usuario FROM usuario WHERE usuario <> 'admin' ORDER BY usuario ASC");
                                    while (rsUsers.next()) {
                                        String u = rsUsers.getString("usuario");
                                        String selected = u.equals(usuarioConfigurar) ? "selected" : "";
                                %>
                                <option value="<%= u %>" <%= selected %>><%= u %>
                                </option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                    </form>

                    <% if (usuarioConfigurar != null && !usuarioConfigurar.isBlank()) { %>
                    <hr>
                    <!-- Formulario de Checkboxes -->
                    <form action="permisos.jsp" method="post">
                        <input type="hidden" name="accion" value="guardar">
                        <input type="hidden" name="usuario" value="<%= usuarioConfigurar %>">

                        <p class="font-weight-bold text-secondary mb-3">
                            Marca los ejercicios permitidos para <span
                                class="badge badge-info p-2"><%= usuarioConfigurar %></span>:
                        </p>

                        <!-- Lista de Checkboxes (Ejercicios del 1 al 6) -->
                        <div class="list-group mb-4">
                            <%
                                String[] nombresEjercicios = {
                                        "Ejercicio 1 - Control de Acceso",
                                        "Ejercicio 2 - Gestión y Alta de Usuarios",
                                        "Ejercicio 3 - Asignación de Permisos (Actual)",
                                        "Ejercicio 4 - CRUD Club de Baloncesto",
                                        "Ejercicio 5 - Búsqueda de Clientes",
                                        "Ejercicio 6 - GESTISIMAL (Control de Almacén)"
                                };

                                for (int i = 1; i <= 6; i++) {
                                    boolean marcado = permisosActuales.contains(i);
                            %>
                            <label class="list-group-item d-flex align-items-center">
                                <input type="checkbox" name="ejercicios" value="<%= i %>"
                                       class="mr-3" style="width: 18px; height: 18px;"
                                    <%= marcado ? "checked" : "" %>>
                                <span><%= nombresEjercicios[i - 1] %></span>
                            </label>
                            <%
                                }
                            %>
                        </div>

                        <button type="submit" class="btn btn-success btn-block font-weight-bold">
                            <i class="fas fa-save mr-1"></i> Guardar Permisos de <%= usuarioConfigurar %>
                        </button>
                    </form>
                    <% } %>

                </div>
            </div>

        </div>
    </div>
</div>

</body>
</html>
<%
        conexion.close();
    } catch (Exception e) {
        out.println("<div class='alert alert-danger m-4'>Error: " + e.getMessage() + "</div>");
    }
%>
