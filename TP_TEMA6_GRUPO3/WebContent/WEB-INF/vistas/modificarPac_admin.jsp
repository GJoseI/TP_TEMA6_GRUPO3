<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page 
import="frgp.utn.edu.ar.entidad.Paciente, java.util.List, java.text.SimpleDateFormat, java.text.ParseException, java.util.Date, java.time.LocalDate ,frgp.utn.edu.ar.NegocioImp.MedicosNegocio, frgp.utn.edu.ar.NegocioImp.UsuarioNegocio,frgp.utn.edu.ar.NegocioImp.EspecialidadNegocio,frgp.utn.edu.ar.entidad.Usuario,frgp.utn.edu.ar.entidad.Especialidad"
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
</style>
</head>
<body>
<%
Paciente paciente_p = (Paciente) request.getAttribute("pacienteSeleccionado");
%>
<div class="admin-pacientes-container">
        <h3>Gestionar Pacientes</h3>
        
        <form action="modif_paciente.html" method="post" class="admin-pacientes-form">
        <input type="hidden" value="${usuarioLogeado.Nombre_Usuario}" name="usuarioLogueado">
            <table>
                <thead>
                    <tr>
                        <th>Datos</th>
                        <th>Estado</th>
                    </tr>
                </thead>
                <tbody>
                <%if(paciente_p != null){ %>
                    <tr>
                        <td>
                            <strong>DNI:</strong>
                            <input type="text" name="dni" value="<%= paciente_p.getDNI()%>"><br><br>
                            <strong>Nombre:</strong>
                            <input type="text" name="nombre" value="<%=paciente_p.getNombre()%>"><br><br>
                            <strong>Apellido:</strong>
                            <input type="text" name="apellido" value="<%= paciente_p.getApellido()%>"><br><br>
                            <strong>Teléfono:</strong>
                            <input type="text" name="telefono" value="<%= paciente_p.getTelefono()%>"><br><br>
                            <strong>Dirección:</strong>
                            <input type="text" name="direccion" value="<%= paciente_p.getDireccion()%>"><br><br>
                            <strong>Localidad:</strong>
                            <input type="text" name="localidad" value="<%= paciente_p.getLocalidad()%>"><br><br>
                            <strong>Provincia:</strong>
                            <input type="text" name="provincia" value="<%= paciente_p.getProvincia()%>"><br><br>
                            <strong>Fecha de Nacimiento:</strong>
                            <input type="date" name="fecha_nacimiento" value="<%=paciente_p.getFecha_nacimiento() %>" ><br><br>
                            <strong>Correo electrónico:</strong>
                            <input type="email" name="email" value="<%=paciente_p.getCorreo_electronico() %>">
                        </td>    
                        <td>
                            <strong>Activo</strong>
                            <input type="radio" name="estado" value="activo" <%= paciente_p.isEstado() ? "checked" : "" %>><br>
                            <strong>Inactivo</strong>
                            <input type="radio" name="estado" value="inactivo" <%= !paciente_p.isEstado() ? "checked" : "" %>>
                        </td>
                        <td>
                            <button type="submit" class="btn-guardar-fila" name="btnguardar_Modificar">Guardar</button>
                        </td>
                    </tr>
                    <%} %>
                </tbody>
            </table>
        </form> 
    </div>   
</body>
</html>