<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page 
import="frgp.utn.edu.entidad.Medicos, java.util.List, java.time.LocalDate ,NegocioImp.MedicosNegocio, NegocioImp.UsuarioNegocio,NegocioImp.EspecialidadNegocio,frgp.utn.edu.entidad.Usuario,frgp.utn.edu.entidad.Especialidad"
%>
<%@page 
import="frgp.utn.edu.entidad.Turno, NegocioImp.TurnoNegocio"
%>
<%@page 
import="frgp.utn.edu.entidad.Paciente, NegocioImp.PacienteNegocio"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Panel de Administrador - Turnos</title>
<style>
	.admin-container { background-color: #ffffff; padding: 25px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); max-width: 1200px; margin: auto; }
	.welcome-header { display: flex; align-items: center; margin-bottom: 25px; border-bottom: 2px solid #e0e0e0; padding-bottom: 15px; }
    .welcome-header .info h2 { color: #005a9c; margin: 0; font-size: 22px; }
    .welcome-header .info p { margin: 0; color: #555; }
    .admin-turnos-form table { width: 100%; border-collapse: collapse; margin-top: 20px; }
    .admin-turnos-form th, .turnos-form td { border: 1px solid #ddd; padding: 12px; text-align: left; vertical-align: top; }
    .admin-turnos-form th { background-color: #007bff; color: white; }
    .admin-turnos-form td ul { margin: 0; padding-left: 20px; }
    .admin-turnos-form textarea { width: 95%; height: 60px; margin-top: 5px; border: 1px solid #ccc; border-radius: 4px; padding: 5px; }
    .admin-turnos-form .asistencia-group label { margin-right: 15px; }
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
	    
	    .alert {
		    padding: 10px;
		    margin: 10px 0;
		    border-radius: 4px;
		}

		.alert-error {
		    background-color: #ffdddd;
		    border-left: 5px solid #f44336;
		    color: #d8000c;
		}
		
		.alert-success {
		    background-color: #ddffdd;
		    border-left: 5px solid #4CAF50;
		    color: #4F8A10;
		}
</style>
</head>
<body>
<%
TurnoNegocio negTurno = new TurnoNegocio();
MedicosNegocio negMedico = new MedicosNegocio();
EspecialidadNegocio epn = new EspecialidadNegocio();
PacienteNegocio negP = new PacienteNegocio();

List<Especialidad> especialidades = epn.ReadAll();
String mensajeError = null;
String mensajeExito = null;

if(request.getParameter("btnguardar")!=null) {
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
    }*/
    catch(Exception e) {
        mensajeError = "Error inesperado: " + e.getMessage();
    } 
}
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