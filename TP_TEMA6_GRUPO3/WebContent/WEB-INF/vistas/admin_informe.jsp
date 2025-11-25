<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Informe de Actividad Hospitalaria</title>
	<link rel="stylesheet" href="./informe.css">
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

 	<br>  
 </div>    
 <div class="initial-message">
     <p>Por favor, seleccione un rango de fechas y haga clic en "Generar Informe" para ver los datos.</p>
      <form method="get" >
          <button type="submit" formaction="redireccionar_Admin.html" class="btn-generate">Vover a menu </button>
      </form>
 </div>

    </div>
</div>

</body>
</html>