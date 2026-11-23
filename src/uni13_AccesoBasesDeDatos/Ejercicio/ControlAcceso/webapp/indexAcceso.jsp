<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Control de Acceso</title>
    <link rel="stylesheet" type="text/css" href="style.css?v=login1"/>
    <!-- Iconos de FontAwesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<body>

<%--13.7.1. Establece un control de acceso mediante nombre de usuario y contraseña para alguno de los programas de la
relación anterior (por ejemplo el que pinta una pirámide). Lo primero que aparecerá por pantalla será un formulario
pidiendo el nombre de usuario y la contraseña. Si el usuario y la contraseña son correctos, se podrá acceder al ejercicio;
en caso contrario, volverá a aparecer el formulario pidiendo los datos de acceso y no se nos dejará ejecutar la aplicación
hasta que iniciemos sesión con un nombre de usuario y contraseña correctos. Los nombres de usuario y contraseñas deben
estar almacenados en la tabla de una base de datos.--%>

<div class="login-card">
    <h2>Control de acceso</h2>

    <%
        String url = "jdbc:postgresql://localhost:5432/baloncesto_db";
        String dbUsuario = "postgres";
        String dbPassword = "***";

        String usuarioIngresado = request.getParameter("usuario");
        String claveIngresada = request.getParameter("password");

        boolean accesoConcedido = false;
        String error = null;

        if (usuarioIngresado != null && claveIngresada != null) {
            try {
                Class.forName("org.postgresql.Driver");
                Connection conexion = DriverManager.getConnection(url, dbUsuario, dbPassword);

                String sql = "SELECT * FROM usuario WHERE usuario = ? AND clave = ?";
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps.setString(1, usuarioIngresado.trim());
                ps.setString(2, claveIngresada.trim());

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    session.setAttribute("usuarioLogueado", usuarioIngresado.trim());

                    if ("admin".equalsIgnoreCase(usuarioIngresado.trim())) {
                        session.setAttribute("rol", "ADMIN");
                        response.sendRedirect("gestionUsuarios.jsp");
                        conexion.close();
                        return;

                    } else {
                        session.setAttribute("rol", "USER");
                        accesoConcedido = true;
                    }
                } else {
                    error = "Usuario o contraseña incorrectos.";
                }

                conexion.close();
            } catch (Exception e) {
                error = "Error de conexión: " + e.getMessage();
            }
        }
    %>

    <%
        // =========================================================================
        // PANTALLA 2: ACCESO CONCEDIDO (Candado Abierto)
        // =========================================================================
        if (accesoConcedido) {
    %>
    <div class="candado-exito">
        <i class="fas fa-lock-open"></i>
    </div>
    <p class="texto-exito">Acceso permitido a la aplicación.</p>

    <!-- Redirige al CRUD principal (index.jsp) -->
    <a href="index.jsp" class="btn-aceptar">
        ACEPTAR <i class="fas fa-check-circle"></i>
    </a>

    <%
        // =========================================================================
        // PANTALLA 1: FORMULARIO DE ACCESO (Usuario y Contraseña)
        // =========================================================================
    } else {
        if (error != null) {
    %>
    <div class="mensaje-error"><%= error %></div>
    <%
        }
    %>
    <form action="indexAcceso.jsp" method="post">
        <!-- Campo Usuario -->
        <div class="input-group">
            <i class="fas fa-user-circle"></i>
            <input type="text" name="usuario" placeholder="Usuario" required autocomplete="off">
        </div>

        <!-- Campo Contraseña -->
        <div class="input-group">
            <i class="fas fa-lock"></i>
            <input type="password" name="password" placeholder="Contraseña" required>
        </div>

        <!-- Botón de Envío -->
        <button type="submit" class="btn-aceptar">
            ACEPTAR <i class="fas fa-check-circle"></i>
        </button>
    </form>
    <%
        }
    %>

</div>

</body>
</html>