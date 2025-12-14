<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>Informe de Actividad Hospitalaria</title>
	<style>
		body{ 
			font-family: Arial, sans-serif; 
			background-color: #f4f4f4; 
			margin: 0; 
			padding: 20px; 
		}
		
		.list-choice {
		    width: 300px;
		    margin: 1em auto;
		    position: relative;
		    cursor: pointer;
		}
		
		.list-choice input[type="radio"] {
		    position: absolute;
		    left: -9999px;
		}
		
		.list-choice-title {
		    width: 100%;
		    display: block;
		    background: #218838;
		    text-align: center;
		    padding: 0.55em 1em;
		    box-sizing: border-box;
		    color: #FFF;
		    text-shadow: 0 1px 0 #CACACA;
		    border-radius: 0.2em;
		}
		
		.list-choice:hover .list-choice-title {
		    border-radius: 0.2em 0.2em 0 0;
		}
		
		.list-choice-objects label:nth-last-of-type(1) span {
		    border-radius: 0 0 0.2em 0.2em;
		}
		
		.list-choice input[type="radio"]+span {
		    color: #FFF;
		    background: #218838;
		    padding: 0.55em 1em;
		    display: block;
		    text-align: center;
		    box-sizing: border-box;
		    cursor: pointer;
		    width: 100%;
		}
		
		.list-choice-objects {
		    position: absolute;
		    top: 0;
		    padding-top: 2.1em;
		    box-sizing: border-box;
		    width: 100%;
		    overflow: hidden;
		    max-height: 0;
		    transition: all 250ms ease;
		}
		
		.list-choice:hover .list-choice-objects input[type="radio"]+span {
		    position: relative;
		    top: 0;
		    transition: all 250ms ease-in-out;
		}
		
		.list-choice:hover input[type="radio"]+span:hover {
		    background: #1d6b2e;
		}
		
		.list-choice:hover input[type="radio"]:checked+span:hover {
		    background: #2bb749;
		}
		
		.list-choice input[type="radio"]:checked+span {
		    background: #2bb749;
		    position: absolute;
		    top: 0em;
		    border-radius: 0.2em;
		}
		
		.list-choice:hover input[type="radio"]:checked+span {
		    border-radius: 0;
		}
		
		.list-choice:hover .list-choice-objects label:nth-last-of-type(1) input[type="radio"]:checked+span {
		    border-radius: 0 0 0.2em 0.2em;
		}
		
		.list-choice:hover .list-choice-objects {
		    max-height: 540px;
		}
		
	    .container { 
		    max-width: 900px; 
		    margin: auto; 
		    background: white; 
		    padding: 25px; 
		    border-radius: 8px; 
		    box-shadow: 0 2px 5px rgba(0,0,0,0.1); 
	    }   
	     
	    /* Sección del Informe */
	    .report-section h3 { 
		    border-bottom: 2px solid #007bff; 
		    padding-bottom: 10px; 
		    color: #005a9c; 
	    }
	    
	    .report-grid {
	    	display: flex;
	    	flex-wrap: wrap;
	    	gap: 1rem;
	    }
	    
	    .stat-card {
	    	box-sizing: border-box;
	    	text-align: center; 
	    	flex: 0 0 calc(25% - 0.75rem);  
	    }
	    
	    .stat-card .stat-value { 
		    font-size: 2.5em; 
		    font-weight: bold; 
		    color: #005a9c; 
		    margin: 0; 
	    }
	    
	    .stat-card .stat-label { 
		    font-size: 1em; 
		    color: #666; 
		    margin: 5px 0 0 0; 
	    }
	    
	    .initial-message { 
		    text-align: center; 
		    color: #888;
		    padding: 5px; 
		    background: #fdfdfd; 
		    border-radius: 8px; 
	    }
	     
	    .btn-generate { 
		    width: 50%; 
		    padding: 10px;
			margin-top: 10px; 
			border: none; 
			border-radius: 4px; 
			background-color: #28a745; 
			color: white; 
			font-size: 16px; 
			cursor: pointer; 
		}
		
    	.btn-generate:hover { 
    		background-color: #218838; 
    	}
	</style>
