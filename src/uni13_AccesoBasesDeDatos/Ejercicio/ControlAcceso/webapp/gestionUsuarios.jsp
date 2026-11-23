<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    // =========================================================================
    // 1. FILTRO DE SEGURIDAD (En la cima absoluta: antes de cualquier HTML)
    // =========================================================================
    String rolActual = (String) session.getAttribute("rol");
    if (!"ADMIN".equals(rolActual)) {
        response.sendRedirect("indexAcceso.jsp");
        return; // Detiene de inmediato el servidor antes de mandar HTML
    }

    request.setCharacterEncoding("UTF-8");

    String url = "jdbc:postgresql://localhost:5432/baloncesto_db";
    String dbUsuario = "postgres";
    String dbPassword = "***";

    String accion = request.getParameter("accion");
    String mensajeAlerta = null;
    String tipoAlerta = null;

    Connection conexion = null;

    try {
        Class.forName("org.postgresql.Driver");
        conexion = DriverManager.getConnection(url, dbUsuario, dbPassword);

        // =========================================================================
        // 2. LÓGICA DE ALTA DE NUEVO USUARIO
        // =========================================================================
        if ("registrar".equals(accion)) {
            String nuevoUser = request.getParameter("nuevoUsuario");
            String nuevaClave = request.getParameter("nuevaClave");

            if (nuevoUser != null && !nuevoUser.isBlank() && nuevaClave != null && !nuevaClave.isBlank()) {
                nuevoUser = nuevoUser.trim();
                nuevaClave = nuevaClave.trim();

                // Comprobar que NO exista otro usuario igual (insensible a mayúsculas)
                String sqlCheck = "SELECT COUNT(*) FROM usuario WHERE LOWER(usuario) = LOWER(?)";
                PreparedStatement psCheck = conexion.prepareStatement(sqlCheck);
                psCheck.setString(1, nuevoUser);
                ResultSet rsCheck = psCheck.executeQuery();
                rsCheck.next();

                if (rsCheck.getInt(1) > 0) {
                    tipoAlerta = "danger";
                    mensajeAlerta = "Error: El nombre de usuario <strong>" + nuevoUser + "</strong> ya existe. Elige otro.";
                } else {
                    String sqlInsert = "INSERT INTO usuario (usuario, clave) VALUES (?, ?)";
                    PreparedStatement psInsert = conexion.prepareStatement(sqlInsert);
                    psInsert.setString(1, nuevoUser);
                    psInsert.setString(2, nuevaClave);
                    psInsert.executeUpdate();

                    tipoAlerta = "success";
                    mensajeAlerta = "¡Usuario <strong>" + nuevoUser + "</strong> dado de alta con éxito! ✅";
                }
            }
        }
%>


<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Panel de Administración - Usuarios</title>
    <!-- Bootstrap 4 y FontAwesome -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<body class="bg-light">

<%--13.7.2. Mejora el programa anterior de tal forma que se puedan dar de alta nuevos usuarios para acceder a la aplicación.
Si se introduce un nombre de usuario que no sea el administrador (admin) y una contraseña correcta, la aplicación funcionará
exactamente igual que el ejercicio anterior. Si se introduce el usuario admin y la contraseña correcta, la aplicación
entra en la gestión de usuarios donde se podrán dar de alta nuevos usuarios indicando nombre de usuario y contraseña.
No puede haber dos nombres de usuario iguales aunque sí puede haber claves repetidas.--%>

<!-- Barra Superior de Navegación -->
<nav class="navbar navbar-dark bg-dark">
    <div class="container">
        <span class="navbar-brand mb-0 h1">
            <i class="fas fa-user-shield text-warning mr-2"></i> Panel de Administración
        </span>
        <div>
            <!-- NUEVO: Botón para ir directo a la matriz de permisos -->
            <a href="permisos.jsp" class="btn btn-warning btn-sm mr-2 font-weight-bold">
                <i class="fas fa-tasks"></i> Asignar Permisos
            </a>
            <!-- Botón para ir al CRUD de socios -->
            <a href="index.jsp" class="btn btn-outline-light btn-sm mr-2">
                <i class="fas fa-basketball-ball"></i> Ir a Socios
            </a>
            <!-- Botón Cerrar Sesión seguro -->
            <a href="indexAcceso.jsp?logout=true" class="btn btn-danger btn-sm">
                <i class="fas fa-sign-out-alt"></i> Salir
            </a>
        </div>
    </div>
</nav>

<div class="container mt-4">

    <!-- Mensajes de Estado (Éxito o Error) -->
    <% if (mensajeAlerta != null) { %>
    <div class="alert alert-<%= tipoAlerta %> alert-dismissible fade show shadow-sm" role="alert">
        <%= mensajeAlerta %>
    </div>
    <% } %>

    <div class="row">
        <!-- COLUMNA 1: FORMULARIO DE ALTA -->
        <div class="col-md-5 mb-4">
            <div class="card shadow-sm border-0">
                <div class="card-header bg-primary text-white font-weight-bold">
                    <i class="fas fa-user-plus mr-1"></i> Dar de Alta Nuevo Usuario
                </div>
                <div class="card-body">
                    <form action="gestionUsuarios.jsp" method="post">
                        <input type="hidden" name="accion" value="registrar">

                        <div class="form-group">
                            <label class="font-weight-bold">Nombre de usuario:</label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                </div>
                                <input type="text" name="nuevoUsuario" class="form-control" placeholder="Ej: jaimito"
                                       required autocomplete="off">
                            </div>
                            <small class="form-text text-muted">No puede haber dos usuarios iguales.</small>
                        </div>

                        <div class="form-group">
                            <label class="font-weight-bold">Contraseña:</label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-key"></i></span>
                                </div>
                                <input type="password" name="nuevaClave" class="form-control"
                                       placeholder="Introduce la contraseña" required>
                            </div>
                            <small class="form-text text-muted">Las contraseñas sí pueden repetirse.</small>
                        </div>

                        <button type="submit" class="btn btn-success btn-block font-weight-bold mt-4">
                            <i class="fas fa-check"></i> Dar de Alta
                        </button>
                    </form>
                </div>
            </div>
        </div>

        <!-- COLUMNA 2: LISTA DE USUARIOS REGISTRADOS -->
        <div class="col-md-7">
            <div class="card shadow-sm border-0">
                <div class="card-header bg-secondary text-white font-weight-bold">
                    <i class="fas fa-users mr-1"></i> Usuarios con Acceso a la App
                </div>
                <div class="card-body p-0">
                    <table class="table table-hover mb-0">
                        <thead class="thead-light">
                        <tr>
                            <th>Usuario</th>
                            <th>Tipo de Cuenta</th>
                            <th class="text-center">Acciones</th> <!-- NUEVA COLUMNA -->
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            Statement s = conexion.createStatement();
                            ResultSet rsUsuarios = s.executeQuery("SELECT usuario FROM usuario ORDER BY usuario ASC");

                            while (rsUsuarios.next()) {
                                String u = rsUsuarios.getString("usuario");
                                boolean esAdmin = "admin".equalsIgnoreCase(u);
                        %>
                        <tr>
                            <td class="align-middle font-weight-bold">
                                <i class="fas <%= esAdmin ? "fa-user-cog text-primary" : "fa-user text-muted" %> mr-2"></i>
                                <%= u %>
                            </td>
                            <td class="align-middle">
                                <span class="badge badge-<%= esAdmin ? "primary" : "light border" %>">
                                    <%= esAdmin ? "Administrador" : "Usuario Estándar" %>
                                </span>
                            </td>
                            <!-- NUEVO: Botón de Permisos al lado de cada usuario -->
                            <td class="align-middle text-center">
                                <% if (!esAdmin) { %>
                                <a href="permisos.jsp?usuario=<%= u %>" class="btn btn-outline-primary btn-sm font-weight-bold">
                                    <i class="fas fa-key"></i> Permisos
                                </a>
                                <% } else { %>
                                <span class="text-muted small"><i class="fas fa-lock"></i> Acceso Total</span>
                                <% } %>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
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