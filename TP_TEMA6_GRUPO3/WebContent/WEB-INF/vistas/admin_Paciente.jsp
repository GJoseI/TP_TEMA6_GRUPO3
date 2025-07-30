<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page 
import="frgp.utn.edu.ar.entidad.Paciente, java.util.List, java.time.LocalDate ,frgp.utn.edu.ar.NegocioImp.PacienteNegocio"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Panel de Administrador - Pacientes</title>
<style>
	 body { background-color: #f0f8ff; font-family: Arial, sans-serif; margin: 20px; }
	.admin-pacientes-container { background-color: #ffffff; padding: 25px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); max-width: 1200px; margin: auto; }
	.welcome-header { display: flex; align-items: center; margin-bottom: 25px; border-bottom: 2px solid #e0e0e0; padding-bottom: 15px; }
    .welcome-header .info h2 { color: #005a9c; margin: 0; font-size: 22px; }
    .welcome-header .info p { margin: 0; color: #555; }
    .admin-pacientes-form table { width: 100%; border-collapse: collapse; margin-top: 20px; }
    .admin-pacientes-form th, .turnos-form td { border: 1px solid #ddd; padding: 12px; text-align: left; vertical-align: top; }
    .admin-pacientes-form th { background-color: #007bff; color: white; }
    .admin-pacientes-form td ul { margin: 0; padding-left: 20px; }
    .admin-pacientes-form textarea { width: 95%; height: 60px; margin-top: 5px; border: 1px solid #ccc; border-radius: 4px; padding: 5px; }
    .btn-submit { display: block; width: 100%; padding: 15px; margin-top: 20px; border: none; border-radius: 5px; background-color: #28a745; color: white; font-size: 18px; cursor: pointer; }
    .btn-submit:hover { background-color: #218838; }
    .btn-guardar-fila { width: 100%; padding: 10px; margin-top: 10px; border: none; border-radius: 4px; background-color: #28a745; color: white; font-size: 16px; cursor: pointer; }
    .btn-guardar-fila:hover { background-color: #218838; }
    
    .btn-Buscar-fila { width: 100px; padding: 10px; margin-top: 10px; border: none; border-radius: 4px; background-color: #28a745; color: white; font-size: 16px; cursor: pointer; }
    .btn-Buscar-fila:hover { background-color: #218838; }
    
    .pagination { text-align: center; }
	    .pagination a {
	        color: #007bff;
	        padding: 8px 16px;
	        text-decoration: none;
	        border: 1px solid #ddd;
	        margin: 0 4px;
	        border-radius: 4px;
	        transition: background-color .3s;
	    }
	    .pagination a.active {
	        background-color: #007bff;
	        color: white;
	        border: 1px solid #007bff;
	    }
	    .pagination a:hover:not(.active) {
	        background-color: #ddd;
	    }
	    .pagination a.disabled {
	        color: #ccc;
	        pointer-events: none;
	        border-color: #ccc;
	    }
</style>
</head>
<body>
<%
PacienteNegocio negPaciente = new PacienteNegocio();
List<Paciente> ListaPasiente =(List<Paciente>) request.getAttribute("ListaPasiente");
Paciente paciente = new Paciente();
boolean cuadro = false;

// Variables para control de edición
String pacienteEnEdicion = request.getParameter("editarDni");
boolean editando = pacienteEnEdicion != null && !pacienteEnEdicion.isEmpty();

// Procesar formulario de guardar nuevo paciente
/*if(request.getParameter("btnguardar") != null){
    if(!negPaciente.Exist(request.getParameter("dni"))){
        paciente.setDNI(request.getParameter("dni"));
        paciente.setNombre(request.getParameter("nombre"));
        paciente.setApellido(request.getParameter("apellido"));
        paciente.setTelefono(request.getParameter("telefono"));
        paciente.setDireccion(request.getParameter("direccion"));
        paciente.setLocalidad(request.getParameter("localidad"));
        paciente.setProvincia(request.getParameter("provincia"));
        paciente.setFecha_nacimiento(request.getParameter("fecha_nacimiento"));
        paciente.setCorreo_electronico(request.getParameter("email")); // Corregido: estaba usando dni en lugar de email
        paciente.setEstado("activo".equals(request.getParameter("estado")));
        
        negPaciente.AgregarPaciente(paciente);
        ListaPasiente = negPaciente.ReadAll(); // Actualizar lista
    }
}

// Procesar guardado de edición
if(request.getParameter("btnGuardarEdicion") != null) {
    Paciente p = new Paciente();
    p.setDNI(request.getParameter("editarDni"));
    p.setNombre(request.getParameter("editarNombre"));
    p.setApellido(request.getParameter("editarApellido"));
    p.setTelefono(request.getParameter("editarTelefono"));
    p.setDireccion(request.getParameter("editarDireccion"));
    p.setLocalidad(request.getParameter("editarLocalidad"));
    p.setProvincia(request.getParameter("editarProvincia"));
    
    try {
        p.setFecha_nacimiento(request.getParameter("editarFechaNac"));
    } catch(Exception e) {
        p.setFecha_nacimiento(LocalDate.now().toString());
    }
    
    p.setCorreo_electronico(request.getParameter("editarEmail"));
    p.setEstado("activo".equals(request.getParameter("editarEstado")));
    
    negPaciente.Update(p);
    ListaPasiente = negPaciente.ReadAll(); // Recargar lista
    editando = false;
}

// Procesar eliminación
if(request.getParameter("btnBaja") != null) {
	Paciente pp = negPaciente.ReadOne(request.getParameter("btnBaja"));
    negPaciente.Delete(pp);
    ListaPasiente = negPaciente.ReadAll(); // Recargar lista
}
*/
%>

<div class="admin-pacientes-container">
    <div class="welcome-header">
        <div class="info">
            <h2>Bienvenido/a</h2>
            <p>ID Admin</p>
            <form method="get">
                <button type="submit" formaction="redireccionar_Admin.html" class="btn-guardar-fila">Volver a menú</button>
            </form>
        </div>
    </div>
    
    <% if(request.getAttribute("mensajeError") != null) { %>
            <div class="error"><%= request.getAttribute("mensajeError") %></div>
        <% } %>
        <% if(request.getAttribute("mensajeExito") != null) { %>
            <div class="exito"><%= request.getAttribute("mensajeExito") %></div>
        <% } %>
        
    <div class="admin-pacientes-container">
        <h3>Gestionar Pacientes</h3>
        
        <form action="alta_paciente.html" method="post" class="admin-pacientes-form">
            <table>
                <thead>
                    <tr>
                        <th>Datos</th>
                        <th>Estado</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <strong>DNI:</strong>
                            <input type="text" name="dni" value="" required><br><br>
                            <strong>Nombre:</strong>
                            <input type="text" name="nombre" value="" required><br><br>
                            <strong>Apellido:</strong>
                            <input type="text" name="apellido" value="" required><br><br>
                            <strong>Teléfono:</strong>
                            <input type="text" name="telefono" value=""><br><br>
                            <strong>Dirección:</strong>
                            <input type="text" name="direccion" value=""><br><br>
                            <strong>Localidad:</strong>
                            <input type="text" name="localidad" value=""><br><br>
                            <strong>Provincia:</strong>
                            <input type="text" name="provincia" value=""><br><br>
                            <strong>Fecha de Nacimiento:</strong>
                            <input type="date" name="fecha_nacimiento" value="" required><br><br>
                            <strong>Correo electrónico:</strong>
                            <input type="email" name="email" value="" required>
                        </td>    
                        <td>
                            <strong>Activo</strong>
                            <input type="radio" name="estado" value="activo" checked><br>
                            <strong>Inactivo</strong>
                            <input type="radio" name="estado" value="inactivo">
                        </td>
                        <td>
                            <button type="submit" class="btn-guardar-fila" name="btnguardar">Guardar</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form> 
    </div>   
    
    <br> 
    
    <div class="admin-pacientes-container">    
        <h3>Lista de Pacientes</h3>
        <form method="post">
            <strong>DNI:</strong>
            <input type="text" name="dniBuscar" placeholder="Ingrese DNI">
            <button type="submit" class="btn-Buscar-fila" name="btnBuscar">Filtrar</button>
        </form>
        <br>
        
        <form action="redireccionar_modificarPac_admin.html" method="post" class="admin-pacientes-form">
            <table>
                <thead>
                    <tr>
                        <th>DNI</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Teléfono</th>
                        <th>Dirección</th>
                        <th>Localidad</th>
                        <th>Provincia</th>
                        <th>Fecha Nac.</th>
                        <th>Email</th>
                        <th>Estado</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    if(request.getParameter("btnBuscar") != null) {
                        String DniParam = request.getParameter("dniBuscar");
                        if(DniParam != null && !DniParam.isEmpty()) {
                            cuadro = true;
                            Paciente p = negPaciente.ReadOne(DniParam);
                            if(p != null) {
                    %>
                    <tr>
                            <td><%=p.getDNI()%></td>
                            <td><%=p.getNombre()%></td>
                            <td><%=p.getApellido()%></td>
                            <td><%=p.getTelefono()%></td>
                            <td><%=p.getDireccion()%></td>
                            <td><%=p.getLocalidad()%></td>
                            <td><%=p.getProvincia()%></td>
                            <td><%=p.getFecha_nacimiento()%></td>
                            <td><%=p.getCorreo_electronico()%></td>
                            <td><%=p.isEstado() ? "Activo" : "Inactivo"%></td>
                            <td>
                                <button type="submit" class="btn-guardar-fila" name="btnModificar" value="<%=p.getDNI()%>">Modificar</button>
                            </td>
                        <% } %>
                    </tr>
                    <%
                            }
                        }
                    
                    if(!cuadro) {
                        for (Paciente p : ListaPasiente) { 
                    %>
                    <tr>
                            <td><%=p.getDNI()%></td>
                            <td><%=p.getNombre()%></td>
                            <td><%=p.getApellido()%></td>
                            <td><%=p.getTelefono()%></td>
                            <td><%=p.getDireccion()%></td>
                            <td><%=p.getLocalidad()%></td>
                            <td><%=p.getProvincia()%></td>
                            <td><%=p.getFecha_nacimiento()%></td>
                            <td><%=p.getCorreo_electronico()%></td>
                            <td><%=p.isEstado() ? "Activo" : "Inactivo"%></td>
                            <td>
                                <button type="submit" class="btn-guardar-fila" name="btnModificar" value="<%=p.getDNI()%>">Modificar</button>
                            </td>
                        <% } %>
                    </tr>
                    <% 
                        } 
                    %>
                </tbody>
            </table>
        </form>
        
        <br>
        
        <div class="pagination">
            <%
            int currentPage = 1;
            int totalPages = 5;
            
            if(currentPage > 1) {
            %>
                <a href="?page=<%= currentPage-1 %>" class="page-link">&laquo; Anterior</a>
            <%
            } else {
            %>
                <span class="page-link disabled">&laquo; Anterior</span>
            <%
            }
            
            for(int i = 1; i <= totalPages; i++) {
                if(i == currentPage) {
            %>
                    <span class="page-link active"><%= i %></span>
            <%
                } else {
            %>
                    <a href="?page=<%= i %>" class="page-link"><%= i %></a>
            <%
                }
            }
            
            if(currentPage < totalPages) {
            %>
                <a href="?page=<%= currentPage+1 %>" class="page-link">Siguiente &raquo;</a>
            <%
            } else {
            %>
                <span class="page-link disabled">Siguiente &raquo;</span>
            <%
            }
            %>
        </div>
    </div> 
</div> 
</body>
</html>