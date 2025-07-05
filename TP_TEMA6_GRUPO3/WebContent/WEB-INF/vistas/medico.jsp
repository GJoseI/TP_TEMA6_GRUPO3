<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>



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

    <div class="medico-container">
        <div class="welcome-header">
            <img src="img/user_icon.png" alt="Logo de Usuario" class="user-icon">
            <div class="info">
                <h2>Bienvenido/a, Dr./a. Perz juan</h2>
                <p>Legajo: 0011</p>
            </div>
        </div>

        <h3>Turnos del día</h3>
        
        <form action="procesar_turnos.jsp" method="post" class="turnos-form">
            <table>
                <thead>
                    <tr>
                        <th>Datos del Paciente</th>
                        <th>Datos del Turno</th>
                        <th>Acciones / Observaciones</th>
                    </tr>
                </thead>
                <tbody>
   <%--        
                   <tr>
                        <td>
                            <strong>DNI:</strong> <%= turno.getPacDni() %><br>
                            <strong>Nombre y apellido:</strong> <%= turno.getPacNombre() %> <%= turno.getPacApellido() %><br>
                            <strong>Teléfono:</strong> <%= turno.getPacTelefono() %><br>
                            <strong>Dirección:</strong> <%= turno.getPacDireccion() %>, <%= turno.getPacLocalidad() %>, <%= turno.getPacProvincia() %><br>
                            <strong>Nacimiento:</strong> <%= turno.getPacFechaNac() %><br>
                            <strong>Email:</strong> <%= turno.getPacEmail() %>
                        </td>
                        <td>
                            <strong>Fecha:</strong> <%= turno.getFecha() %><br>
                            <strong>Hora:</strong> <%= turno.getHora() %>
                        </td>
                        <td>
                            <label for="obs_<%= turno.getPacDni() %>"><strong>Observación:</strong></label>
                            <textarea id="obs_<%= turno.getPacDni() %>" name="observacion_<%= turno.getPacDni() %>"></textarea>
                            
                            <div class="asistencia-group" style="margin-top: 10px;">
                                <strong>Asistencia:</strong><br>
                                <input type="radio" id="presente_<%= turno.getPacDni() %>" name="asistencia_<%= turno.getPacDni() %>" value="presente" required>
                                <label for="presente_<%= turno.getPacDni() %>">Presente</label>
                                
                                <input type="radio" id="ausente_<%= turno.getPacDni() %>" name="asistencia_<%= turno.getPacDni() %>" value="ausente">
                                <label for="ausente_<%= turno.getPacDni() %>">Ausente</label>
                            </div>
                            <button type="submit" class="btn-guardar-fila" name="btnguardar">Guardar</button>
                        </td>
                    </tr>
                    
                    <tr>
                        
                    --%>
                     <tr>
    <td>
        <strong>DNI:</strong> 34567890<br>
        <strong>Nombre y apellido:</strong> María López<br>
        <strong>Teléfono:</strong> 1123456789<br>
        <strong>Dirección:</strong> Av. Siempre Viva 742, Springfield, Buenos Aires<br>
        <strong>Nacimiento:</strong> 1985-03-15<br>
        <strong>Email:</strong> maria.lopez@example.com
    </td>
    <td>
        <strong>Fecha:</strong> 2025-07-03<br>
        <strong>Hora:</strong> 10:00
    </td>
    <td>
        <label for="obs_34567890"><strong>Observación:</strong></label>
        <textarea id="obs_34567890" name="observacion_34567890">Paciente con dolor de cabeza leve.</textarea>
        
        <div class="asistencia-group" style="margin-top: 10px;">
            <strong>Asistencia:</strong><br>
            <input type="radio" id="presente_34567890" name="asistencia_34567890" value="presente" required checked>
            <label for="presente_34567890">Presente</label>
            
            <input type="radio" id="ausente_34567890" name="asistencia_34567890" value="ausente">
            <label for="ausente_34567890">Ausente</label>
        </div>
        <button type="submit" class="btn-guardar-fila" name="btnguardar">Guardar</button>
    </td>
</tr>

<tr>
    <td>
        <strong>DNI:</strong> 28765432<br>
        <strong>Nombre y apellido:</strong> Juan Pérez<br>
        <strong>Teléfono:</strong> 1198765432<br>
        <strong>Dirección:</strong> Calle Falsa 123, Villa Crespo, CABA<br>
        <strong>Nacimiento:</strong> 1978-11-22<br>
        <strong>Email:</strong> juan.perez@example.com
    </td>
    <td>
        <strong>Fecha:</strong> 2025-07-03<br>
        <strong>Hora:</strong> 11:30
    </td>
    <td>
        <label for="obs_28765432"><strong>Observación:</strong></label>
        <textarea id="obs_28765432" name="observacion_28765432">Requiere revisión anual.</textarea>
        
        <div class="asistencia-group" style="margin-top: 10px;">
            <strong>Asistencia:</strong><br>
            <input type="radio" id="presente_28765432" name="asistencia_28765432" value="presente" required>
            <label for="presente_28765432">Presente</label>
            
            <input type="radio" id="ausente_28765432" name="asistencia_28765432" value="ausente" checked>
            <label for="ausente_28765432">Ausente</label>
        </div>
        <button type="submit" class="btn-guardar-fila" name="btnguardar">Guardar</button>
    </td>
