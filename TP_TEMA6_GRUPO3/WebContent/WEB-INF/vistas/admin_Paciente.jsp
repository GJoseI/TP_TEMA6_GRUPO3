<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Panel de Administrador - Pacientes</title>
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
	.admin-pacientes-container { background-color: #ffffff; padding: 25px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); max-width: 1500px; margin: auto; }
	.welcome-header { display: flex; align-items: center; margin-bottom: 25px; border-bottom: 2px solid #e0e0e0; padding-bottom: 15px; }
    .welcome-header .info h2 { color: #005a9c; margin: 0; font-size: 22px; }
    .welcome-header .info p { margin: 0; color: #555; }
    .admin-pacientes-form table { width: 100%; border-collapse: collapse; margin-top: 20px; }
    .admin-pacientes-form th, .turnos-form td { border: 1px solid #ddd; padding: 12px; text-align: left; vertical-align: top; }
    .admin-pacientes-form th { background-color: #007bff; color: white; }
    .admin-pacientes-form td ul { margin: 0; padding-left: 20px; }
    .admin-pacientes-form textarea { width: 95%; height: 60px; margin-top: 5px; border: 1px solid #ccc; border-radius: 4px; padding: 5px; }
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

<div class="admin-pacientes-container">
    <div class="welcome-header">
        <div class="info">
            <h2>Bienvenido/a</h2>
            <p>${usuarioLogeado}</p>
            <form method="get">
                <button type="submit" formaction="redireccionar_Admin.html" class="btn-guardar-fila">Volver a menú</button>
                <input type="hidden" value="${usuarioLogeado.Nombre_Usuario}" name="usuarioLogueado">
            </form>
        </div>
    </div>
    
    <c:if test="${not empty mensajeError}">
			<div class="error">${mensajeError}</div>
		</c:if>
		
		<c:if test="${not empty mensajeExito}">
			<div class="exito">${mensajeExito}</div>
		</c:if>
        
    <div class="admin-pacientes-container">
        <h3>Gestionar Pacientes</h3>
        
        <form action="alta_paciente.html" method="post" class="admin-pacientes-form">
            <table>
                <thead>
                    <tr>
                        <th>Datos</th>
                        <th>Estado</th>
                        <th>Acción</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <strong>DNI:</strong>
                            <input type="text" name="dni" value="" required><br><br>
                            <strong>Nombre:</strong>
                            <input type="text" name="nombre" value="" required><br><br>
                            <strong>Apellido:</strong>
                            <input type="text" name="apellido" value="" required><br><br>
                            <strong>Teléfono:</strong>
                            <input type="text" name="telefono" value=""><br><br>
                            <strong>Dirección:</strong>
                            <input type="text" name="direccion" value=""><br><br>
                            <strong>Localidad:</strong>
                            <input type="text" name="localidad" value=""><br><br>
                            <strong>Provincia:</strong>
                            <input type="text" name="provincia" value=""><br><br>
                            <strong>Fecha de Nacimiento:</strong>
                            <input type="date" name="fecha_nacimiento" value="" required><br><br>
                            <strong>Correo electrónico:</strong>
                            <input type="email" name="email" value="" required>
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
        </form> 
    </div>   
    
    <br> 
    
    <div class="admin-pacientes-container">    
        <h3>Lista de Pacientes</h3>
        <form action="redireccionar_modificarPac_admin.html" method="post" class="admin-pacientes-form">
            <table id="tabla" class="display">
                <thead>
                    <tr>
                        <th>DNI</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Teléfono</th>
                        <th>Dirección</th>
                        <th>Localidad</th>
                        <th>Provincia</th>
                        <th>Fecha Nac.</th>
                        <th>Email</th>
                        <th>Estado</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
            		<c:forEach items="${ListaPaciente}" var="p">
		                <tr>
		                    <td>${p.DNI}</td>
		                    <td>${p.nombre}</td>
		                    <td>${p.apellido}</td>
		                    <td>${p.telefono}</td>
		                    <td>${p.direccion}</td>
		                    <td>${p.localidad}</td>
		                    <td>${p.provincia}</td>
		                    <td>${p.fecha_nacimiento}</td>
		                    <td>${p.correo_electronico}</td>
		                    <td>
		                        <c:choose>
		                            <c:when test="${p.estado}">Activo</c:when>
		                            <c:otherwise>Inactivo</c:otherwise>
		                        </c:choose>
		                    </td>
		                    <td>
		                        <button type="submit" class="btn-guardar-fila" name="btnModificar" value="${p.DNI}">Modificar</button>
		                    </td>
		                </tr>
            		</c:forEach>
        		</tbody>
            </table>
        </form> 
    </div> 
</div> 
</body>
</html>