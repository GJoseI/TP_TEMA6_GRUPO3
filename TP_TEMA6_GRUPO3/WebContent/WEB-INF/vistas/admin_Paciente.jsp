<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Panel de Administrador - Pacientes</title>
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
    		<p>ID Admin</p>
    		<form method="get" >
           		<button type="submit" formaction="redireccionar_Admin.html" class="btn-guardar-fila">Vover a menu </button>
       		</form>
    	</div>
    </div>
<div class="admin-pacientes-container">
    <h3>Gestionar Pacientes</h3>
        
    <form action="" method="post" class="admin-pacientes-form">
    	<table>
        	<thead>
            	<tr>
                	<th>Datos</th>
                    <th>Estado</th>
                </tr>
             </thead>
             <tbody>
             	<tr>
             		<td>
             			<strong>DNI:</strong>
             			<input type="text" name="dni" value="44867986"><br><br>
             			<strong>Nombre:</strong>
             			<input type="text" name="nombre" value="Juan"><br><br>
             			<strong>Apellido:</strong>
             			<input type="text" name="apellido" value="Perez"><br><br>
             			<strong>Telefono:</strong>
             			<input type="text" name="telefono" value="112471242"><br><br>
             			<strong>Direccion:</strong>
             			<input type="text" name="direccion" value="Calle 1"><br><br>
             			<strong>Localidad:</strong>
             			<input type="text" name="localidad" value="La matanza"><br><br>
             			<strong>Provincia:</strong>
             			<input type="text" name="provincia" value="BsAs"><br><br>
             			<strong>Fecha de Nacimiento:</strong>
             			<input type="datetime-local" name="fechaNac" value=""><br><br>
             			<strong>Correo electronico:</strong>
             			<input type="text" name="email" value="juan.perez@gmail.com">
             		</td>	
             		<td>
						<strong>Activo</strong>
						<input type="radio" name="estado" value="activo"><br>
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
<h3>Lista de Paciente</h3>
<strong>DNI:</strong>
<input type="text" name="dni" placeholder="Ingrese DNI">
<button type="submit" class="btn-Buscar-fila" name="btnBuscar">Filtrar</button>
<br>
 <form action="" method="post" class="admin-pacientes-form">
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
                    <td><button type="submit" class="btn-guardar-fila" name="btnModificar">Modificar</button></td>
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
                    <td><button type="submit" class="btn-guardar-fila" name="btnModificar">Modificar</button></td>
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
                    <td><button type="submit" class="btn-guardar-fila" name="btnModificar">Modificar</button></td>
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
                    <td><button type="submit" class="btn-guardar-fila" name="btnModificar">Modificar</button></td>
                </tr>
    </table>
  </form>
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
</div> 
</div> 
</body>
</html>