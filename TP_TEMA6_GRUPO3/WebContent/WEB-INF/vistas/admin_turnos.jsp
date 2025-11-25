<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page 
import="frgp.utn.edu.ar.entidad.Medicos, java.util.List, java.time.LocalDate ,frgp.utn.edu.ar.NegocioImp.MedicosNegocio, frgp.utn.edu.ar.NegocioImp.UsuarioNegocio,frgp.utn.edu.ar.NegocioImp.EspecialidadNegocio,frgp.utn.edu.ar.entidad.Usuario,frgp.utn.edu.ar.entidad.Especialidad"
%>
<%@page 
import="frgp.utn.edu.ar.entidad.Turno, frgp.utn.edu.ar.NegocioImp.TurnoNegocio"
%>
<%@page 
import="frgp.utn.edu.ar.entidad.Paciente, frgp.utn.edu.ar.NegocioImp.PacienteNegocio"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Panel de Administrador - Turnos</title>
<link rel="stylesheet" href="./adminTurnos.css">
</head>
<body>
<%
TurnoNegocio negTurno = new TurnoNegocio();
MedicosNegocio negMedico = new MedicosNegocio();
PacienteNegocio negP = new PacienteNegocio();

List<Especialidad> especialidades = (List<Especialidad>) request.getAttribute("especialidades");
String mensajeError = null;
String mensajeExito = null;

/*if(request.getParameter("btnguardar")!=null) {
    try {
        String dni = request.getParameter("dni");
        int legajo = Integer.parseInt(request.getParameter("Legajo"));
        int idEspecialidad = Integer.parseInt(request.getParameter("especialidad"));
        LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
        String hora = request.getParameter("hora");
        
        // Validaciones
        if(negMedico.Exist(legajo)==false) {
            mensajeError = "No existe médico con ese número de legajo";
        } 
        else if(negMedico.FiltarXEspecilidadYLegajo(legajo, idEspecialidad)==null) {
            mensajeError = "El médico no ejerce esa especialidad";
        }
        else if(negP.Exist(dni)==false) {
            mensajeError = "No existe paciente con ese número de DNI";
        }
        else {
            Turno t = new Turno();
            t.setPaciente(negP.ReadOne(dni));
            t.setMedico(negMedico.ReadOne(legajo));
            t.setEstado(true);
            t.setFecha(request.getParameter("fecha"));
            t.setHora(hora);
            
            if(negTurno.AgregarTurno(t)) {
                mensajeExito = "Turno asignado correctamente";
            } else {
                mensajeError = "Error al guardar el turno";
            }
        }
    }catch(NumberFormatException e) {
        mensajeError = "Formato numérico inválido";
    }/*catch(DateTimeParseException e) {
        mensajeError = "Formato de fecha/hora inválido";
    }
    catch(Exception e) {
        mensajeError = "Error inesperado: " + e.getMessage();
    } 
}*/
%>

<div class="admin-container">
    <div class="welcome-header">
        <div class="info">
            <h2>Bienvenido/a</h2>
            <p>ID Admin</p>
            <form method="get">
                <button type="submit" formaction="redireccionar_Admin.html" class="btn-guardar-fila">Volver a menú</button>
            </form>
        </div>
    </div>
    
    <h2>Asignación de Turnos</h2>
    
    <% if(mensajeError != null) { %>
        <div class="alert alert-error">
            <%= mensajeError %>
        </div>
    <% } %>
    
    <% if(mensajeExito != null) { %>
        <div class="alert alert-success">
            <%= mensajeExito %>
        </div>
    <% } %>
    
    <form method="post" class="admin-turnos-form">
        <table>
            <thead>
                <tr>
                    <th>Asignacion</th>
                    <th>Datos del Turno</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <strong>DNI Paciente:</strong><br><br>
                        <input type="text" name="dni" value="<%= request.getParameter("dni") != null ? request.getParameter("dni") : "" %>" required><br><br>
                        <strong>Legajo Medico:</strong><br><br>
                        <input type="number" name="Legajo" value="<%= request.getParameter("Legajo") != null ? request.getParameter("Legajo") : "" %>" required><br><br>
                        <strong>Fecha:</strong>
                        <input type="date" name="fecha" value="<%= request.getParameter("fecha") != null ? request.getParameter("fecha") : "" %>" required><br><br>
                        <strong>Hora:</strong>
                        <input type="time" name="hora" value="<%= request.getParameter("hora") != null ? request.getParameter("hora") : "" %>" required><br><br>
                        <strong>Especialidad:</strong>
                        <select name="especialidad" required>
                            <% for(Especialidad es : especialidades) { %>
                                <option value="<%= es.getId() %>" <%= request.getParameter("especialidad") != null && request.getParameter("especialidad").equals(String.valueOf(es.getId())) ? "selected" : "" %>>
                                    <%= es.getNombre() %>
                                </option>
                            <% } %>
                        </select><br><br>
                    </td>
                    <td>
                        <button type="submit" class="btn-guardar-fila" name="btnguardar">Guardar</button>
                    </td>
                </tr>
            </tbody>
        </table>
        <br>
    </form>  
</div>
</html>