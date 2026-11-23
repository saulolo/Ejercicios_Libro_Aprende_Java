<%@ page import="java.sql.*" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    // =========================================================================
    // 1. FILTRO DE SEGURIDAD (Solo el ADMIN puede entrar aquí)
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

    // Usuario que estamos configurando (viene por URL al pulsar 'Permisos' o por el select)
    String usuarioConfigurar = request.getParameter("usuario");
    String accion = request.getParameter("accion");
    String mensajeAlerta = null;

    Connection conexion = null;

    try {
        Class.forName("org.postgresql.Driver");
        conexion = DriverManager.getConnection(url, dbUsuario, dbPassword);

        // =========================================================================
        // 2. GUARDAR PERMISOS (Si se pulsó el botón Guardar)
        // =========================================================================
        if ("guardar".equals(accion) && usuarioConfigurar != null && !usuarioConfigurar.isBlank()) {
            // Leemos el array de casillas marcadas
            String[] ejerciciosSeleccionados = request.getParameterValues("ejercicios");

            // A. Borramos todos los permisos anteriores de este usuario
            String sqlDelete = "DELETE FROM permiso WHERE usuario = ?";
            PreparedStatement psDelete = conexion.prepareStatement(sqlDelete);
            psDelete.setString(1, usuarioConfigurar);
            psDelete.executeUpdate();

            // B. Si marcó casillas, insertamos cada una en PostgreSQL
            if (ejerciciosSeleccionados != null) {
                String sqlInsert = "INSERT INTO permiso (usuario, ejercicio) VALUES (?, ?)";
                PreparedStatement psInsert = conexion.prepareStatement(sqlInsert);

                for (String numEj : ejerciciosSeleccionados) {
                    psInsert.setString(1, usuarioConfigurar);
                    psInsert.setInt(2, Integer.parseInt(numEj));
                    psInsert.executeUpdate();
                }
            }
            mensajeAlerta = "¡Permisos actualizados con éxito para el usuario <strong>" + usuarioConfigurar + "</strong>! ✅";
        }

        // =========================================================================
        // 3. CONSULTAR PERMISOS ACTUALES (Para poner 'checked' a las casillas)
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
    <title>Permisos</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>

<%--13.7.3. Amplía el programa anterior para que se pueda asignar o quitar permiso para ejecutar las aplicaciones de la
relación anterior a los distintos usuarios. Por ejemplo, que se pueda especificar que el usuario “jaimito” pueda ejecutar
los ejercicios 2, 3 y 5. Para ello, en la base de datos deberá existir una tabla con las parejas (usuario, nº ejercicio).
Por ejemplo, si el usuario “jaimito” tiene acceso a los ejercicios 2, 3 y 5; en la tabla correspondiente estarán las
parejas (jaimito, 2), (jaimito, 3) y (jaimito, 5). Lo ideal es que la asignación de permisos se haga mediante el marcado
de múltiples “checkbox”.
--%>
<body class="bg-light">

<!-- Barra Superior -->
<nav class="navbar navbar-dark bg-dark">
    <div class="container">
        <span class="navbar-brand mb-0 h1">
            <i class="fas fa-tasks text-warning mr-2"></i> Asignación de Permisos
        </span>
        <a href="gestionUsuarios.jsp" class="btn btn-outline-light btn-sm font-weight-bold">
            <i class="fas fa-arrow-left"></i> Volver a Usuarios
        </a>
    </div>
</nav>

<div class="container mt-4 mb-5">
    <div class="row justify-content-center">
        <div class="col-md-8">

            <% if (mensajeAlerta != null) { %>
            <div class="alert alert-success alert-dismissible fade show shadow-sm">
                <%= mensajeAlerta %>
            </div>
            <% } %>

            <div class="card shadow-sm border-0">
                <div class="card-header bg-primary text-white font-weight-bold">
                    <i class="fas fa-user-cog mr-1"></i> Configurar Permisos por Ejercicio
                </div>
                <div class="card-body p-4">

                    <!-- Selector de Usuario -->
                    <form action="permisos.jsp" method="get" class="mb-4">
                        <label class="font-weight-bold">Selecciona el usuario que deseas configurar:</label>
                        <select name="usuario" class="custom-select" onchange="this.form.submit()">
                            <option value="">-- Elige un usuario --</option>
                            <%
                                Statement sUser = conexion.createStatement();
                                ResultSet rsUsers = sUser.executeQuery("SELECT usuario FROM usuario WHERE usuario <> 'admin' ORDER BY usuario ASC");
                                while (rsUsers.next()) {
                                    String u = rsUsers.getString("usuario");
                                    String selected = u.equals(usuarioConfigurar) ? "selected" : "";
                            %>
                            <option value="<%= u %>" <%= selected %>><%= u %></option>
                            <%
                                }
                            %>
                        </select>
                    </form>

                    <% if (usuarioConfigurar != null && !usuarioConfigurar.isBlank()) { %>
                    <hr>
                    <!-- Formulario de Checkboxes -->
                    <form action="permisos.jsp" method="post">
                        <input type="hidden" name="accion" value="guardar">
                        <input type="hidden" name="usuario" value="<%= usuarioConfigurar %>">

                        <p class="font-weight-bold text-secondary mb-3">
                            Marca las aplicaciones a las que tendrá acceso <span class="badge badge-info p-2"><%= usuarioConfigurar %></span>:
                        </p>

                        <!-- Lista de Casillas de Verificación (Checkboxes) -->
                        <div class="list-group mb-4">
                            <%
                                String[] nombresEjercicios = {
                                        "Ejercicio 1 - Control de Acceso Básico",
                                        "Ejercicio 2 - Gestión y Alta de Usuarios",
                                        "Ejercicio 3 - Asignación de Permisos Granulares",
                                        "Ejercicio 4 - CRUD Club de Baloncesto",
                                        "Ejercicio 5 - Búsqueda de Clientes",
                                        "Ejercicio 6 - GESTISIMAL (Control de Almacén)"
                                };

                                for (int i = 1; i <= 6; i++) {
                                    boolean marcado = permisosActuales.contains(i);
                            %>
                            <label class="list-group-item list-group-item-action d-flex align-items-center">
                                <input type="checkbox" name="ejercicios" value="<%= i %>"
                                       class="mr-3" style="width: 20px; height: 20px;"
                                    <%= marcado ? "checked" : "" %>>
                                <span class="font-weight-bold">
                                            <%= nombresEjercicios[i-1] %>
                                        </span>
                            </label>
                            <%
                                }
                            %>
                        </div>

                        <button type="submit" class="btn btn-success btn-block font-weight-bold py-2 shadow-sm">
                            <i class="fas fa-save mr-1"></i> Guardar Permisos para <%= usuarioConfigurar %>
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