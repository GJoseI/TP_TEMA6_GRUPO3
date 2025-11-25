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
    <link rel="stylesheet" href="./medico.css">
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