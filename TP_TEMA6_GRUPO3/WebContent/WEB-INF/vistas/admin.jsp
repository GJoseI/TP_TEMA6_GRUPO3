<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>Administrador</title>
    <link rel="icon" href="../img/administrado.ico" type="image/x-icon">
    <link rel="stylesheet" href="./admin.css">
</head>
<body>

    <div class="admin-container">
        <div class="welcome-header">
            <img src="img/user_icon.png" alt="Logo de Usuario" class="user-icon">
            <h2>Bienvenido ${usuarioLogueado.nombre_Usuario}</h2>
        </div>

        <p style="color: #555;">Seleccione una opción:</p>

        <form class="nav-form" method="get" >
            <button type="submit" formaction="redireccionar_adminPaciente.html" class="nav-button">
                Gestionar Pacientes
            </button>
            <button type="submit" formaction="redireccionar_adminMedico.html" class="nav-button">
                Gestionar Medicos
            </button>
            <button type="submit" formaction="redireccionar_adminTurnos.html" class="nav-button">
                Asignación de Turnos
            </button>
            <button type="submit" formaction="redireccionar_adminInforme.html" class="nav-button">
                Ver Informes
            </button>
            <button type="submit" formaction="redireccionar_pag1.html" class="nav-button">
                Salir
            </button>
        </form>
    </div>

</body>
</html>