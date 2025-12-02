<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Panel de Administrador - Turnos</title>
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
    
    <c:if test="${not empty mensajeError}">
			<div class="error">${mensajeError}</div>
		</c:if>
		
		<c:if test="${not empty mensajeExito}">
			<div class="exito">${mensajeExito}</div>
		</c:if>
    
    <form method="post" class="admin-turnos-form" action="alta_turno.html">
        <table>
            <thead>
                <tr>
                    <th>Datos del turno</th>
                    <th>Estado</th>
                    <th>Guardar</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <strong>DNI Paciente:</strong><br><br>
                        <input type="text" name="dni" required><br><br>
                        <strong>Legajo Medico:</strong><br><br>
                        <input type="number" name="Legajo" required><br><br>
                        <strong>Fecha:</strong>
                        <input type="date" name="fecha" required><br><br>
                        <strong>Hora:</strong>
                        <input type="time" name="hora" required><br><br>
                        <strong>Especialidad:</strong>
                        <select name="especialidad" required>
                            <c:forEach items="${especialidades }" var="especialidad">
                            	<option value="${especialidad.id }">${especialidad.nombre }</option>
                            </c:forEach>
                        </select><br><br>
                    </td>
                    <td>
                    	<strong>Activo</strong>
                   		<input type="radio" name="estado" value="activo" checked><br>
                    	<strong>Inactivo</strong>
                    	<input type="radio" name="estado" value="inactivo">
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