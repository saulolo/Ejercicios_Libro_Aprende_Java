<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificación de Socio</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card shadow-sm">

                <!-- Cabecera celeste igual a la captura del libro -->
                <div class="card-header text-center" style="background-color: #d9edf7; color: #31708f;">
                    <h5 class="mb-0 font-weight-bold">Modificación de socio</h5>
                </div>

                <div class="card-body">
                    <%
                        String url = "jdbc:postgresql://localhost:5432/baloncesto_db";
                        String usuario = "postgres";
                        String password = "***";

                        String socioIdStr = request.getParameter("socioId");

                        if (socioIdStr != null && !socioIdStr.isBlank()) {
                            int socioId = Integer.parseInt(socioIdStr);

                            try {
                                Class.forName("org.postgresql.Driver");
                                Connection conexion = DriverManager.getConnection(url, usuario, password);

                                // Consultamos los datos actuales del socio seleccionado
                                String sql = "SELECT * FROM socio WHERE socio_id = ?";
                                PreparedStatement ps = conexion.prepareStatement(sql);
                                ps.setInt(1, socioId);
                                ResultSet rs = ps.executeQuery();

                                if (rs.next()) {
                                    String nombre = rs.getString("nombre");
                                    double estatura = rs.getDouble("estatura");
                                    int edad = rs.getInt("edad");
                                    String localidad = rs.getString("localidad");
                    %>
                    <!-- Formulario que enviará los datos actualizados a actualizaSocio.jsp -->
                    <form action="actualizaSocio.jsp" method="post">

                        <!-- Nº de Socio (Sólo lectura / readonly) -->
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label font-weight-bold">Nº de socio:</label>
                            <div class="col-sm-3">
                                <input type="text" name="socioId" class="form-control" value="<%= socioId %>" readonly style="background-color: #eee;">
                            </div>
                        </div>

                        <!-- Nombre -->
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label font-weight-bold">Nombre:</label>
                            <div class="col-sm-9">
                                <input type="text" name="nombre" class="form-control" value="<%= nombre %>" required>
                            </div>
                        </div>

                        <!-- Estatura y Edad -->
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label font-weight-bold">Estatura:</label>
                            <div class="col-sm-3">
                                <input type="number" step="0.01" name="estatura" class="form-control" value="<%= estatura %>" required>
                            </div>

                            <label class="col-sm-2 col-form-label font-weight-bold text-sm-right">Edad:</label>
                            <div class="col-sm-3">
                                <input type="number" name="edad" class="form-control" value="<%= edad %>" required>
                            </div>
                        </div>

                        <!-- Localidad -->
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label font-weight-bold">Localidad:</label>
                            <div class="col-sm-6">
                                <input type="text" name="localidad" class="form-control" value="<%= localidad %>" required>
                            </div>
                        </div>

                        <!-- Botones de Acción -->
                        <div class="form-group row mt-4">
                            <div class="col-sm-12">
                                <!-- Botón Cancelar (vuelve sin guardar nada) -->
                                <a href="index.jsp" class="btn btn-danger font-weight-bold mr-2">
                                    <i class="fas fa-times"></i> Cancelar
                                </a>

                                <!-- Botón Aceptar (guarda los cambios) -->
                                <button type="submit" class="btn btn-success font-weight-bold">
                                    <i class="fas fa-check"></i> Aceptar
                                </button>
                            </div>
                        </div>

                    </form>
                    <%
                                } else {
                                    out.println("<div class='alert alert-danger'>No se encontró ningún socio con el ID #" + socioId + "</div>");
                                    out.println("<a href='indexAcceso.jsp' class='btn btn-primary'>Volver al listado</a>");
                                }

                                conexion.close();

                            } catch (Exception e) {
                                out.println("<div class='alert alert-danger'>Error al cargar datos: " + e.getMessage() + "</div>");
                            }
                        } else {
                            out.println("<div class='alert alert-warning'>No se especificó ningún ID de socio.</div>");
                            out.println("<a href='indexAcceso.jsp' class='btn btn-primary'>Volver al listado</a>");
                        }
                    %>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>