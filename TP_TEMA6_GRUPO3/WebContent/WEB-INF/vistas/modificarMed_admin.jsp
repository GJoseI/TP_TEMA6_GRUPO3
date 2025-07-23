<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page 
import="frgp.utn.edu.entidad.Medicos, java.util.List, java.text.SimpleDateFormat, java.text.ParseException, java.util.Date, java.time.LocalDate ,NegocioImp.MedicosNegocio, NegocioImp.UsuarioNegocio,NegocioImp.EspecialidadNegocio,frgp.utn.edu.entidad.Usuario,frgp.utn.edu.entidad.Especialidad"
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	 body { background-color: #f0f8ff; font-family: Arial, sans-serif; margin: 20px; }
	.admin-medicos-container { background-color: #ffffff; padding: 25px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); max-width: 2000px; margin: auto; }
	.welcome-header { display: flex; align-items: center; margin-bottom: 25px; border-bottom: 2px solid #e0e0e0; padding-bottom: 15px; }
    .welcome-header .info h2 { color: #005a9c; margin: 0; font-size: 22px; }
    .welcome-header .info p { margin: 0; color: #555; }
    .admin-medicos-form table { width: 100%; border-collapse: collapse; margin-top: 20px; }
    .admin-medicos-form th, .turnos-form td { border: 1px solid #ddd; padding: 12px; text-align: left; vertical-align: top; }
    .admin-medicos-form th { background-color: #007bff; color: white; }
    .admin-medicos-form td ul { margin: 0; padding-left: 20px; }
    .admin-medicos-form textarea { width: 95%; height: 60px; margin-top: 5px; border: 1px solid #ccc; border-radius: 4px; padding: 5px; }
    .btn-submit { display: block; width: 100%; padding: 15px; margin-top: 20px; border: none; border-radius: 5px; background-color: #28a745; color: white; font-size: 18px; cursor: pointer; }
    .btn-submit:hover { background-color: #218838; }
    .btn-guardar-fila { width: 100%; padding: 10px; margin-top: 10px; border: none; border-radius: 4px; background-color: #28a745; color: white; font-size: 16px; cursor: pointer; }
    .btn-guardar-fila:hover { background-color: #218838; }
    
    .btn-Buscar-fila { width: 100px; padding: 10px; margin-top: 10px; border: none; border-radius: 4px; background-color: #28a745; color: white; font-size: 16px; cursor: pointer; }
    .btn-Buscar-fila:hover { background-color: #218838; }
</style>
</head>
<body>
<%
        EspecialidadNegocio epn = new EspecialidadNegocio();
        List<Especialidad> especialidades = epn.ReadAll();
        
        MedicosNegocio medNeg = new MedicosNegocio();
        Medicos medico_m = (Medicos) request.getAttribute("medicoSeleccionado");
        Usuario user = null;
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
                                <input type="text" name="nombre" value="<%= medico_m.getNombre() %>" required><br><br>
                                <strong>Apellido:</strong>
                                <input type="text" name="apellido" value="<%= medico_m.getApellido() %>" required><br><br>
                                <strong>Sexo:</strong>
                                <select name="Sexo" required>
                                    <option value="Masculino" <%= "Masculino".equals(medico_m.getSexo()) ? "selected" : "" %>>Masculino</option>
                                    <option value="Femenino" <%= "Femenino".equals(medico_m.getSexo()) ? "selected" : "" %>>Femenino</option>
                                    <option value="Otro" <%= "Otro".equals(medico_m.getSexo()) ? "selected" : "" %>>Otro</option>
                                </select><br><br>
                                <strong>Dirección:</strong>
                                <input type="text" name="direccion" value="<%= medico_m.getDireccion() %>" required><br><br>
                                <strong>Localidad:</strong>
                                <input type="text" name="localidad" value="<%= medico_m.getLocalidad() %>" required><br><br>
                                <strong>Fecha de Nacimiento:</strong>
                                <input type="date" name="fechaNac" value="<%= medico_m.getFechaNac() %>" required><br><br>
                                <strong>Correo electrónico:</strong>
                                <input type="email" name="email" value="<%= medico_m.getEmail() %>" required><br><br>
                                <strong>Días de trabajo:</strong>
                                <input type="text" name="Dias" value="<%= medico_m.getDiasLab() %>" required><br><br>
                                <strong>Horarios de trabajo:</strong>
                                <input type="text" name="horarios" value="<%= medico_m.getHorarioLab() %>" required><br><br>
                                <strong>Teléfono:</strong>
                                <input type="tel" name="telefono" value="<%= medico_m.getTelefono() %>" required>
                            </td>
                            <td>
                                <strong>Usuario:</strong>
                                <input type="text" name="user" value="<%= medico_m.getUsuario().getNombre_Usuario() %>" required><br><br>
                                <strong>Contraseña:</strong>
                                <input type="password" name="password" value="<%= medico_m.getUsuario().getContraseña() %>" required><br><br>
                                <strong>Especialidad:</strong>
                                <select name="especialidad" required>
                                    <% for(Especialidad es : especialidades) { %>
                                        <option value="<%= es.getId() %>" <%= es.getId() == medico_m.getEspecialidad().getId() ? "selected" : "" %>>
                                            <%= es.getNombre() %>
                                        </option>
                                    <% } %>
                                </select><br><br>
                            </td>
                            <td>
                                <strong>Activo</strong>
                                <input type="radio" name="estado" value="activo" <%= medico_m.isEstado() ? "checked" : "" %> required><br><br>
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