</tr>

<tr>
    <td>
        <strong>DNI:</strong> 40123456<br>
        <strong>Nombre y apellido:</strong> Ana García<br>
        <strong>Teléfono:</strong> 1155551234<br>
        <strong>Dirección:</strong> Boulevard de los Sueños Rotos 45, La Plata, Buenos Aires<br>
        <strong>Nacimiento:</strong> 1992-07-01<br>
        <strong>Email:</strong> ana.garcia@example.com
    </td>
    <td>
        <strong>Fecha:</strong> 2025-07-04<br>
        <strong>Hora:</strong> 09:15
    </td>
    <td>
        <label for="obs_40123456"><strong>Observación:</strong></label>
        <textarea id="obs_40123456" name="observacion_40123456"></textarea>
        
        <div class="asistencia-group" style="margin-top: 10px;">
            <strong>Asistencia:</strong><br>
            <input type="radio" id="presente_40123456" name="asistencia_40123456" value="presente" required>
            <label for="presente_40123456">Presente</label>
            
            <input type="radio" id="ausente_40123456" name="asistencia_40123456" value="ausente">
            <label for="ausente_40123456">Ausente</label>
        </div>
        <button type="submit" class="btn-guardar-fila" name="btnguardar">Guardar</button>
    </td>
</tr>

<tr>
    <td>
        <strong>DNI:</strong> 30987654<br>
        <strong>Nombre y apellido:</strong> Carlos Ruiz<br>
        <strong>Teléfono:</strong> 1167890123<br>
        <strong>Dirección:</strong> Calle del Sol Naciente 10, Córdoba Capital, Córdoba<br>
        <strong>Nacimiento:</strong> 1970-04-10<br>
        <strong>Email:</strong> carlos.ruiz@example.com
    </td>
    <td>
        <strong>Fecha:</strong> 2025-07-04<br>
        <strong>Hora:</strong> 14:00
    </td>
    <td>
        <label for="obs_30987654"><strong>Observación:</strong></label>
        <textarea id="obs_30987654" name="observacion_30987654">Traer estudios previos.</textarea>
        
        <div class="asistencia-group" style="margin-top: 10px;">
            <strong>Asistencia:</strong><br>
            <input type="radio" id="presente_30987654" name="asistencia_30987654" value="presente" required checked>
            <label for="presente_30987654">Presente</label>
            
            <input type="radio" id="ausente_30987654" name="asistencia_30987654" value="ausente">
            <label for="ausente_30987654">Ausente</label>
        </div>
        <button type="submit" class="btn-guardar-fila" name="btnguardar">Guardar</button>
    </td>
</tr>

<tr>
    <td>
        <strong>DNI:</strong> 38765432<br>
        <strong>Nombre y apellido:</strong> Laura Fernández<br>
        <strong>Teléfono:</strong> 1134567890<br>
        <strong>Dirección:</strong> Ruta Vieja 500, Mendoza Capital, Mendoza<br>
        <strong>Nacimiento:</strong> 1995-09-05<br>
        <strong>Email:</strong> laura.fernandez@example.com
    </td>
    <td>
        <strong>Fecha:</strong> 2025-07-05<br>
        <strong>Hora:</strong> 08:45
    </td>
    <td>
        <label for="obs_38765432"><strong>Observación:</strong></label>
        <textarea id="obs_38765432" name="observacion_38765432"></textarea>
        
        <div class="asistencia-group" style="margin-top: 10px;">
            <strong>Asistencia:</strong><br>
            <input type="radio" id="presente_38765432" name="asistencia_38765432" value="presente" required>
            <label for="presente_38765432">Presente</label>
            
            <input type="radio" id="ausente_38765432" name="asistencia_38765432" value="ausente">
            <label for="ausente_38765432">Ausente</label>
        </div>
        <button type="submit" class="btn-guardar-fila" name="btnguardar">Guardar</button>
    </td>
</tr>
                 
 </tbody>
 </table>
      </br>
      <div class="pagination">
        <%-- Botón "Anterior" --%>
        <a href="?page= 1" class=" 2 ? "disabled" : """>
            &laquo; Anterior
        </a>

        <%-- Números de página --%>
            <a href="?page=3" class="2 "active" : ">2
            </a>
 

        <%-- Botón "Siguiente" --%>
        <a href="?page=<3" class=""disabled" : "" %>">
            Siguiente &raquo;
        </a>
    </div>
            
            <button type="submit" class="btn-submit">Guardar Todas las Observaciones y Asistencias</button>
        </form>
    </div>

</body>
</html>