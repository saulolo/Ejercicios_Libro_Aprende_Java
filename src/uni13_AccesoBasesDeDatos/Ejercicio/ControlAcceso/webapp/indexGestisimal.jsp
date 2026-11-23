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
        // 1. ENTRADA DE MERCANCÍA (Sumar al Stock)
        // =========================================================
        if ("entrada".equals(accion)) {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));

            if (cantidad > 0) {
                String sqlEntrada = "UPDATE articulo SET stock = stock + ? WHERE codigo = ?";
                PreparedStatement psEntrada = conexion.prepareStatement(sqlEntrada);
                psEntrada.setInt(1, cantidad);
                psEntrada.setInt(2, codigo);
                psEntrada.executeUpdate();
                alerta = "Se han añadido <strong>" + cantidad + "</strong> unidades al artículo #" + codigo + ". 📦";
            }
        }

        // =========================================================
        // 2. SALIDA DE MERCANCÍA (Restar con Control de Stock)
        // =========================================================
        if ("salida".equals(accion)) {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));

            // Consultamos el stock actual antes de retirar
            String sqlCheck = "SELECT descripcion, stock FROM articulo WHERE codigo = ?";
            PreparedStatement psCheck = conexion.prepareStatement(sqlCheck);
            psCheck.setInt(1, codigo);
            ResultSet rsCheck = psCheck.executeQuery();

            if (rsCheck.next()) {
                String desc = rsCheck.getString("descripcion");
                int stockActual = rsCheck.getInt("stock");

                // REGLA DE NEGOCIO: No se puede sacar más de lo que hay
                if (cantidad > stockActual) {
                    alerta = "Error: Stock insuficiente. No puedes retirar <strong>" + cantidad
                            + "</strong> unidades de <em>" + desc + "</em> porque solo quedan <strong>" + stockActual + "</strong> en almacén.";
                    tipoAlerta = "danger";
                } else {
                    String sqlSalida = "UPDATE articulo SET stock = stock - ? WHERE codigo = ?";
                    PreparedStatement psSalida = conexion.prepareStatement(sqlSalida);
                    psSalida.setInt(1, cantidad);
                    psSalida.setInt(2, codigo);
                    psSalida.executeUpdate();
                    alerta = "Salida de <strong>" + cantidad + "</strong> unidades registrada. Stock restante: <strong>" + (stockActual - cantidad) + "</strong>. 🚚";
                }
            }
        }

        // =========================================================
        // 3. ELIMINAR ARTÍCULO
        // =========================================================
        if ("borrar".equals(accion)) {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            String sqlDelete = "DELETE FROM articulo WHERE codigo = ?";
            PreparedStatement psDelete = conexion.prepareStatement(sqlDelete);
            psDelete.setInt(1, codigo);
            psDelete.executeUpdate();
            alerta = "Artículo #" + codigo + " eliminado del almacén.";
            tipoAlerta = "warning";
        }

        // =========================================================
        // 4. AÑADIR NUEVO ARTÍCULO (Comprobación de clave única)
        // =========================================================
        if ("anadir".equals(accion)) {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            String descripcion = request.getParameter("descripcion").trim();
            double precioCompra = Double.parseDouble(request.getParameter("precioCompra"));
            double precioVenta = Double.parseDouble(request.getParameter("precioVenta"));
            int stock = Integer.parseInt(request.getParameter("stock"));

            // Comprobar si ya existe el código
            String sqlExiste = "SELECT COUNT(*) FROM articulo WHERE codigo = ?";
            PreparedStatement psExiste = conexion.prepareStatement(sqlExiste);
            psExiste.setInt(1, codigo);
            ResultSet rsExiste = psExiste.executeQuery();
            rsExiste.next();

            if (rsExiste.getInt(1) > 0) {
                alerta = "Error: El artículo con código " + codigo + " ya existe en el almacén.";
                tipoAlerta = "danger";
            } else {
                String sqlInsert = "INSERT INTO articulo (codigo, descripcion, precio_compra, precio_venta, stock) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement psInsert = conexion.prepareStatement(sqlInsert);
                psInsert.setInt(1, codigo);
                psInsert.setString(2, descripcion);
                psInsert.setDouble(3, precioCompra);
                psInsert.setDouble(4, precioVenta);
                psInsert.setInt(5, stock);
                psInsert.executeUpdate();
                alerta = "Artículo <strong>" + descripcion + "</strong> dado de alta con éxito.";
                tipoAlerta = "success";
            }
        }
%>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GESTISIMAL - Control de Almacén</title>
    <!-- Bootstrap 4 y FontAwesome -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<body class="bg-light">

