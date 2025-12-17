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
	<c:set var="medico_m" value="${medicoSeleccionado}" />	
	<div class="admin-medicos-container">
    	<h3>Gestionar Médicos</h3>
        <form action="modif_medico.html" method="post" class="admin-medicos-form">
        <input type="hidden" value="${usuarioLogeado.Nombre_Usuario}" name="usuarioLogueado">
        	<table>
            	<thead>
                	<tr>
                    	<th>Datos</th>
                        <th>Vinculación</th>
                        <th>Estado</th>
                        <th>Acción</th>
                    </tr>
                 </thead>
                 <tbody>
                 	 <c:if test="${medico_m != null}">
                        <tr>
                            <td>
	                            <strong>Legajo: ${medico_m.legajo}</strong><br><br>
	                            <input type="hidden" name="legajo" value="${medico_m.legajo}">
	                            <strong>Nombre:</strong>
	                            <input type="text" name="nombre" value="${medico_m.nombre}"><br><br>
	                            <strong>Apellido:</strong>
	                            <input type="text" name="apellido" value="${medico_m.apellido}"><br><br>
	                            <strong>Sexo:</strong>
	                            <select name="Sexo" required>
	                                <option value="Masculino" ${medico_m.sexo == 'Masculino' ? 'selected' : ''}>Masculino</option>
	                                <option value="Femenino"  ${medico_m.sexo == 'Femenino' ? 'selected' : ''}>Femenino</option>
	                                <option value="Otro"       ${medico_m.sexo == 'Otro' ? 'selected' : ''}>Otro</option>
	                            </select><br><br>
	                            <strong>Dirección:</strong>
	                            <input type="text" name="direccion" value="${medico_m.direccion}"><br><br>
	                            <strong>Localidad:</strong>
	                            <input type="text" name="localidad" value="${medico_m.localidad}"><br><br>
	                            <strong>Fecha de Nacimiento:</strong>
	                            <input type="date" name="fechaNac" value="${medico_m.fechaNac}"><br><br>
	                            <strong>Correo electrónico:</strong>
	                            <input type="email" name="email" value="${medico_m.email}"><br><br>
	                            <strong>Días de trabajo:</strong>
	                            <input type="text" name="Dias" value="${medico_m.diasLab}"><br><br>
	                            <strong>Horarios de trabajo:</strong>
	                            <input type="text" name="horarios" value="${medico_m.horarioLab}"><br><br>
	                            <strong>Teléfono:</strong>
                            	<input type="tel" name="telefono" value="${medico_m.telefono}">
                            </td>
                            <td>
                                <strong>Usuario:</strong>
                            	<input type="text" name="user" value="${medico_m.usuario != null ? medico_m.usuario.nombre_Usuario : ''}"><br><br>
                            	<strong>Contraseña:</strong>
                            	<input type="password" name="password" 
                                   	value="${medico_m.usuario != null ? medico_m.usuario.contraseña : ''}"><br><br>

                            	<strong>Especialidad:</strong>
                            	<select name="especialidad">
                                <c:forEach items="${especialidades}" var="especialidad">
                                    <option value="${especialidad.id}" 
                                    ${medico_m.especialidad != null && medico_m.especialidad.id == especialidad.id ? 'selected' : ''}>
                                    ${especialidad.nombre}
                                    </option>
                                </c:forEach>
                            	</select><br><br>
                            </td>
                            <td>
                                <strong>Activo</strong>
                                <input type="radio" name="estado" value="activo" ${medico_m.estado ? 'checked' : ''}><br><br>
                                <strong>Inactivo</strong>
                                <input type="radio" name="estado" value="inactivo" ${!medico_m.estado ? 'checked' : ''}>
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