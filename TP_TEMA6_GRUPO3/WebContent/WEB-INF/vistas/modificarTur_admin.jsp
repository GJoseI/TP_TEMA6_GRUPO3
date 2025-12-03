<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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
	<c:set var="turno" value="${turnoSeleccionado}" />	
	<div class="admin-medicos-container">
    	<h3>Gestionar Turno</h3>
        <form action="modif_turno.html" method="post" class="admin-medicos-form">
        	<table>
            	<thead>
                	<tr>
                    	<th>Datos</th>
                        <th>Especialidad</th>
                        <th>Estado</th>
                        <th>Acción</th>
                    </tr>
                 </thead>
                 <tbody>
                 	 <c:if test="${turno != null}">
                        <tr>
                            <td>
	                            <strong>ID Turno: ${turno.id}</strong><br><br>
	                            <input type="hidden" name="legajo" value="${turno.id}">
	                            <strong>DNI Paciente:</strong>
	                            <input type="hidden" name="dniP" value="${${turno.paciente != null ? turno.paciente.DNI : ''}"><br><br>
	                            <strong>Legajo Medico</strong>
	                            <input type="hidden" name="legajoM" value="${turno.Medico != null ? turno.Medico.legajo : ''}"><br><br>
	                            <strong>Fecha:</strong>
	                            <input type="text" name="direccion" value="${turno.fecha}"><br><br>
	                            <strong>Hora:</strong>
	                            <input type="text" name="localidad" value="${turno.hora}"><br><br>
	                            <strong>Observaciones:</strong>
	                            <input type="date" name="fechaNac" value="${turno.observacion}"><br><br>
	                            <strong>Asistencia:</strong>
	                            <input type="email" name="email" value="${turno.estadoTurno}"><br><br>
                            </td>
                            <td>
                            	<strong>Especialidad:</strong>
                            	<select name="especialidad">
                                <c:forEach items="${especialidades}" var="especialidad">
                                    <option value="${especialidad.id}" 
                                    ${turno.especialidad != null && turno.especialidad.id == especialidad.id ? 'selected' : ''}>
                                    ${especialidad.nombre}
                                    </option>
                                </c:forEach>
                            	</select><br><br>
                            </td>
                            <td>
                                <strong>Activo</strong>
                                <input type="radio" name="estado" value="activo" ${turno.estado ? 'checked' : ''}><br><br>
                                <strong>Inactivo</strong>
                                <input type="radio" name="estado" value="inactivo" ${!turno.estado ? 'checked' : ''}>
                            </td>
                            <td>
                                <button type="submit" class="btn-guardar-fila" name="btnmodificar">Guardar</button>
                            </td>
                        </tr>
                       </c:if>
                </tbody>
            </table>
    	</form>
	</div>
</body>
</html>