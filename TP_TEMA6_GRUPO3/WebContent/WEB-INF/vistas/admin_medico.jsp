<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page 
import="frgp.utn.edu.ar.entidad.Medicos, java.util.List, java.text.SimpleDateFormat, java.text.ParseException, java.util.Date, java.time.LocalDate ,frgp.utn.edu.ar.NegocioImp.MedicosNegocio, frgp.utn.edu.ar.NegocioImp.UsuarioNegocio,frgp.utn.edu.ar.NegocioImp.EspecialidadNegocio,frgp.utn.edu.ar.entidad.Usuario,frgp.utn.edu.ar.entidad.Especialidad"
%>
<html>
<head>
<link rel="stylesheet" href="./adminMedico.css">
<meta charset="UTF-8">
<title>admin_medico</title>
</head>
<body>
    <div class="admin-medicos-container">
        <div class="welcome-header">
            <div class="info">
                <h2>Bienvenido/a</h2>
                <p>ID Admin</p>
                <form method="get">
                    <button type="submit" formaction="redireccionar_Admin.html" class="btn-guardar-fila">Volver a menú</button>
                </form>
            </div>
        </div>
        
        <%
        List<Especialidad> especialidades = (List<Especialidad>) request.getAttribute("especialidades");
        
        Medicos medico_m = null;
        Usuario user = null;
        
        List<Medicos> listaMed = (List<Medicos>) request.getAttribute("medicos");
        %>
        
        
        <% if(request.getAttribute("mensajeError") != null) { %>
            <div class="error"><%= request.getAttribute("mensajeError") %></div>
        <% } %>
        <% if(request.getAttribute("mensajeExito") != null) { %>
            <div class="exito"><%= request.getAttribute("mensajeExito") %></div>
        <% } %>
        
        <div class="admin-medicos-container">
            <h3>Gestionar Médicos</h3>
            
            <form action="alta_medico.html" method="post" class="admin-medicos-form">
                <table>
                    <thead>
                        <tr>
                            <th>Datos</th>
                            <th>Vinculación</th>
                            <th>Estado</th>
                            <th>Acción</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <strong>Legajo:</strong>
                                <input type="text" name="legajo" value="" required><br><br>
                                <strong>Nombre:</strong>
                                <input type="text" name="nombre" value="" required><br><br>
                                <strong>Apellido:</strong>
                                <input type="text" name="apellido" value="" required><br><br>
                                <strong>Sexo:</strong>
                                <select name="Sexo" required>
                                    <option value="Masculino" selected>Masculino</option>
                                    <option value="Femenino">Femenino</option>
                                    <option value="Otro">Otro</option>
                                </select><br><br>
                                <strong>Dirección:</strong>
                                <input type="text" name="direccion" value="" required><br><br>
                                <strong>Localidad:</strong>
                                <input type="text" name="localidad" value="" required><br><br>
                                <strong>Fecha de Nacimiento:</strong>
                                <input type="date" name="fechaNac" required><br><br>
                                <strong>Correo electrónico:</strong>
                                <input type="email" name="email" value="" required><br><br>
                                <strong>Días de trabajo:</strong>
                                <input type="text" name="Dias" value="" required><br><br>
                                <strong>Horarios de trabajo:</strong>
                                <input type="text" name="horarios" value="" required><br><br>
                                <strong>Teléfono:</strong>
                                <input type="tel" name="telefono" value="" required>
                            </td>
                            <td>
                                <strong>Usuario:</strong>
                                <input type="text" name="user" value="" required><br><br>
                                <strong>Contraseña:</strong>
                                <input type="password" name="password" value="" required><br><br>
                                <strong>Especialidad:</strong>
                                <select name="especialidad" required>
                                    <% for(Especialidad es : especialidades) { %>
                                        <option value="<%= es.getId() %>"><%= es.getNombre() %></option>
                                    <% } %>
                                </select><br><br>
                            </td>
                            <td>
                                <strong>Activo</strong>
                                <input type="radio" name="estado" value="activo" checked required><br><br>
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
        
        <div class="admin-medicos-container">
            <h3>Lista de Médicos</h3>
            <form action="filtrar_medicos.html" method="post" class="admin-medicos-form">
                <strong>Legajo:</strong>
                <input type="text" name="Legajo" placeholder="Ingrese legajo">
                <strong>Especialidad:</strong>
                <select name="especialidad">
                    <option value="">Todas</option>
                    <% for(Especialidad es : especialidades) { %>
                        <option value="<%= es.getId() %>"><%= es.getNombre() %></option>
                    <% } %>
                </select>
                <button type="submit" class="btn-Buscar-fila" name="btnBuscar">Filtrar</button>
            </form>    
            <form action="redireccionar_modificarMed_admin.html" method="post" class="admin-medicos-form">
                <table>
                    <thead>
                        <tr>
                            <th>Legajo</th>
                            <th>Usuario</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Especialidad</th>
                            <th>Sexo</th>
                            <th>Dirección</th>
                            <th>Localidad</th>
                            <th>Fecha Nac.</th>
                            <th>Email</th>
                            <th>Días Trabajo</th>
                            <th>Teléfono</th>
                            <th>Estado</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                   <tbody>
                        <%
                            for(Medicos medico : listaMed) {
                        %>
                                <tr>
                                    <td><%= medico.getLegajo() %></td>
                                    <td><%= medico.getUsuario() != null ? medico.getUsuario().getNombre_Usuario() : "" %></td>
                                    <td><%= medico.getNombre() %></td>
                                    <td><%= medico.getApellido() %></td>
                                    <td><%= medico.getEspecialidad() != null ? medico.getEspecialidad().getNombre() : "" %></td>
                                    <td><%= medico.getSexo() %></td>
                                    <td><%= medico.getDireccion() %></td>
                                    <td><%= medico.getLocalidad() %></td>
                                    <td><%= medico.getFechaNac() != null ? medico.getFechaNac() : "" %></td>
                                    <td><%= medico.getEmail() %></td>
                                    <td><%= medico.getDiasLab() %></td>
                                    <td><%= medico.getTelefono() %></td>
                                    <td><%= medico.isEstado() ? "Activo" : "Inactivo" %></td>
                                    <td>
                                        <button type="submit" class="btn-guardar-fila" name="btnModificar" value="<%= medico.getLegajo() %>">Modificar</button>
                                    </td>
                                </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </form>
            
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
                        <a href="?page=<%= i %>" class="page-link active"><%= i %></a>
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