<%--13.7.6 Crea una versión web del programa GESTISIMAL (GESTIón SIMplifcada de Almacén) para llevar el control de los
artículos de un almacén. De cada artículo se debe saber el código, la descripción, el precio de compra, el precio de
venta y el stock (número de unidades). La entrada y salida de mercancía supone respectivamente el incremento y decremento
de stock de un determinado artículo. Hay que controlar que no se pueda sacar más mercancía de la que hay en el almacén.
Aprovecha las opciones que puede ofrecer una interfaz web, por ejemplo para eliminar un artículo ya no será necesario
pedir el código sino que se puede mostrar un listado de todos los artículos de tal forma que se puedan borrar un artículo
directamente pulsando un botón.--%>

<!-- Barra Superior -->
<nav class="navbar navbar-dark bg-dark shadow-sm">
    <div class="container-fluid">
        <span class="navbar-brand mb-0 h1">
            <i class="fas fa-boxes text-warning mr-2"></i> GESTISIMAL <small class="text-muted font-weight-normal">(Gestión Simplificada de Almacén)</small>
        </span>
    </div>
</nav>

<div class="container-fluid mt-4 mb-5">

    <% if (alerta != null) { %>
    <div class="alert alert-<%= tipoAlerta %> alert-dismissible fade show shadow-sm text-center font-weight-bold">
        <%= alerta %>
        <button type="button" class="close" data-dismiss="alert">&times;</button>
    </div>
    <% } %>

    <div class="card shadow-sm border-0">
        <div class="card-header bg-white py-3 d-flex justify-content-between align-items-center">
            <h5 class="mb-0 font-weight-bold text-dark"><i class="fas fa-list mr-2"></i>Inventario de Artículos</h5>
        </div>
        <div class="card-body p-0">
            <div class="table-responsive">
                <table class="table table-hover table-striped mb-0">
                    <thead class="thead-dark">
                    <tr>
                        <th style="width: 8%;">Código</th>
                        <th style="width: 25%;">Descripción</th>
                        <th style="width: 12%;">P. Compra</th>
                        <th style="width: 12%;">P. Venta</th>
                        <th style="width: 10%;" class="text-center">Stock</th>
                        <th style="width: 33%;" class="text-center">Acciones</th>
                    </tr>
                    </thead>
                    <tbody>
                    <!-- FILA 1: FORMULARIO RÁPIDO PARA ALTA DE ARTÍCULO -->
                    <tr class="table-info">
                        <form action="indexGestisimal.jsp" method="post">
                            <input type="hidden" name="accion" value="anadir">
                            <td><input type="number" name="codigo" class="form-control form-control-sm" placeholder="Código" required></td>
                            <td><input type="text" name="descripcion" class="form-control form-control-sm" placeholder="Descripción del artículo" required></td>
                            <td><input type="number" step="0.01" name="precioCompra" class="form-control form-control-sm" placeholder="Compra €" required></td>
                            <td><input type="number" step="0.01" name="precioVenta" class="form-control form-control-sm" placeholder="Venta €" required></td>
                            <td><input type="number" name="stock" class="form-control form-control-sm text-center" placeholder="Cant." min="0" required></td>
                            <td class="text-center">
                                <button type="submit" class="btn btn-primary btn-sm font-weight-bold">
                                    <i class="fas fa-plus"></i> Añadir Artículo
                                </button>
                            </td>
                        </form>
                    </tr>

                    <%
                        Statement s = conexion.createStatement();
                        ResultSet rs = s.executeQuery("SELECT * FROM articulo ORDER BY codigo ASC");

                        while (rs.next()) {
                            int cod = rs.getInt("codigo");
                            String desc = rs.getString("descripcion");
                            double pCompra = rs.getDouble("precio_compra");
                            double pVenta = rs.getDouble("precio_venta");
                            int stock = rs.getInt("stock");

                            // Estilo visual del Stock (Verde > 10, Amarillo < 10, Rojo == 0)
                            String badgeClass = stock == 0 ? "badge-danger" : (stock < 10 ? "badge-warning" : "badge-success");
                    %>
                    <tr>
                        <td class="align-middle font-weight-bold">#<%= cod %></td>
                        <td class="align-middle"><%= desc %></td>
                        <td class="align-middle"><%= String.format("%.2f", pCompra) %> €</td>
                        <td class="align-middle font-weight-bold text-primary"><%= String.format("%.2f", pVenta) %> €</td>
                        <td class="align-middle text-center">
                                <span class="badge <%= badgeClass %> p-2" style="font-size: 13px;">
                                    <%= stock %> uds
                                </span>
                        </td>
                        <td class="align-middle text-center">
                            <!-- Botón + Entrada (Verde) -->
                            <button type="button" class="btn btn-success btn-sm font-weight-bold mr-1"
                                    data-toggle="modal" data-target="#modalEntrada"
                                    data-codigo="<%= cod %>" data-desc="<%= desc %>">
                                <i class="fas fa-arrow-down"></i> + Entrada
                            </button>

                            <!-- Botón - Salida (Naranja) -->
                            <button type="button" class="btn btn-warning btn-sm font-weight-bold text-dark mr-1"
                                    data-toggle="modal" data-target="#modalSalida"
                                    data-codigo="<%= cod %>" data-desc="<%= desc %>" data-stock="<%= stock %>">
                                <i class="fas fa-arrow-up"></i> - Salida
                            </button>

                            <!-- Botón Modificar (Cian) -->
                            <a href="modificaArticulo.jsp?codigo=<%= cod %>" class="btn btn-info btn-sm font-weight-bold mr-1">
                                <i class="fas fa-edit"></i>
                            </a>

                            <!-- Botón Eliminar (Rojo con confirmación) -->
                            <form action="indexGestisimal.jsp" method="post" class="d-inline">
                                <input type="hidden" name="accion" value="borrar">
                                <input type="hidden" name="codigo" value="<%= cod %>">
                                <button type="submit" class="btn btn-danger btn-sm"
                                        onclick="return confirm('¿Seguro que deseas eliminar <%= desc %>?');">
                                    <i class="fas fa-trash"></i>
                                </button>
                            </form>
                        </td>
                    </tr>
                    <%
                        } // Fin del while
                    %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<!-- =========================================================
     MODAL PARA ENTRADA DE MERCANCÍA (+ Stock)
     ========================================================= -->
