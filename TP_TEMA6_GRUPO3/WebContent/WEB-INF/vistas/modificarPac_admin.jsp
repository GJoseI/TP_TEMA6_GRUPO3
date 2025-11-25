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
<link rel="stylesheet" href="./modPac.css">
</head>
<body>
<%
Paciente paciente_p = (Paciente) request.getAttribute("pacienteSeleccionado");
%>
<div class="admin-pacientes-container">
        <h3>Gestionar Pacientes</h3>
        
        <form action="modif_paciente.html" method="post" class="admin-pacientes-form">
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