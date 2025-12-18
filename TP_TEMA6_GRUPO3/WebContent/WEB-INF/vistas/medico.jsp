<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Panel del Médico - Turnos</title>
<script>
    $(document).ready(function () {
        $('#tabla').DataTable({
            pageLength: 10,
            lengthMenu: [5, 10, 20],
            searching: true,
            ordering: true,
            language: {
                url: "https://cdn.datatables.net/plug-ins/1.13.6/i18n/es-ES.json"
            }
        });
    });
</script>
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
<div class="medico-container">
    <div class="welcome-header">
        <div class="info">
            <h2>Bienvenido/a, ${medicoLogueado.nombre} ${medicoLogueado.apellido}</h2>
            <p>Legajo: ${medicoLogueado.legajo}</p>
            <c:if test="${not empty mensajeError}">
				<div class="alert-error">${mensajeError}</div>
			</c:if>	
			<c:if test="${not empty mensajeExito}">
				<div class="alert-success">${mensajeExito}</div>
			</c:if>
			<form method="get">
	        	<button type="submit" formaction="redireccionar_pag1.html" class="btn-guardar-fila">Cerrar Sesion</button>
	        </form>
        </div>
    </div>
    <h2>Turnos</h2>
    <form action="modif_turnoMedico.html" method="post" class="turnos-form">
    <input type="hidden" value="${medicoLogueado.legajo}" name="medicoLegajo">
    <table	id="tabla" class="display">
        <thead>
            <tr>
                <th>Datos del Paciente</th>
                <th>Datos del Turno</th>
                <th>Acciones / Observaciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listTurnos}" var="t">
                <tr>
                    <td>
                        <strong>DNI:</strong> ${t.paciente.DNI}<br>
                        <strong>Nombre y apellido:</strong> ${t.paciente.nombre} ${t.paciente.apellido}<br>
                        <strong>Teléfono:</strong> ${t.paciente.telefono}<br>
                        <strong>Dirección:</strong> ${t.paciente.direccion}<br>
                        <strong>Nacimiento:</strong> ${t.paciente.fecha_nacimiento}<br>
                        <strong>Email:</strong> ${t.paciente.correo_electronico}
                    </td>
                    <td>
                        <strong>ID:</strong> ${t.id}<br>
                        <strong>Fecha:</strong> ${t.fecha}<br>
                        <strong>Hora:</strong> ${t.hora}
                    </td>
                    <td>
                        <label for="obs_${t.id}">
                            <strong>Observación:</strong>
                        </label>
                        <textarea id="obs_${t.id}" name="observacion_${t.id}">${t.observacion}</textarea>
                        <div class="asistencia-group" style="margin-top: 10px;">
                            <strong>Asistencia:</strong><br>
                            <input type="radio"
                                   id="presente_${t.id}"
                                   name="asistencia_${t.id}"
                                   value="Atendido"
                                   <c:if test="${t.estadoTurno == 'Atendido'}">checked</c:if>>
                            <label for="presente_${t.id}">Presente</label>
                            <input type="radio"
                                   id="ausente_${t.id}"
                                   name="asistencia_${t.id}"
                                   value="Ausente"
                                   <c:if test="${t.estadoTurno == 'Ausente'}">checked</c:if>>
                            <label for="ausente_${t.id}">Ausente</label>
                        </div>
                        <button type="submit" class="btn-guardar-fila" name="btnguardar" value="${t.id}">Guardar</button>
                    </td>
                </tr>

            </c:forEach>
        </tbody>

    </table>
</form>
</div>
</body>
</html>