<div class="modal fade" id="modalEntrada" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header bg-success text-white">
                <h5 class="modal-title font-weight-bold"><i class="fas fa-box-open mr-2"></i>Entrada de Mercancía</h5>
                <button type="button" class="close text-white" data-dismiss="modal">&times;</button>
            </div>
            <form action="indexGestisimal.jsp" method="post">
                <div class="modal-body">
                    <input type="hidden" name="accion" value="entrada">
                    <input type="hidden" name="codigo" id="inputCodigoEntrada">
                    <p>Introduce las unidades recibidas para: <strong id="descEntrada"></strong></p>
                    <div class="form-group">
                        <label class="font-weight-bold">Cantidad a añadir:</label>
                        <input type="number" name="cantidad" class="form-control" min="1" placeholder="Ej: 10" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                    <button type="submit" class="btn btn-success font-weight-bold">Registrar Entrada</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- =========================================================
     MODAL PARA SALIDA DE MERCANCÍA (- Stock con Control)
     ========================================================= -->
<div class="modal fade" id="modalSalida" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header bg-warning text-dark">
                <h5 class="modal-title font-weight-bold"><i class="fas fa-dolly mr-2"></i>Salida de Mercancía</h5>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <form action="indexGestisimal.jsp" method="post">
                <div class="modal-body">
                    <input type="hidden" name="accion" value="salida">
                    <input type="hidden" name="codigo" id="inputCodigoSalida">
                    <p>Retirar unidades para: <strong id="descSalida"></strong></p>
                    <p class="text-muted small">Stock disponible actual: <strong id="stockActualSalida"></strong> uds.</p>
                    <div class="form-group">
                        <label class="font-weight-bold">Cantidad a retirar:</label>
                        <input type="number" name="cantidad" class="form-control" min="1" placeholder="Ej: 5" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                    <button type="submit" class="btn btn-warning font-weight-bold">Registrar Salida</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- jQuery y Bootstrap JS (Necesarios para que los Modals funcionen) -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<!-- Script para pasar los datos del artículo al Modal correspondiente -->
<script>
    $('#modalEntrada').on('show.bs.modal', function (event) {
        var btn = $(event.relatedTarget);
        $('#inputCodigoEntrada').val(btn.data('codigo'));
        $('#descEntrada').text(btn.data('desc'));
    });

    $('#modalSalida').on('show.bs.modal', function (event) {
        var btn = $(event.relatedTarget);
        $('#inputCodigoSalida').val(btn.data('codigo'));
        $('#descSalida').text(btn.data('desc'));
        $('#stockActualSalida').text(btn.data('stock'));
    });
</script>

</body>
</html>
<%
        conexion.close();
    } catch (Exception e) {
        out.println("<div class='alert alert-danger m-4 text-center'>Error de conexión: " + e.getMessage() + "</div>");
    }
%>