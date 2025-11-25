<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page 
import="frgp.utn.edu.ar.entidad.Medicos, java.util.List, java.text.SimpleDateFormat, java.text.ParseException, java.util.Date, java.time.LocalDate ,frgp.utn.edu.ar.NegocioImp.MedicosNegocio, frgp.utn.edu.ar.NegocioImp.UsuarioNegocio,frgp.utn.edu.ar.NegocioImp.EspecialidadNegocio,frgp.utn.edu.ar.entidad.Usuario,frgp.utn.edu.ar.entidad.Especialidad"
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./modMed.css">
</head>
<body>
<%
        List<Especialidad> especialidades = (List<Especialidad>) request.getAttribute("especialidades");
        
        Medicos medico_m = (Medicos) request.getAttribute("medicoSeleccionado");
        %>
	<div class="admin-medicos-container">
    	<h3>Gestionar Médicos</h3>
        <form action="modif_medico.html" method="post" class="admin-medicos-form">
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
                 	 <% if(medico_m != null) { %>
                        <tr>
                            <td>
                                <strong>Legajo: <%= medico_m.getLegajo() %></strong><br><br>
                                <input type="hidden" name="legajo" value="<%= medico_m.getLegajo() %>">
                                <strong>Nombre:</strong>
                                <input type="text" name="nombre" value="<%= medico_m.getNombre() %>" ><br><br>
                                <strong>Apellido:</strong>
                                <input type="text" name="apellido" value="<%= medico_m.getApellido() %>" ><br><br>
                                <strong>Sexo:</strong>
                                <select name="Sexo" required>
                                    <option value="Masculino" <%= "Masculino".equals(medico_m.getSexo()) ? "selected" : "" %>>Masculino</option>
                                    <option value="Femenino" <%= "Femenino".equals(medico_m.getSexo()) ? "selected" : "" %>>Femenino</option>
                                    <option value="Otro" <%= "Otro".equals(medico_m.getSexo()) ? "selected" : "" %>>Otro</option>
                                </select><br><br>
                                <strong>Dirección:</strong>
                                <input type="text" name="direccion" value="<%= medico_m.getDireccion() %>" ><br><br>
                                <strong>Localidad:</strong>
                                <input type="text" name="localidad" value="<%= medico_m.getLocalidad() %>" ><br><br>
                                <strong>Fecha de Nacimiento:</strong>
                                <input type="date" name="fechaNac" value="<%= medico_m.getFechaNac() %>" ><br><br>
                                <strong>Correo electrónico:</strong>
                                <input type="email" name="email" value="<%= medico_m.getEmail() %>" ><br><br>
                                <strong>Días de trabajo:</strong>
                                <input type="text" name="Dias" value="<%= medico_m.getDiasLab() %>" ><br><br>
                                <strong>Horarios de trabajo:</strong>
                                <input type="text" name="horarios" value="<%= medico_m.getHorarioLab() %>" ><br><br>
                                <strong>Teléfono:</strong>
                                <input type="tel" name="telefono" value="<%= medico_m.getTelefono() %>" >
                            </td>
                            <td>
                                <strong>Usuario:</strong>
                                <input type="text" name="user" value="<%= medico_m.getUsuario().getNombre_Usuario() %>" ><br><br>
                                <strong>Contraseña:</strong>
                                <input type="password" name="password" value="<%= medico_m.getUsuario().getContraseña() %>" ><br><br>
                                <strong>Especialidad:</strong>
                                <select name="especialidad" >
                                    <% for(Especialidad es : especialidades) { %>
                                        <option value="<%= es.getId() %>" <%= es.getId() == medico_m.getEspecialidad().getId() ? "selected" : "" %>>
                                            <%= es.getNombre() %>
                                        </option>
                                    <% } %>
                                </select><br><br>
                            </td>
                            <td>
                                <strong>Activo</strong>
                                <input type="radio" name="estado" value="activo" <%= medico_m.isEstado() ? "checked" : "" %> ><br><br>
                                <strong>Inactivo</strong>
                                <input type="radio" name="estado" value="inactivo" <%= !medico_m.isEstado() ? "checked" : "" %>>
                            </td>
                            <td>
                                <button type="submit" class="btn-guardar-fila" name="btnguardar_Modificar">Guardar</button>
                            </td>
                        </tr>
                        <% }%>
                </tbody>
            </table>
    	</form>
	</div>
</body>
</html>