</head>
<body>
	<section class="container">
		<h1>Informe de Actividad</h1>
		<div class="report-section">
			<h3>Resultado de turnos</h3>
			<form method="get" action="filtroMes_Informe.html">
				<div class="list-choice">
	             <div class="list-choice-title">Mes</div>
	             <div class="list-choice-objects">
	              <label>
	                <input type="radio" name="mes" value="1" onchange="this.form.submit()" ${param.mes == '1' ? 'checked' : ''} /> <span>Enero</span>
	              </label>
	              <label>
	                <input type="radio" name="mes" value="2" onchange="this.form.submit()" ${param.mes == '2' ? 'checked' : ''} /> <span>Febrero</span>
	              </label>
	              <label>
	                <input type="radio" name="mes" value="3" onchange="this.form.submit()" ${param.mes == '3' ? 'checked' : ''} /> <span>Marzo</span>
	              </label>
	              <label>
	                <input type="radio" name="mes" value="4" onchange="this.form.submit()" ${param.mes == '4' ? 'checked' : ''}/> <span>Abril</span>
	              </label>
	              <label>
	                <input type="radio" name="mes" value="5" onchange="this.form.submit()" ${param.mes == '5' ? 'checked' : ''}/> <span>Mayo</span>
	              </label>
	              <label>
	                <input type="radio" name="mes" value="6" onchange="this.form.submit()" ${param.mes == '6' ? 'checked' : ''}/> <span>Junio</span>
	              </label>
	              <label>
	                <input type="radio" name="mes" value="7" onchange="this.form.submit()" ${param.mes == '7' ? 'checked' : ''}/> <span>Julio</span>
	              </label>
	              <label>
	                <input type="radio" name="mes" value="8" onchange="this.form.submit()" ${param.mes == '8' ? 'checked' : ''}/> <span>Agosto</span>
	              </label>
	              <label>
	                <input type="radio" name="mes" value="9" onchange="this.form.submit()" ${param.mes == '9' ? 'checked' : ''}/> <span>Septiembre</span>
	              </label>
	              <label>
	                <input type="radio" name="mes" value="10" onchange="this.form.submit()" ${param.mes == '10' ? 'checked' : ''}/> <span>Octubre</span>
	              </label>
	              <label>
	                <input type="radio" name="mes" value="11" onchange="this.form.submit()" ${param.mes == '11' ? 'checked' : ''}/> <span>Noviembre</span>
	              </label>
	              <label>
	                <input type="radio" name="mes" value="12" onchange="this.form.submit()" ${param.mes == '12' ? 'checked' : ''}/> <span>Diciembre</span>
	              </label>
	              <label>
	                <input type="radio" name="mes" value="0" onchange="this.form.submit()" ${param.mes == '0' ? 'checked' : ''}/> <span>Total</span>
	              </label>
	             </div>
	          	</div>
			<div class="report-grid">
				<div class="stat-card">
					<p class="stat-value">${totalTurnos}</p>
					<p class="stat-label">Total de Turnos Agendados</p>
				</div>
				<div class="stat-card">
					<p class="stat-value">${pacientesAtendidos}</p>
					<p class="stat-label">Pacientes Atendidos</p>
				</div>
				<div class="stat-card">
					<p class="stat-value">${ausencias}</p>
					<p class="stat-label">Ausencias Registradas</p>
				</div>
				<div class="stat-card">
					<p class="stat-value">${porcentajeAsistencias}%</p>
					<p class="stat-label">Tasa de Asistencia</p>
				</div>
			</div>
			</form>
		</div>
		<div class="initial-message">
	        <form method="get">
	          <button type="submit" formaction="redireccionar_Admin.html" class="btn-generate">Vover a menu</button>
	        </form>
      	</div>
	</section>
</body>
</html>