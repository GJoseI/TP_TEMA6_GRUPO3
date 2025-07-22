<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page 
import="frgp.utn.edu.entidad.Medicos, java.util.List, java.text.SimpleDateFormat, java.text.ParseException, java.util.Date, java.time.LocalDate ,NegocioImp.MedicosNegocio, NegocioImp.UsuarioNegocio,NegocioImp.EspecialidadNegocio,frgp.utn.edu.entidad.Usuario,frgp.utn.edu.entidad.Especialidad"
%>
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
                <form method="get">
                    <button type="submit" formaction="redireccionar_Admin.html" class="btn-guardar-fila">Volver a menú</button>
                </form>
            </div>
        </div>
        
        <%
        EspecialidadNegocio epn = new EspecialidadNegocio();
        List<Especialidad> especialidades = epn.ReadAll();
        
        MedicosNegocio medNeg = new MedicosNegocio();
        Medicos medico_m = null;
        Usuario user = null;
        
        if (request.getParameter("btnguardar") != null) {
            try {
                int legajo = Integer.parseInt(request.getParameter("legajo"));
                
                if(!medNeg.Exist(legajo)) {
                    user = new Usuario(request.getParameter("user"), request.getParameter("password"), false);
                    
                    UsuarioNegocio negUser = new UsuarioNegocio();
                    negUser.AgregarUsuario(user);
                    
                    Medicos m = new Medicos();
                    m.setUsuario(user);
                    m.setEspecialidad(epn.ReadOne(Integer.parseInt(request.getParameter("especialidad"))));
                    
                    m.setLegajo(legajo);
                    m.setNombre(request.getParameter("nombre")); 
                    m.setApellido(request.getParameter("apellido"));
                    m.setDireccion(request.getParameter("direccion"));
                    m.setSexo(request.getParameter("Sexo"));
                    m.setLocalidad(request.getParameter("localidad"));
                    try {
                        String fechaNacStr = request.getParameter("fechaNac");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date fechaNac = sdf.parse(fechaNacStr);
                        m.setFechaNac(fechaNac);
                    } catch (ParseException e) {
                        e.printStackTrace();
                        // Podés redirigir a una página de error, o setear una fecha por defecto
                    }
                    //m.setFechaNac(request.getParameter("fechaNac"));
                    m.setEmail(request.getParameter("email"));
                    m.setDiasLab(request.getParameter("Dias"));
                    m.setHorarioLab(request.getParameter("horarios"));
                    m.setTelefono(request.getParameter("telefono"));
                    m.setEstado("activo".equals(request.getParameter("estado")));
                    
                    if(medNeg.AgregarMedicos(m)) {
                        request.setAttribute("mensajeExito", "Médico registrado correctamente");
                    } else {
                        request.setAttribute("mensajeError", "Error al registrar el médico");
                    }
                } else {
                    request.setAttribute("mensajeError", "El legajo ya existe");
                }
            } catch (NumberFormatException e) {
                request.setAttribute("mensajeError", "Legajo inválido");
            } catch (Exception e) {
                request.setAttribute("mensajeError", "Error en el sistema: " + e.getMessage());
            }
        }
        
        if (request.getParameter("btnModificar") != null) {
            medico_m = medNeg.ReadOne(Integer.parseInt(request.getParameter("btnModificar")));
        }
        
        if (request.getParameter("btnguardar_Modificar") != null && medico_m != null) {
            try {
                medico_m.setEspecialidad(epn.ReadOne(Integer.parseInt(request.getParameter("especialidad"))));
                medico_m.setNombre(request.getParameter("nombre")); 
                medico_m.setApellido(request.getParameter("apellido"));
                medico_m.setDireccion(request.getParameter("direccion"));
                medico_m.setSexo(request.getParameter("Sexo"));
                medico_m.setLocalidad(request.getParameter("localidad"));
                try {
                    String fechaNacStr = request.getParameter("fechaNac");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date fechaNac = sdf.parse(fechaNacStr);
                    medico_m.setFechaNac(fechaNac);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                //medico_m.setFechaNac(request.getParameter("fechaNac")); 
                medico_m.setEmail(request.getParameter("email"));
                medico_m.setDiasLab(request.getParameter("Dias"));
                medico_m.setHorarioLab(request.getParameter("horarios"));
                medico_m.setTelefono(request.getParameter("telefono"));
                medico_m.setEstado("activo".equals(request.getParameter("estado")));
                
                if(medNeg.Update(medico_m)) {
                    request.setAttribute("mensajeExito", "Médico modificado correctamente");
                } else {
                    request.setAttribute("mensajeError", "Error al modificar el médico");
                }
            } catch (Exception e) {
                request.setAttribute("mensajeError", "Error en el sistema: " + e.getMessage());
            }
        }
        
        if (request.getParameter("btnbaja") != null) {
            try {
                Medicos medico = medNeg.ReadOne(Integer.parseInt(request.getParameter("btnbaja")));
                if(medNeg.Delete(medico)) {
                    request.setAttribute("mensajeExito", "Médico dado de baja correctamente");
                } else {
                    request.setAttribute("mensajeError", "Error al dar de baja al médico");
                }
            } catch (Exception e) {
                request.setAttribute("mensajeError", "Error en el sistema: " + e.getMessage());
            }
        }
        %>
        
        <% if(request.getAttribute("mensajeError") != null) { %>
            <div class="error"><%= request.getAttribute("mensajeError") %></div>
        <% } %>
        <% if(request.getAttribute("mensajeExito") != null) { %>
            <div class="exito"><%= request.getAttribute("mensajeExito") %></div>
        <% } %>
        
        <div class="admin-medicos-container">
            <h3>Gestionar Médicos</h3>
            
            <form action="" method="post" class="admin-medicos-form">
                <table>
                    <thead>
                        <tr>
                            <th>Datos</th>
                            <th>Vinculación</th>
                            <th>Estado</th>
                            <th>Acción</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% if(medico_m != null) { %>
                        <tr>
                            <td>
                                <strong>Legajo: <%= medico_m.getLegajo() %></strong><br><br>
                                <strong>Nombre:</strong>
                                <input type="text" name="nombre" value="<%= medico_m.getNombre() %>" required><br><br>
                                <strong>Apellido:</strong>
                                <input type="text" name="apellido" value="<%= medico_m.getApellido() %>" required><br><br>
                                <strong>Sexo:</strong>
                                <select name="Sexo" required>
                                    <option value="Masculino" <%= "Masculino".equals(medico_m.getSexo()) ? "selected" : "" %>>Masculino</option>
                                    <option value="Femenino" <%= "Femenino".equals(medico_m.getSexo()) ? "selected" : "" %>>Femenino</option>
                                    <option value="Otro" <%= "Otro".equals(medico_m.getSexo()) ? "selected" : "" %>>Otro</option>
                                </select><br><br>
                                <strong>Dirección:</strong>
                                <input type="text" name="direccion" value="<%= medico_m.getDireccion() %>" required><br><br>
                                <strong>Localidad:</strong>
                                <input type="text" name="localidad" value="<%= medico_m.getLocalidad() %>" required><br><br>
                                <strong>Fecha de Nacimiento:</strong>
                                <input type="date" name="fechaNac" value="<%= medico_m.getFechaNac() %>" required><br><br>
                                <strong>Correo electrónico:</strong>
                                <input type="email" name="email" value="<%= medico_m.getEmail() %>" required><br><br>
                                <strong>Días de trabajo:</strong>
                                <input type="text" name="Dias" value="<%= medico_m.getDiasLab() %>" required><br><br>
                                <strong>Horarios de trabajo:</strong>
                                <input type="text" name="horarios" value="<%= medico_m.getHorarioLab() %>" required><br><br>
                                <strong>Teléfono:</strong>
                                <input type="tel" name="telefono" value="<%= medico_m.getTelefono() %>" required>
                            </td>
                            <td>
                                <strong>Usuario:</strong>
                                <input type="text" name="user" value="<%= medico_m.getUsuario().getNombre_Usuario() %>" required><br><br>
                                <strong>Contraseña:</strong>
                                <input type="password" name="password" value="<%= medico_m.getUsuario().getContraseña() %>" required><br><br>
                                <strong>Especialidad:</strong>
                                <select name="especialidad" required>
                                    <% for(Especialidad es : especialidades) { %>
                                        <option value="<%= es.getId() %>" <%= es.getId() == medico_m.getEspecialidad().getId() ? "selected" : "" %>>
                                            <%= es.getNombre() %>
                                        </option>
                                    <% } %>
                                </select><br><br>
                            </td>
                            <td>
                                <strong>Activo</strong>
                                <input type="radio" name="estado" value="activo" <%= medico_m.isEstado() ? "checked" : "" %> required><br><br>
                                <strong>Inactivo</strong>
                                <input type="radio" name="estado" value="inactivo" <%= !medico_m.isEstado() ? "checked" : "" %>>
                            </td>
                            <td>
                                <button type="submit" class="btn-guardar-fila" name="btnguardar_Modificar">Guardar</button>
                            </td>
                        </tr>
                        <% } else { %>
                        <tr>
                            <td>
                                <strong>Legajo:</strong>
                                <input type="text" name="legajo" value="" required><br><br>
                                <strong>Nombre:</strong>
                                <input type="text" name="nombre" value="" required><br><br>
                                <strong>Apellido:</strong>
                                <input type="text" name="apellido" value="" required><br><br>
                                <strong>Sexo:</strong>
                                <select name="Sexo" required>
                                    <option value="Masculino" selected>Masculino</option>
                                    <option value="Femenino">Femenino</option>
                                    <option value="Otro">Otro</option>
                                </select><br><br>
                                <strong>Dirección:</strong>
                                <input type="text" name="direccion" value="" required><br><br>
                                <strong>Localidad:</strong>
                                <input type="text" name="localidad" value="" required><br><br>
                                <strong>Fecha de Nacimiento:</strong>
                                <input type="date" name="fechaNac" required><br><br>
                                <strong>Correo electrónico:</strong>
                                <input type="email" name="email" value="" required><br><br>
                                <strong>Días de trabajo:</strong>
                                <input type="text" name="Dias" value="" required><br><br>
                                <strong>Horarios de trabajo:</strong>
                                <input type="text" name="horarios" value="" required><br><br>
                                <strong>Teléfono:</strong>
                                <input type="tel" name="telefono" value="" required>
                            </td>
                            <td>
                                <strong>Usuario:</strong>
                                <input type="text" name="user" value="" required><br><br>
                                <strong>Contraseña:</strong>
                                <input type="password" name="password" value="" required><br><br>
                                <strong>Especialidad:</strong>
                                <select name="especialidad" required>
                                    <% for(Especialidad es : especialidades) { %>
                                        <option value="<%= es.getId() %>"><%= es.getNombre() %></option>
                                    <% } %>
                                </select><br><br>
                            </td>
                            <td>
                                <strong>Activo</strong>
                                <input type="radio" name="estado" value="activo" checked required><br><br>
                                <strong>Inactivo</strong>
                                <input type="radio" name="estado" value="inactivo">
                            </td>
                            <td>
                                <button type="submit" class="btn-guardar-fila" name="btnguardar">Guardar</button>
                            </td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </form>
        </div>
        
        <div class="admin-medicos-container">
            <h3>Lista de Médicos</h3>
            
            <form action="" method="post" class="admin-medicos-form">
                <strong>Legajo:</strong>
                <input type="text" name="Legajo" placeholder="Ingrese legajo">
                <strong>Especialidad:</strong>
                <select name="especialidad">
                    <option value="">Todas</option>
                    <% for(Especialidad es : especialidades) { %>
                        <option value="<%= es.getId() %>"><%= es.getNombre() %></option>
                    <% } %>
                </select>
                <button type="submit" class="btn-Buscar-fila" name="btnBuscar">Filtrar</button>
                
                <table>
                    <thead>
                        <tr>
                            <th>Legajo</th>
                            <th>Usuario</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Especialidad</th>
                            <th>Sexo</th>
                            <th>Dirección</th>
                            <th>Localidad</th>
                            <th>Fecha Nac.</th>
                            <th>Email</th>
                            <th>Días Trabajo</th>
                            <th>Teléfono</th>
                            <th>Estado</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                        List<Medicos> listaMed = medNeg.ReadAll();
                        boolean unMedico = false;
                        
                        if(request.getParameter("btnBuscar") != null) {
                            String legajoParam = request.getParameter("Legajo");
                            String especialidadParam = request.getParameter("especialidad");
                            
                            if(legajoParam != null && !legajoParam.isEmpty() && especialidadParam != null && !especialidadParam.isEmpty()) {
                                listaMed = medNeg.FiltarXEspecilidadYLegajo(Integer.parseInt(legajoParam), Integer.parseInt(especialidadParam));
                            }
                            else if(especialidadParam != null && !especialidadParam.isEmpty()) {
                                listaMed = medNeg.FiltarXEspecilidad(Integer.parseInt(especialidadParam));
                            }
                            else if(legajoParam != null && !legajoParam.isEmpty()) {
                                try {
                                    int leg = Integer.parseInt(legajoParam);
                                    Medicos medico = medNeg.ReadOne(leg);
                                    if(medico != null) {
                                        unMedico = true;
                        %>
                                        <tr>
                                            <td><%= medico.getLegajo() %></td>
                                            <td><%= medico.getUsuario() != null ? medico.getUsuario().getNombre_Usuario() : "" %></td>
                                            <td><%= medico.getNombre() %></td>
                                            <td><%= medico.getApellido() %></td>
                                            <td><%= medico.getEspecialidad() != null ? medico.getEspecialidad().getNombre() : "" %></td>
                                            <td><%= medico.getSexo() %></td>
                                            <td><%= medico.getDireccion() %></td>
                                            <td><%= medico.getLocalidad() %></td>
                                            <td><%= medico.getFechaNac() != null ? medico.getFechaNac() : "" %></td>
                                            <td><%= medico.getEmail() %></td>
                                            <td><%= medico.getDiasLab() %></td>
                                            <td><%= medico.getTelefono() %></td>
                                            <td><%= medico.isEstado() ? "Activo" : "Inactivo" %></td>
                                            <td>
                                                <button type="submit" class="btn-guardar-fila" name="btnbaja" value="<%= medico.getLegajo() %>">Baja</button>
                                                <button type="submit" class="btn-guardar-fila" name="btnModificar" value="<%= medico.getLegajo() %>">Modificar</button>
                                            </td>
                                        </tr>
                        <%
                                    }
                                } catch(NumberFormatException e) {
                                    request.setAttribute("mensajeError", "Legajo debe ser numérico");
                                }
                            }
                        }
                        
                        if(!unMedico) {
                            for(Medicos medico : listaMed) {
                        %>
                                <tr>
                                    <td><%= medico.getLegajo() %></td>
                                    <td><%= medico.getUsuario() != null ? medico.getUsuario().getNombre_Usuario() : "" %></td>
                                    <td><%= medico.getNombre() %></td>
                                    <td><%= medico.getApellido() %></td>
                                    <td><%= medico.getEspecialidad() != null ? medico.getEspecialidad().getNombre() : "" %></td>
                                    <td><%= medico.getSexo() %></td>
                                    <td><%= medico.getDireccion() %></td>
                                    <td><%= medico.getLocalidad() %></td>
                                    <td><%= medico.getFechaNac() != null ? medico.getFechaNac() : "" %></td>
                                    <td><%= medico.getEmail() %></td>
                                    <td><%= medico.getDiasLab() %></td>
                                    <td><%= medico.getTelefono() %></td>
                                    <td><%= medico.isEstado() ? "Activo" : "Inactivo" %></td>
                                    <td>
                                        <button type="submit" class="btn-guardar-fila" name="btnbaja" value="<%= medico.getLegajo() %>">Baja</button>
                                        <button type="submit" class="btn-guardar-fila" name="btnModificar" value="<%= medico.getLegajo() %>">Modificar</button>
                                    </td>
                                </tr>
                        <%
                            }
                        }
                        %>
                    </tbody>
                </table>
            </form>
            
            <div class="pagination">
                <%
                int currentPage = 1;
                int totalPages = 5;
                
                if(currentPage > 1) {
                %>
                    <a href="?page=<%= currentPage-1 %>" class="page-link">&laquo; Anterior</a>
                <%
                } else {
                %>
                    <span class="page-link disabled">&laquo; Anterior</span>
                <%
                }
                
                for(int i = 1; i <= totalPages; i++) {
                    if(i == currentPage) {
                %>
                        <a href="?page=<%= i %>" class="page-link active"><%= i %></a>
                <%
                    } else {
                %>
                        <a href="?page=<%= i %>" class="page-link"><%= i %></a>
                <%
                    }
                }
                
                if(currentPage < totalPages) {
                %>
                    <a href="?page=<%= currentPage+1 %>" class="page-link">Siguiente &raquo;</a>
                <%
                } else {
                %>
                    <span class="page-link disabled">Siguiente &raquo;</span>
                <%
                }
                %>
            </div>
        </div>
    </div>
</body>
</html>