<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - Sistema Hospitalario</title>
    <style>
    body {
            background-color: #f0f8ff; 
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .login-container {
            background-color: #ffffff;
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
            color: #005a9c; 
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
            box-sizing: border-box; 
        }

        .login-container .btn-login {
            width: 100%;
            padding: 12px;
            border: none;
            border-radius: 4px;
            background-color: #007bff; 
            color: white;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .login-container .btn-login:hover {
            background-color: #0056b3;
        }
        .alert {
		    padding: 10px;
		    margin: 10px 0;
		    border-radius: 4px;
		}

		.alert-error {
		    background-color: #ffdddd;
		    border-left: 5px solid #f44336;
		    color: #d8000c;
		}
		
		.alert-success {
		    background-color: #ddffdd;
		    border-left: 5px solid #4CAF50;
		    color: #4F8A10;
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
            <button type="submit" class="btn-login">Ingresar</button><br>
            <c:if test="${not empty mensajeError}">
				<div class="alert-error">${mensajeError}</div>
			</c:if>
        </form>
    </div>

</body>
</html>