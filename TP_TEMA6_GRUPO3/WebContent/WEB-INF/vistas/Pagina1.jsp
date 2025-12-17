<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - Sistema Hospitalario</title>
    <link rel="icon" href="img/hospital.ico" type="image/x-icon">
    <style>
    body {
            background-color: #f0f8ff; /* Un azul muy claro, casi blanco */
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .login-container {
            background-color: #ffffff; /* Blanco */
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 320px;
            text-align: center;
        }

        .login-container .logo {
            width: 100px;
            margin-bottom: 20px;
        }

        .login-container h2 {
            color: #005a9c; /* Azul oscuro para el título */
            margin-bottom: 30px;
        }

        .login-container .input-group {
            margin-bottom: 20px;
            text-align: left;
        }

        .login-container label {
            display: block;
            color: #333333;
            margin-bottom: 5px;
        }

        .login-container input[type="text"],
        .login-container input[type="password"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #cccccc;
            border-radius: 4px;
            box-sizing: border-box; /* Asegura que el padding no afecte el ancho total */
        }

        .login-container .btn-login {
            width: 100%;
            padding: 12px;
            border: none;
            border-radius: 4px;
            background-color: #007bff; /* Azul primario */
            color: white;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .login-container .btn-login:hover {
            background-color: #0056b3; /* Azul más oscuro al pasar el mouse */
        }
    </style>
</head>
<body>

    <div class="login-container">
        <h2>Inicio de Sesión</h2>
        <form action="redireccionar_usuario.html" method="post">
            <div class="input-group">
                <label for="usuario">Usuario</label>
                <input type="text" id="usuario" name="usuario" required>
            </div>
            <div class="input-group">
                <label for="contrasena">Contraseña</label>
                <input type="password" id="contrasena" name="contrasena" required>
            </div>
            <button type="submit" class="btn-login">Ingresar</button>
        </form>
    </div>

</body>
</html>