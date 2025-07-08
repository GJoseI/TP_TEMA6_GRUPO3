<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Panel de Administrador - Turnos</title>
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
</style>
</head>
<body>
<div class="admin-container">
	<div class="welcome-header">
		<div class="info">
    		<h2>Bienvenido/a</h2>
    		<p>ID Admin</p>
    		<form method="get" >
           		<button type="submit" formaction="redireccionar_Admin.html" class="btn-guardar-fila">Vover a menu </button>
       		</form>
    	</div>
 	</div>
    <h2>Asignación de Turnos</h2>
        
    <form action="procesar_turnos.jsp" method="post" class="admin-turnos-form">
    	<table>
        	<thead>
            	<tr>
                	<th>Asignacion</th>
                    <th>Datos del Turno</th>
                </tr>
             </thead>
             <tbody>
             	<tr>
             		<td>
             			<strong>DNI Paciente:44867986</strong><br><br>
             			<%--<input type="text" name="dni" value="44867986"><br><br>--%>
             			<strong>Nombre Paciente:Maria perez</strong><br><br>
             			<%--<input type="text" name="dni" value="Juan perez"><br><br>--%>
             			<strong>Legajo Medico:24323</strong><br><br>
             			<%--<input type="text" name="dni" value="24323"><br><br>--%>
             			<strong>Nombre medico:Juan perez</strong><br><br>
             			<%--<input type="text" name="dni" value="Juan perez"><br><br>--%>
             		<%--</td>
             		<td>--%>
             			<strong>Fecha y hora:</strong>
             			<input type="datetime-local" name="fechaNac" value=""><br><br>
             			<strong>Especialidad:</strong>
             			<select name="especialidad">
             				<option>Cardiologia</option>
             				<option>rrvv</option>
             				<option>ggd</option>
             			</select>
             		</td>
             		<td>
             		<button type="submit" class="btn-guardar-fila" name="btnguardar">Guardar</button>
             		</td>
             	</tr>
        	 </tbody>
       	</table>
       	<br>
  	
<h2>Lista de Paciente</h2>
<strong>Bucar Paciente: </strong>
<input type="text" name="dni" placeholder="Ingrese DNI">
<button type="submit" class="btn-Buscar-fila" name="btnguardar">Filtrar</button><br><br>
    <table>
        <thead>
            <tr>
                <th>Dni</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Telefono</th>
                <th>Direccion</th>
                <th>Localidad</th>
                <th>Provincia</th>
                <th>Fecha de Nacimiento</th>
                <th>Correo electronico</th>
                
                <th>Estado</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
                <tr>
               		<td>4565655</td>
                    <td>jean</td>
                    <td>esquen</td>
                    <td>15232565</td>
                    <td>Tigre</td>
                    <td>don torcuato</td>
                    <td>bs as</td>
                    <td>10/02/2002</td>
                    <td>jeeisi@gmail</td>
                    <td>Activo</td>
                    <td><button type="submit" class="btn-guardar-fila" name="btnModificar">Selecionar</button></td>
                </tr>
                <tr>
               		<td>4565655</td>
                    <td>jean</td>
                    <td>esquen</td>
                    <td>15232565</td>
                    <td>Tigre</td>
                    <td>don torcuato</td>
                    <td>bs as</td>
                    <td>10/02/2002</td>
                    <td>jeeisi@gmail</td>
                    <td>Activo</td>
                    <td><button type="submit" class="btn-guardar-fila" name="btnModificar">Selecionar</button></td>
                </tr>
        </tbody>  
    </table>
    <br>
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
 
 <div class="container">
    <h2>Lista de Médicos</h2>
<strong>Especialidad:</strong>
<select name="especialidad">
	<option>Cardiologia</option>
	<option>rrvv</option>
	<option>ggd</option>
</select>
<button type="submit" class="btn-Buscar-fila" name="btnguardar">Filtrar</button><br><br>
    <table>
        <thead>
            <tr>
                <th>Dni</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Especialidad</th>
                <th>Sexo</th>
                <th>Correo electronico</th>
                <th>Dias de trabajo</th>
                <th>Telefono</th>
                <th>Estado</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
                <tr>
               		<td>4565655</td>
                    <td>jean</td>
                    <td>esquen</td>
                    <td>clinico</td>
                    <td>masculino</td>
                    <td>jeeisi@gmail</td>
                    <td>5</td>
                    <td>15232565</td>
                    <td>Activo</td>
                    <td><button type="submit" class="btn-guardar-fila" name="btnModificar">Selecionar</button></td>
                </tr>
                <tr>
               		<td>4565655</td>
                    <td>jean</td>
                    <td>esquen</td>
                    <td>clinico</td>
                    <td>masculino</td>
                    <td>jeeisi@gmail</td>
                    <td>5</td>
                    <td>15232565</td>
                    <td>Activo</td>
                    <td><button type="submit" class="btn-guardar-fila" name="btnModificar">Selecionar</button></td>
                </tr>
        </tbody>
    </table>
</div> 
<br>
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
 <br>
 </form>  
</div>
</body>
</html>