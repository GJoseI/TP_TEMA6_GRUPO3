<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Paciente</title>
<style>
	body { background-color: #f0f8ff; font-family: Arial, sans-serif; margin: 20px; }
	.admin-pacientes-container { background-color: #ffffff; padding: 25px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); max-width: 1200px; margin: auto; }
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
</style>
</head>
<body>
<div class="admin-pacientes-container">
		<div class="welcome-header">
	        <div class="info">
	            <form method="get" action="redireccionar_adminPaciente.html">
	                <button type="submit" class="btn-guardar-fila">Volver a menú</button>
	                <input type="hidden" value="${usuarioLogueado}" name="usuarioLogueado">
	            </form>
	        </div>
	    </div>
        <h3>Gestionar Pacientes</h3>    
        <form action="modif_paciente.html" method="post" class="admin-pacientes-form">
        <input type="hidden" value="${usuarioLogueado}" name="usuarioLogueado">
            <table>
                <thead>
                    <tr>
                        <th>Datos</th>
                        <th>Estado</th>
                        <th>Acción</th>
                    </tr>
                </thead>
                <tbody>
			    <c:if test="${not empty paciente_p}">
			        <tr>
			            <td>
			                <strong>DNI:</strong>
			                <input type="text" name="dni" value="${paciente_p.DNI}"><br><br>		
			                <strong>Nombre:</strong>
			                <input type="text" name="nombre" value="${paciente_p.nombre}"><br><br>		
			                <strong>Apellido:</strong>
			                <input type="text" name="apellido" value="${paciente_p.apellido}"><br><br>		
			                <strong>Teléfono:</strong>
			                <input type="text" name="telefono" value="${paciente_p.telefono}"><br><br>		
			                <strong>Dirección:</strong>
			                <input type="text" name="direccion" value="${paciente_p.direccion}"><br><br>		
			                <strong>Localidad:</strong>
			                <input type="text" name="localidad" value="${paciente_p.localidad}"><br><br>
			                <strong>Provincia:</strong>
			                <input type="text" name="provincia" value="${paciente_p.provincia}"><br><br>	
			                <strong>Fecha de Nacimiento:</strong>
			                <input type="text" name="fecha_nacimiento" value="${paciente_p.fecha_nacimiento}"><br><br>
			                <strong>Correo electrónico:</strong>
			                <input type="email" name="email" value="${paciente_p.correo_electronico}">
			            </td>
			            <td>
			                <button type="submit" class="btn-guardar-fila" name="btneliminar">Eliminar</button>
			            </td>
			            <td>
			                <button type="submit" class="btn-guardar-fila" name="btnguardar_Modificar">Guardar</button>
			            </td>
			        </tr>
			    </c:if>
				</tbody>
            </table>
        </form> 
    </div>   
</body>
</html>