<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

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
    <title>Panel del Médico - Turnos</title>
    <link rel="icon" href="img/favicon.ico" type="image/x-icon">
    <style>
        body { background-color: #f0f8ff; font-family: Arial, sans-serif; margin: 20px; }
        .medico-container { background-color: #ffffff; padding: 25px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); max-width: 1200px; margin: auto; }
        .welcome-header { display: flex; align-items: center; margin-bottom: 25px; border-bottom: 2px solid #e0e0e0; padding-bottom: 15px; }
        .welcome-header .user-icon { width: 50px; height: 50px; border-radius: 50%; margin-right: 20px; }
        .welcome-header .info h2 { color: #005a9c; margin: 0; font-size: 22px; }
        .welcome-header .info p { margin: 0; color: #555; }
        .turnos-form table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        .turnos-form th, .turnos-form td { border: 1px solid #ddd; padding: 12px; text-align: left; vertical-align: top; }
        .turnos-form th { background-color: #007bff; color: white; }
        .turnos-form td ul { margin: 0; padding-left: 20px; }
        .turnos-form textarea { width: 95%; height: 60px; margin-top: 5px; border: 1px solid #ccc; border-radius: 4px; padding: 5px; }
        .turnos-form .asistencia-group label { margin-right: 15px; }
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
TurnoNegocio negT = new TurnoNegocio();
List<Turno> listTurnos = negT.ReadAll();

if (request.getParameter("btnguardar") != null) {
    Turno t = new Turno();
    t = negT.ReadOne(Integer.parseInt(request.getParameter("btnguardar")));
    t.setObservación(request.getParameter("observacion"));
    t.setEstadoTurno(request.getParameter("asistencia_34567890"));
    negT.Update(t);
}

if (request.getParameter("btnFiltara") != null) {
    if (request.getParameter("Fecha_Filtara") != null && !request.getParameter("Fecha_Filtara").isEmpty() 
        && request.getParameter("DNI_Filtara") != null && !request.getParameter("DNI_Filtara").isEmpty()) {
        listTurnos = negT.FiltarxFechaxPciente(request.getParameter("Fecha_Filtara"), request.getParameter("DNI_Filtara"));
    } 
    else if (request.getParameter("DNI_Filtara") != null && !request.getParameter("DNI_Filtara").isEmpty()) {
        listTurnos = negT.FiltarPciente(request.getParameter("DNI_Filtara"));
    }
    else if (request.getParameter("Fecha_Filtara") != null && !request.getParameter("Fecha_Filtara").isEmpty()) {
        listTurnos = negT.FiltarxFecha(request.getParameter("Fecha_Filtara"));
    }
}
%>

<div class="medico-container">
    <div class="welcome-header">
        <img src="img/user_icon.png" alt="Logo de Usuario" class="user-icon">
        <div class="info">
            <h2>Bienvenido/a, Perz Juan</h2>
            <p>Legajo: 0011</p>
        </div>
    </div>

    <h2>Turnos</h2>

    <form method="post" class="filtros-form">
        <strong>DNI:</strong>
        <input type="text" name="DNI_Filtara" value="<%= request.getParameter("DNI_Filtara") != null ? request.getParameter("DNI_Filtara") : "" %>"><br><br>
        <strong>Fecha:</strong>
        <input type="date" name="Fecha_Filtara" value="<%= request.getParameter("Fecha_Filtara") != null ? request.getParameter("Fecha_Filtara") : "" %>"><br><br>
        <button type="submit" class="btn-Buscar-fila" name="btnFiltara">Filtrar</button>
    </form>

    <form action="" method="post" class="turnos-form">
        <table>
            <thead>
                <tr>
                    <th>Datos del Paciente</th>
                    <th>Datos del Turno</th>
                    <th>Acciones / Observaciones</th>
                </tr>
            </thead>
            <tbody>
                <% for(Turno t : listTurnos) { %>
                <tr>
                    <td>
                        <strong>DNI:</strong> <%= t.getPaciente().getDNI() %><br>
                        <strong>Nombre y apellido:</strong> <%= t.getPaciente().getNombre() + " " + t.getPaciente().getApellido() %><br>
                        <strong>Teléfono:</strong> <%= t.getPaciente().getTelefono() %><br>
                        <strong>Dirección:</strong> <%= t.getPaciente().getDireccion() %><br>
                        <strong>Nacimiento:</strong> <%= t.getPaciente().getFecha_nacimiento() %><br>
                        <strong>Email:</strong> <%= t.getPaciente().getCorreo_electronico() %>
                    </td>
                    <td>
                        <strong>ID:</strong> <%= t.getId() %><br>
                        <strong>Fecha:</strong> <%= t.getFecha() %><br>
                        <strong>Hora:</strong> <%= t.getHora() %>
                    </td>
                    <td>
                        <label for="obs_<%= t.getId() %>"><strong>Observación:</strong></label>
                        <textarea id="obs_<%= t.getId() %>" name="observacion"><%= t.getObservación() != null ? t.getObservación() : "" %></textarea>
                        
                        <div class="asistencia-group" style="margin-top: 10px;">
                            <strong>Asistencia:</strong><br>
                            <input type="radio" id="presente_<%= t.getId() %>" name="asistencia_<%= t.getId() %>" value="presente" <%= "presente".equals(t.getEstadoTurno()) ? "checked" : "" %>>
                            <label for="presente_<%= t.getId() %>">Presente</label>
                            
                            <input type="radio" id="ausente_<%= t.getId() %>" name="asistencia_<%= t.getId() %>" value="ausente" <%= "ausente".equals(t.getEstadoTurno()) ? "checked" : "" %>>
                            <label for="ausente_<%= t.getId() %>">Ausente</label>
                        </div>
                        <button type="submit" class="btn-guardar-fila" name="btnguardar" value="<%= t.getId() %>">Guardar</button>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
        
        <br>
        <div class="pagination">
            <%
            int currentPage = 1;
            String pageParam = request.getParameter("page");
            if (pageParam != null && !pageParam.isEmpty()) {
                currentPage = Integer.parseInt(pageParam);
            }
            
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
    </form>
</div>
</body>
</html>