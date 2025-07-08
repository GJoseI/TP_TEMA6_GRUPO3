<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin_medico</title>
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
<div class="admin-medicos-container">
	<div class="welcome-header">
		<div class="info">
    		<h2>Bienvenido/a</h2>
    		<p>ID Admin</p>
   		<form method="get" >
           <button type="submit" formaction="redireccionar_Admin.html" class="btn-guardar-fila">Vover a menu </button>
        </form>
    	</div>
    </div>
 <div class="admin-medicos-container">
    <h3>Gestionar Medicos</h3>
        
    <form action="" method="post" class="admin-medicos-form">
    	<table>
        	<thead>
            	<tr>
                	<th>Datos</th>
                	<th>Vinculacion</th>
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
             			<strong>Sexo:</strong>
             			<input type="text" name="telefono" value="Masculino"><br><br>
             			<strong>Direccion:</strong>
             			<input type="text" name="direccion" value="Calle 1"><br><br>
             			<strong>Localidad:</strong>
             			<input type="text" name="localidad" value="La matanza"><br><br>
             			<strong>Fecha de Nacimiento:</strong>
             			<input type="datetime-local" name="fechaNac" value=""><br><br>
             			<strong>Correo electronico:</strong>
             			<input type="text" name="email" value="juan.perez@gmail.com"><br><br>
             			<strong>Dias de trabajo:</strong>
             			<input type="text" name="email" value="Lun-Vie"><br><br>
             			<strong>Horarios de trabajo:</strong>
             			<input type="text" name="email" value="9AM-5PM"><br><br>
             			<strong>Telefono:</strong>
             			<input type="text" name="email" value="112471242">
             		</td>
             		<td>
             			<Strong>Especialidad:</Strong>
             			<select name="especialidad">
             				<option>Cardiologia</option>
             			</select><br><br>
             			<strong>Usuario:</strong>
             			<select name="nombreUsuario">
             				<option>Juanpe</option>
             			</select>
             		</td>
             		<td>
						<strong>Activo</strong>
						<input type="radio" name="estado" value="activo"><br><br>
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
   <br>
 </div>
 <br>
 <div class="admin-medicos-container">
    <div class="admin-medicos-form">
    
    <h3>Lista de Médicos</h3>
 

<form action="" method="post" class="admin-medicos-form">

<strong>Legajo:</strong>
<input type="text" name="dni" placeholder="Ingrese legajo">
<strong>Especialidad:</strong>
<select name="especialidad">
	<option>Cardiologia</option>
	<option>clinica</option>
</select>
<button type="submit" class="btn-Buscar-fila" name="btnBuscar">Filtrar</button>

    <table>
        <thead>
            <tr>
                <th>Dni</th>
                <th>Usuario</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Especialidad</th>
                <th>Sexo</th>
                <th>Direccion</th>
                <th>Localidad</th>
                <th>Fecha de Nacimiento</th>
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
               		<td>jean5011</td>
                    <td>jean</td>
                    <td>esquen</td>
                    <td>clinico</td>
                    <td>masculino</td>
                    <td>Tigre</td>
                    <td>don torcuato</td>
                    <td>10/02/2002</td>
                    <td>jeeisi@gmail</td>
                    <td>5</td>
                    <td>15232565</td>
                    <td>Activo</td>
                    <td><button type="submit" class="btn-guardar-fila" name="btnModificar">Modificar</button></td>
                </tr>
                <tr>
               		<td>4565655</td>
               		<td>jean5011</td>
                    <td>jean</td>
                    <td>esquen</td>
                    <td>clinico</td>
                    <td>masculino</td>
                    <td>Tigre</td>
                    <td>don torcuato</td>
                    <td>10/02/2002</td>
                    <td>jeeisi@gmail</td>
                    <td>5</td>
                    <td>15232565</td>
                    <td>Activo</td>
                    <td><button type="submit" class="btn-guardar-fila" name="btnModificar">Modificar</button></td>
                </tr>
                <tr>
               		<td>4565655</td>
               		<td>jean5011</td>
                    <td>jean</td>
                    <td>esquen</td>
                    <td>clinico</td>
                    <td>masculino</td>
                    <td>Tigre</td>
                    <td>don torcuato</td>
                    <td>10/02/2002</td>
                    <td>jeeisi@gmail</td>
                    <td>5</td>
                    <td>15232565</td>
                    <td>Activo</td>
                    <td><button type="submit" class="btn-guardar-fila" name="btnModificar">Modificar</button></td>
                </tr>
                <tr>
               		<td>4565655</td>
               		<td>jean5011</td>
                    <td>jean</td>
                    <td>esquen</td>
                    <td>clinico</td>
                    <td>masculino</td>
                    <td>Tigre</td>
                    <td>don torcuato</td>
                    <td>10/02/2002</td>
                    <td>jeeisi@gmail</td>
                    <td>5</td>
                    <td>15232565</td>
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
 <br>   

</div> 
    
</div>
</div>
</body>
</html>