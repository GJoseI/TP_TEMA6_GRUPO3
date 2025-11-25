<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - Sistema Hospitalario</title>
    <link rel="icon" href="img/hospital.ico" type="image/x-icon">
    <link rel="stylesheet" href="./pagina1.css">
</head>
<body>

    <div class="login-container">
        <img src="hospital.png" class="logo">
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