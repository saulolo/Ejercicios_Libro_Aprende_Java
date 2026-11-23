<%@ page import="java.sql.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");

    String url = "jdbc:postgresql://localhost:5432/baloncesto_db";
    String dbUsuario = "postgres";
    String dbPassword = "***";

    String criterio = request.getParameter("criterio");
    String codigoDetalle = request.getParameter("codigoDetalle");

    // Clase auxiliar interna para guardar los clientes encontrados
    class ClienteDTO {
        int codigo;
        String nombre;
        String direccion;
        String telefono;
        Date fecha;
        ClienteDTO(int c, String n, String d, String t, Date f) {
            this.codigo = c; this.nombre = n; this.direccion = d; this.telefono = t; this.fecha = f;
        }
    }

    List<ClienteDTO> listaEncontrados = new ArrayList<>();
    ClienteDTO clienteUnico = null;
    String error = null;

    try {
        Class.forName("org.postgresql.Driver");
        Connection conexion = DriverManager.getConnection(url, dbUsuario, dbPassword);

        // =========================================================================
        // CASO A: Se pulsó el botón "+ DETALLE" de un cliente concreto
        // =========================================================================
        if (codigoDetalle != null && !codigoDetalle.isBlank()) {
            String sqlDetalle = "SELECT * FROM cliente WHERE codigo = ?";
            PreparedStatement psDetalle = conexion.prepareStatement(sqlDetalle);
            psDetalle.setInt(1, Integer.parseInt(codigoDetalle));
            ResultSet rsDetalle = psDetalle.executeQuery();
            if (rsDetalle.next()) {
                clienteUnico = new ClienteDTO(
                        rsDetalle.getInt("codigo"),
                        rsDetalle.getString("nombre"),
                        rsDetalle.getString("direccion"),
                        rsDetalle.getString("telefono"),
                        rsDetalle.getDate("fecha_nacimiento")
                );
            }
        }
        // =========================================================================
        // CASO B: Búsqueda por texto (LIKE %criterio%)
        // =========================================================================
        else if (criterio != null && !criterio.isBlank()) {
            String sqlSearch = "SELECT * FROM cliente WHERE LOWER(nombre) LIKE LOWER(?) ORDER BY nombre ASC";
            PreparedStatement psSearch = conexion.prepareStatement(sqlSearch);
            psSearch.setString(1, "%" + criterio.trim() + "%");
            ResultSet rsSearch = psSearch.executeQuery();

            while (rsSearch.next()) {
                listaEncontrados.add(new ClienteDTO(
                        rsSearch.getInt("codigo"),
                        rsSearch.getString("nombre"),
                        rsSearch.getString("direccion"),
                        rsSearch.getString("telefono"),
                        rsSearch.getDate("fecha_nacimiento")
                ));
            }

            // Si solo hubo 1 coincidencia exacta, lo asignamos para mostrar su ficha directa
            if (listaEncontrados.size() == 1) {
                clienteUnico = listaEncontrados.get(0);
            }
        }

        conexion.close();
    } catch (Exception e) {
        error = "Error: " + e.getMessage();
    }
%>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Búsqueda Gestibank</title>
    <!-- Bootstrap 4 y FontAwesome -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="style-buscar.css?v=1"/>

</head>
<body>

<%--13.7.5 Amplía el programa anterior para que se pueda hacer una búsqueda por nombre. El programa buscará la cadena
introducida dentro del campo “nombre” y, si hay varias coincidencias, se mostrará una lista de clientes para poder
seleccionar uno de ellos y ver todos los datos. Si solo hay una coincidencia, se mostrarán directamente los datos del
cliente en cuestión.--%>

<!-- Buscador Superior -->
<div class="card shadow-sm border-0 p-3 mb-2" style="width: 380px;">
    <form action="buscarCliente.jsp" method="get" class="d-flex">
        <input type="text" name="criterio" class="form-control input-busqueda mr-2"
               placeholder="Buscar por nombre..." value="<%= criterio != null ? criterio : "" %>" required>
        <button type="submit" class="btn btn-primary btn-sm rounded-circle px-3">
            <i class="fas fa-search"></i>
        </button>
    </form>
</div>

<% if (error != null) { %>
<div class="alert alert-danger" style="width: 380px;"><%= error %></div>
<% } %>

<%
    // =========================================================================
    // VISTA 1: FICHA DE UN SOLO CLIENTE (IMAGEN 2)
    // Aparece si hubo 1 sola coincidencia o si pulsaron "+ DETALLE"
    // =========================================================================
    if (clienteUnico != null) {
%>
<div class="card-custom">
    <h5 class="text-center font-weight-bold mb-4"><%= clienteUnico.nombre %></h5>

    <div class="item-detalle">
        <i class="fas fa-tag"></i>
        <span>Código: <strong><%= clienteUnico.codigo %></strong></span>
    </div>
    <div class="item-detalle">
        <i class="fas fa-user"></i>
        <span>Nombre: <strong><%= clienteUnico.nombre %></strong></span>
    </div>
    <div class="item-detalle">
        <i class="fas fa-map-marker-alt"></i>
        <span>Dirección: <strong><%= clienteUnico.direccion != null ? clienteUnico.direccion : "" %></strong></span>
    </div>
    <div class="item-detalle">
        <i class="fas fa-phone-alt"></i>
        <span>Teléfono: <strong><%= clienteUnico.telefono != null ? clienteUnico.telefono : "" %></strong></span>
    </div>
    <div class="item-detalle">
        <i class="fas fa-birthday-cake"></i>
        <span>Fecha de nacimiento: <strong><%= clienteUnico.fecha %></strong></span>
    </div>

    <!-- Botón ACEPTAR que regresa a buscar de nuevo -->
    <div class="text-center">
        <a href="buscarCliente.jsp" class="btn-aceptar">
            ACEPTAR <i class="fas fa-check-circle"></i>
        </a>
    </div>
</div>

<%
    // =========================================================================
    // VISTA 2: LISTA DE COINCIDENCIAS MÚLTIPLES (IMAGEN 1)
    // Aparece si hay 2 o más clientes que coinciden con el nombre buscado
    // =========================================================================
} else if (listaEncontrados.size() > 1) {
%>
<div class="card-custom">
    <div class="brand-title">G e s t i b a n k</div>

    <table class="table table-borderless mb-0">
        <thead>
        <tr class="border-bottom">
            <th class="font-weight-bold" style="font-size: 13px;">Nombre</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <% for (ClienteDTO c : listaEncontrados) { %>
        <tr class="border-bottom">
            <td class="align-middle" style="font-size: 13px;"><%= c.nombre %></td>
            <td class="align-middle text-right">
                <a href="buscarCliente.jsp?codigoDetalle=<%= c.codigo %>" class="btn-detalle">
                    <i class="fas fa-plus-circle"></i> DETALLE
                </a>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>

<%
    // =========================================================================
    // VISTA 3: CERO COINCIDENCIAS
    // =========================================================================
} else if (criterio != null) {
%>
<div class="alert alert-warning text-center mt-3" style="width: 380px;">
    No se encontró ningún cliente que contenga "<strong><%= criterio %></strong>".
</div>
<%
    }
%>

<!-- Enlace para volver al CRUD general -->
<div class="mt-4">
    <a href="indexCRUDGestibank.jsp" class="text-secondary small">
        <i class="fas fa-arrow-left"></i> Volver a la gestión de Gestibank
    </a>
</div>

</body>
</html>