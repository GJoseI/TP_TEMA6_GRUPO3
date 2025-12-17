<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>Administrador</title>
    <link rel="icon" href="../img/administrado.ico" type="image/x-icon">
    <style>
    	body {
            background-color: #f0f8ff; /* Azul muy claro, como en el login */
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .admin-container {
            background-color: #ffffff; /* Blanco */
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 450px;
            text-align: center;
        }

        .welcome-header {
            display: flex;
            align-items: center;
            justify-content: center;
            margin-bottom: 30px;
            border-bottom: 2px solid #e0e0e0;
            padding-bottom: 20px;
        }

        .welcome-header .user-icon {
            width: 60px;
            height: 60px;
            border-radius: 50%; /* Para que la imagen sea redonda */
            margin-right: 15px;
        }

        .welcome-header h2 {
            color: #005a9c; /* Azul oscuro */
            margin: 0;
            font-size: 24px;
        }
        
        .nav-form .nav-button {
            width: 100%;
            padding: 15px;
            margin-top: 15px;
            border: none;
            border-radius: 5px;
            background-color: #007bff; /* Azul primario */
            color: white;
            font-size: 18px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .nav-form .nav-button:hover {
            background-color: #0056b3; /* Azul más oscuro al pasar el mouse */
        }
    </style>
</head>
<body>

    <div class="admin-container">
        <div class="welcome-header">
            <img src="img/user_icon.png" alt="Logo de Usuario" class="user-icon">
            <h2>Bienvenido ${usuarioLogueado.Nombre_Usuario}</h2>
            <input type="hidden" value="${usuarioLogeado.Nombre_Usuario}" name="usuarioLogueado">
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