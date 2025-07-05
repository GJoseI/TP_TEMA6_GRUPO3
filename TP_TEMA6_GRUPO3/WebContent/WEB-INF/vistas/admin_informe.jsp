<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<title>Informe de Actividad Hospitalaria</title>
<style>
    body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 20px; }
    .container { max-width: 900px; margin: auto; background: white; padding: 25px; border-radius: 8px; box-shadow: 0 2px 5px rgba(0,0,0,0.1); }
    
   
    table { width: 100%; border-collapse: collapse; }
    th, td { padding: 15px; border: 1px solid #ddd; text-align: left; }
    thead tr { background-color: #007bff; color: white; }
    tbody tr:nth-child(even) { background-color: #f2f2f2; }
    tbody tr:hover { background-color: #e9ecef; }
    
    /* Sección de Filtros */
    .filter-section { background-color: #f9f9f9; padding: 20px; border: 1px solid #ddd; border-radius: 8px; margin-bottom: 25px; }
    .filter-section h2 { margin-top: 0; color: #333; }
    .filter-form { display: flex; align-items: flex-end; gap: 20px; }
    .form-group { display: flex; flex-direction: column; }
    .form-group label { margin-bottom: 5px; font-weight: bold; color: #555; }
    .form-group input[type="date"] { padding: 8px; border: 1px solid #ccc; border-radius: 4px; font-size: 16px; }
    .btn-generate { padding: 10px 20px; font-size: 16px; color: white; background-color: #007bff; border: none; border-radius: 4px; cursor: pointer; }
    .btn-generate:hover { background-color: #0056b3; }

    /* Sección del Informe */
    .report-section h3 { border-bottom: 2px solid #007bff; padding-bottom: 10px; color: #005a9c; }
    .report-grid { display: grid; grid-template-columns: repeat(auto-fit, minmax(200px, 1fr)); gap: 20px; }
    .stat-card { background: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.08); text-align: center; }
    .stat-card .stat-value { font-size: 2.5em; font-weight: bold; color: #005a9c; margin: 0; }
    .stat-card .stat-label { font-size: 1em; color: #666; margin: 5px 0 0 0; }
    .initial-message { text-align: center; color: #888; padding: 40px; background: #fdfdfd; border: 1px dashed #ccc; border-radius: 8px; }
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
<div class="container">
    <h1>Informe de Actividad</h1>

    <div class="filter-section">
        <h2>Filtros del Informe</h2>
        <form action="informe.jsp" method="get" class="filter-form">
            <div class="form-group">
                <label for="fecha_inicio">Fecha de Inicio:</label>
                <input type="date" id="fecha_inicio" name="fecha_inicio" value="" required>
            </div>
            <div class="form-group">
                <label for="fecha_fin">Fecha de Fin:</label>
                <input type="date" id="fecha_fin" name="fecha_fin" value="" required>
            </div>
            <button type="submit" class="btn-generate">Generar Informe</button>
        </form>
    </div>

    <div class="report-section">
            <h3>Resultados de turnos</h3>
            <div class="report-grid">
                <div class="stat-card">
                    <p class="stat-value">24</p>
                    <p class="stat-label">Total de Turnos Agendados</p>
                </div>
                <div class="stat-card">
                    <p class="stat-value">12</p>
                    <p class="stat-label">Pacientes Atendidos</p>
                </div>
                <div class="stat-card">
                    <p class="stat-value">12</p>
                    <p class="stat-label">Ausencias Registradas</p>
                </div>
                <div class="stat-card">
                    <p class="stat-value">28</p>
                    <p class="stat-label">Tasa de Asistencia</p>
                </div>
            </div>
    <div class="report-section">
            <h3>Resultados de especialidades</h3>
            <div class="report-grid">
                <div class="stat-card">
                    <p class="stat-value">24</p>
                    <p class="stat-label">cardiología</p>
                </div>
                <div class="stat-card">
                    <p class="stat-value">12</p>
                    <p class="stat-label">pediatría</p>
                </div>
                <div class="stat-card">
                    <p class="stat-value">12</p>
                    <p class="stat-label">Urología</p>
                </div>
                <div class="stat-card">
                    <p class="stat-value">28</p>
                    <p class="stat-label">clinico</p>
                </div>
                <div class="stat-card">
                    <p class="stat-value">28</p>
                    <p class="stat-label">Patología</p>
                </div>
                <div class="stat-card">
                    <p class="stat-value">28</p>
                    <p class="stat-label">Neonatología</p>
                </div>
            </div>
<div class="container">
    <h3>Resultados de Médicos</h3>

    <table>
        <thead>
            <tr>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>pediatría</th>
                <th>Sexo</th>
                <th>Email</th>
                <th>Usuario</th>
                <th>Horas Trabajadas (mensual)</th>
            </tr>
        </thead>
        <tbody>
                <tr>
                    <td>jean</td>
                    <td>esquen</td>
                    <td>clinico</td>
                    <td>masculino</td>
                    <td>jehajdjdj@gmail.com</td>
                    <td>jp_User</td>
                    <td>24</td>
                </tr>
                <tr>
                    <td>jean</td>
                    <td>esquen</td>
                    <td>Cardiología </td>
                    <td>masculino</td>
                    <td>jehajdjdj@gmail.com</td>
                    <td>jp_User</td>
                    <td>24</td>
                </tr>
                <tr>
                    <td>jean</td>
                    <td>esquen</td>
                    <td>Urología  </td>
                    <td>masculino</td>
                    <td>jehajdjdj@gmail.com</td>
                    <td>jp_User</td>
                    <td>24</td>
                </tr>
                <tr>
                    <td>jean</td>
                    <td>esquen</td>
                    <td>Patología  </td>
                    <td>masculino</td>
                    <td>jehajdjdj@gmail.com</td>
                    <td>jp_User</td>
                    <td>24</td>
                </tr>
                <tr>
                    <td>jean</td>
                    <td>esquen</td>
                    <td>Neonatología </td>
                    <td>masculino</td>
                    <td>jehajdjdj@gmail.com</td>
                    <td>jp_User</td>
                    <td>24</td>
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
 <div class="initial-message">
     <p>Por favor, seleccione un rango de fechas y haga clic en "Generar Informe" para ver los datos.</p>
 </div>

    </div>
</div>

</body>
</html>