<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Panel del Médico - Turnos</title>
    <link rel="icon" href="img/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" 
      href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css">

<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>

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
    </style>
</head>
<body>
<div class="medico-container">
    <div class="welcome-header">
        <div class="info">
            <h2>Bienvenido/a, ${medicoLogueado.nombre} ${medicoLogueado.apellido}</h2>
            <p>Legajo: ${medicoLogueado.legajo}</p>
	        <button type="submit" formaction="redireccionar_pag1.html" class="btn-guardar-fila">Cerrar Sesion</button>
        </div>
    </div>
    <h2>Turnos</h2>
    <form action="" method="post" class="turnos-form">
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
                        <textarea id="obs_${t.id}" name="observacion">${t.observacion}</textarea>
                        <div class="asistencia-group" style="margin-top: 10px;">
                            <strong>Asistencia:</strong><br>
                            <input type="radio"
                                   id="presente_${t.id}"
                                   name="asistencia_${t.id}"
                                   value="presente"
                                   <c:if test="${t.estadoTurno == 'Atendido'}">checked</c:if>>
                            <label for="presente_${t.id}">Presente</label>
                            <input type="radio"
                                   id="ausente_${t.id}"
                                   name="asistencia_${t.id}"
                                   value="ausente"
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