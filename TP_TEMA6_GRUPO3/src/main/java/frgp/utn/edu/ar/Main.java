package frgp.utn.edu.ar;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import org.hibernate.Session;

import daoImp.Confighiberneate;
import daoImp.daohibernate;
import frgp.utn.edu.entidad.Especialidad;
import frgp.utn.edu.entidad.Medicos;
import frgp.utn.edu.entidad.Usuario;
import frgp.utn.edu.entidad.Turno;
import frgp.utn.edu.entidad.Paciente;


public class Main 
{
    public static void main( String[] args ){
    	Confighiberneate ch = new Confighiberneate();
    	Session session = ch.abrirConexion();/*
    	//Mostrar todos los médicos ordenados según su legajo de mayor a menor.
    	List<Object[]> lista =(List<Object[]>) session.createQuery("SELECT m.legajo, m.nombre, m.apellido FROM Medicos m ORDER BY m.legajo DESC").list();
    	System.out.println("Legajo mayor a menor:");
    	for (Object[] legajo : lista) {
    		System.out.println(legajo[0]+" " + legajo[1]+" " + legajo[2]);
    	}
    	//Mostrar todos los médicos ordenados según su legajo de menor a mayor.
    	List<Object[]> obj =(List<Object[]>) session.createQuery("SELECT m.legajo, m.nombre, m.apellido FROM Medicos m ORDER BY m.legajo ASC").list();
    	System.out.println("Legajo menor a mayor:");
    	for (Object[] doc : obj) {
    		System.out.println(doc[0]+" " + doc[1]+" " + doc[2]);
    	}
    	
    	//Mostrar todos los turnos que posee el médico con legajo 1234 en el día 01/01/2025
    	List<Object[]> turnos = (List<Object[]>) session.createQuery("FROM Turno tur INNER JOIN tur.Medico m WHERE m.legajo = 1234 AND tur.fecha='01/01/2025'").list();
    	System.out.println("Turnos del medico 1234 en 01/01/25:");
    	for (Object[] turno : turnos) {
    		Turno tur = (Turno) turno[0];
    		Medicos med = (Medicos) turno[1];
    			System.out.println("Leg: "+med.getLegajo()+" Fecha: "+tur.getFecha()+" Estado: "+tur.getEstadoTurno());
    	}
    	
    	//Mostrar todos los legajos de los médicos
    	List<Integer> listaLegajos =(List<Integer>) session.createQuery("SELECT m.legajo FROM Medicos m").list();
    	System.out.println("Todos los legajos:");
    	for (int legajo : listaLegajos) {
    		System.out.println(legajo);
    	}
    	
    	//Mostrar el médico con mayor número de legajo
    	Integer doctor = (Integer) session.createQuery("SELECT MAX(m.legajo) FROM Medicos m").uniqueResult();
    	System.out.println("Mayor legajo:");
    	System.out.println(doctor.toString());
    	
    	//A través de distintas consultas obtener la cantidad de turnos que existen en
    	//estado presente y ausente entre las fechas 01/01/2024 y 01/03/2024. Luego
    	//calcular porcentajes. No habrá turnos pendientes porque las fechas son
    	//antiguas.
    	Long turnosAusente =(Long) session.createQuery("SELECT COUNT(t) FROM Turno t "
    			+ "WHERE t.estado = 'ausente' AND t.fecha BETWEEN '01/01/2024' AND '01/03/2024'").uniqueResult();
    	Long turnosPresente =(Long) session.createQuery("SELECT COUNT(t) FROM Turno t"
    			+ " WHERE t.estado = 'presente' AND t.fecha BETWEEN '01/01/2024' AND '01/03/2024'").uniqueResult();
    	
    	Long total = turnosAusente + turnosPresente;
    	
        double porcentajePresente = (total > 0) ? (turnosPresente * 100.0) / total : 0;
        double porcentajeAusente = (total > 0) ? (turnosAusente * 100.0) / total : 0;
        System.out.println("Porcentaje de turnos:");
        System.out.println("Presente: "+porcentajePresente+"%. Ausente: "+porcentajeAusente+"%");
*/
    	//Pacientes
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        Paciente paciente = new Paciente("Juan", "Pérez", "12345678A", "11-2345-6789",
                "Calle Falsa 123", "Springfield", "Buenos Aires",
                LocalDate.parse("12/05/1980", formatter), "juan.perez@email.com");
        
        Paciente paciente2 = new Paciente("María", "Gómez", "87654321B", "351-987-6543",
                "Av. Siempreviva 456", "Córdoba Capital", "Córdoba",
                LocalDate.parse("23/09/1992", formatter), "maria.gomez@email.com");
        
        Paciente paciente3 = new Paciente("Carlos", "López", "45678912C", "221-555-1234",
                "Paseo Colón 789", "La Plata", "Buenos Aires",
                LocalDate.parse("05/11/1975", formatter), "carlos.lopez@email.com");
        
        Paciente paciente4 = new Paciente("Ana", "Martínez", "78912345D", "261-777-8888",
                "San Martín 101", "Mendoza", "Mendoza",
                LocalDate.parse("30/07/1988", formatter), "ana.martinez@email.com");
        
        Paciente paciente5 = new Paciente("Luisa", "Fernández", "32165498E", "341-222-3333",
                "Belgrano 202", "Rosario", "Santa Fe",
                LocalDate.parse("14/02/1995", formatter), "luisa.fernandez@email.com");
        
        Paciente paciente6 = new Paciente("Pedro", "Rodríguez", "11223344F", "381-444-5555",
                "Av. Independencia 303", "San Miguel de Tucumán", "Tucumán",
                LocalDate.parse("08/12/1983", formatter), "pedro.rodriguez@email.com");
        
        Paciente paciente7 = new Paciente("Sofía", "Díaz", "55667788G", "299-666-7777",
                "Mitre 404", "Neuquén", "Neuquén",
                LocalDate.parse("19/04/1990", formatter), "sofia.diaz@email.com");
        
        Paciente paciente8 = new Paciente("Luis", "Torres", "99887766H", "388-999-0000",
                "Av. España 505", "San Salvador de Jujuy", "Jujuy",
                LocalDate.parse("25/10/1978", formatter), "luis.torres@email.com");
        
        Paciente paciente9 = new Paciente("Elena", "Ruiz", "44332211I", "280-111-2222",
                "Rivadavia 606", "Bahía Blanca", "Buenos Aires",
                LocalDate.parse("03/01/1987", formatter), "elena.ruiz@email.com");
        
        Paciente paciente10 = new Paciente("Miguel", "Sánchez", "77889900J", "342-333-4444",
                "Urquiza 707", "Santa Fe", "Santa Fe",
                LocalDate.parse("17/08/1972", formatter), "miguel.sanchez@email.com");;
    	//Agregar pacientes
    	daohibernate.AgregarPaciente(paciente);
    	daohibernate.AgregarPaciente(paciente2);
    	daohibernate.AgregarPaciente(paciente3);
    	daohibernate.AgregarPaciente(paciente4);
    	daohibernate.AgregarPaciente(paciente5);
    	daohibernate.AgregarPaciente(paciente6);
    	daohibernate.AgregarPaciente(paciente7);
    	daohibernate.AgregarPaciente(paciente8);
    	daohibernate.AgregarPaciente(paciente9);
    	daohibernate.AgregarPaciente(paciente10);
    	
    	
    	//Especialidades
    	Especialidad especialidad = new Especialidad(1, "Cardiología");
    	Especialidad especialidad2 = new Especialidad(2, "Dermatología");
    	Especialidad especialidad3 = new Especialidad(3, "Pediatría");
    	Especialidad especialidad4 = new Especialidad(4, "Ginecología");
    	Especialidad especialidad5 = new Especialidad(5, "Ortopedia");
    	Especialidad especialidad6 = new Especialidad(6, "Neurología");
    	Especialidad especialidad7 = new Especialidad(7, "Oftalmología");
    	Especialidad especialidad8 = new Especialidad(8, "Oncología");
    	Especialidad especialidad9 = new Especialidad(9, "Psiquiatría");
    	Especialidad especialidad10 = new Especialidad(10, "Traumatología");
    	//Agregar especialidades
    	daohibernate.AgregarEspecialidad(especialidad);
    	daohibernate.AgregarEspecialidad(especialidad2);
    	daohibernate.AgregarEspecialidad(especialidad3);
    	daohibernate.AgregarEspecialidad(especialidad4);
    	daohibernate.AgregarEspecialidad(especialidad5);
    	daohibernate.AgregarEspecialidad(especialidad6);
    	daohibernate.AgregarEspecialidad(especialidad7);
    	daohibernate.AgregarEspecialidad(especialidad8);
    	daohibernate.AgregarEspecialidad(especialidad9);
    	daohibernate.AgregarEspecialidad(especialidad10);
    
    	
    	//Medicos y Usuarios
    	
    	Usuario usuario01 = new Usuario("admin", "1234",true);
    	Usuario usuario02 = new Usuario("Jp5011", "Doki50111",true);
    	
    	Usuario usuario = new Usuario("Carlos.G", "Gómez123",false);
    	Medicos med = new Medicos(1001, "Carlos", "Gómez", "Masculino",LocalDate.of(1975, Month.APRIL, 12),"Lunes a Viernes", "07:00 a 15:00", "Calle Principal 456",
    			"Buenos Aires","c.gomez@hospital.com","11-2345-6789",usuario,especialidad );
    	
    	Usuario usuario2 = new Usuario("Rodríguez.m","AnaRodríguez",false);
    	Medicos med2 =new Medicos(1002,"Ana","Rodríguez","Femenino", LocalDate.of(1982, Month.AUGUST, 23), "Martes, Jueves, Sábado",
    			"13:00 a 20:00",
    			"Av. Libertador 789","Córdoba","a.rodriguez@hospital.com", "351-9876543",usuario2,especialidad9);
    	
    	Usuario usuario3 = new Usuario("ana.l", "analopez",false);
    	Medicos med3 = new Medicos( 1003,"Luis","Fernández","Masculino", LocalDate.of(1968, Month.NOVEMBER, 5), "Lunes, Miércoles, Viernes"
    			     ,"08:30 a 16:30",
                "Calle Secundaria 321", "Rosario","l.fernandez@hospital.com", "341-4567890",usuario3,especialidad3);
    	
    	Usuario usuario4 = new Usuario("María.r","Lópezz",false);
    	Medicos med4 = new Medicos (1004, "María","López","Femenino",LocalDate.of(1985, Month.JANUARY, 30),"Lunes a Viernes", "09:00 a 17:00", "Av. Siempreviva 123", 
    			"Mendoza","m.lopez@hospital.com","261-3456789", usuario4 , especialidad4);
    	
    	Usuario usuario5 = new Usuario("sofia.f", "sofiafernandez",false);
    	Medicos med5 = new Medicos(1005,"Juan", "Pérez","Masculino",LocalDate.of(1980, Month.MAY, 15),"Lunes a Sábado","08:00 a 18:00","Calle Falsa 123",
                "Santa Fe","j.perez@clinica.com","342-5556677", usuario5, especialidad5);
    	
    	Usuario usuario6 = new Usuario("diego.p", "diegoperez",false);
    	Medicos med6 = new Medicos(1006, "Diego", "Pérez", "Masculino", LocalDate.of(1978, Month.SEPTEMBER, 8),"Lunes, Miércoles, Viernes",
                "08:00 a 14:00","Av. Corrientes 2345", "Mar del Plata", "diego.perez@email.com", "223-890-1234", usuario6, especialidad6);
    	
    	Usuario usuario7 = new Usuario("valeria.s", "valeriasanchez",false);
    	Medicos med7 = new Medicos(1007, "Valeria", "Sánchez", "Femenino", LocalDate.of(1965, Month.DECEMBER, 3),"Lunes, Miércoles, Viernes",
                "08:00 a 14:00","Calle Sarmiento 678", "Salta", "valeria.sanchez@email.com", "387-901-2345", usuario7, especialidad7);
    	
    	Usuario usuario8 = new Usuario("ricardo.g", "rocardogomez",false);
    	Medicos med8 = new Medicos(1008, "Ricardo", "Gómez", "Masculino",LocalDate.of(1987, Month.MARCH, 19),"Lunes a Sábado",
                "09:00 a 13:00", "Av. Independencia 3456", "Tucumán", "ricardo.gomez@email.com", "381-012-3456", usuario8, especialidad8);
    	
    	Usuario usuario9 = new Usuario("patricia.d", "patriciadiaz",false);
    	Medicos med9 = new Medicos(1009, "Patricia", "Díaz", "Femenino",LocalDate.of(1972, Month.JULY, 25),"Lunes a Viernes", "07:30 a 12:30 y 16:00 a 19:00","Calle Mitre 901", 
                "Santa Fe", "patricia.diaz@email.com", "342-123-4567", usuario9, especialidad9);
    	
    	Usuario usuario10 = new Usuario("alejandro.t", "alejandrotorres",false);
    	Medicos med10 = new Medicos(1010, "Alejandro", "Torres", "Masculino",  LocalDate.of(1983, Month.OCTOBER, 11), "Lunes a Viernes","10:00 a 18:00",
                "Av. España 123", "San Juan", "alejandro.torres@email.com", "264-234-5678", usuario10, especialidad10);
    	
    	//Agregar usuarios
    	
    	daohibernate.AgregarUsuario(usuario01);
    	daohibernate.AgregarUsuario(usuario02);
    	
    	daohibernate.AgregarUsuario(usuario);
    	daohibernate.AgregarUsuario(usuario2);
    	daohibernate.AgregarUsuario(usuario3);
    	daohibernate.AgregarUsuario(usuario4);
    	daohibernate.AgregarUsuario(usuario5);
    	daohibernate.AgregarUsuario(usuario6);
    	daohibernate.AgregarUsuario(usuario7);
    	daohibernate.AgregarUsuario(usuario8);
    	daohibernate.AgregarUsuario(usuario9);
    	daohibernate.AgregarUsuario(usuario10);
    	
    	//Agregar medicos
    	daohibernate.AgregarMedico(med);
    	daohibernate.AgregarMedico(med2);
    	daohibernate.AgregarMedico(med3);
    	daohibernate.AgregarMedico(med4);
    	daohibernate.AgregarMedico(med5);
    	daohibernate.AgregarMedico(med6);
    	daohibernate.AgregarMedico(med7);
    	daohibernate.AgregarMedico(med8);
    	daohibernate.AgregarMedico(med9);
    	daohibernate.AgregarMedico(med10);
    	
    	//Turnos
    	Turno turno = new Turno(med, paciente, LocalDate.parse("15/06/2024", formatter), "09:00", "Consulta cardiológica por dolor torácico", "presente");
        Turno turno2 = new Turno(med2, paciente2, LocalDate.parse("16/06/2024", formatter), "10:30", "Examen dermatológico por erupción cutánea", "pendiente");
        Turno turno3 = new Turno(med3, paciente3, LocalDate.parse("17/06/2024", formatter), "11:15", "Control pediátrico de niño sano", "ausente");
        Turno turno4 = new Turno(med4, paciente4, LocalDate.parse("18/06/2024", formatter), "14:00", "Chequeo ginecológico anual", "presente");
        Turno turno5 = new Turno(med5, paciente5, LocalDate.parse("19/06/2024", formatter), "16:45", "Revisión ortopédica por dolor lumbar", "pendiente");
        Turno turno6 = new Turno(med6, paciente6, LocalDate.parse("20/06/2024", formatter), "08:30", "Evaluación neurológica por migrañas", "ausente");
        Turno turno7 = new Turno(med7, paciente7, LocalDate.parse("21/06/2024", formatter), "13:20", "Examen oftalmológico de rutina", "presente");
        Turno turno8 = new Turno(med8, paciente8, LocalDate.parse("21/06/2024", formatter), "13:20", "Examen oftalmológico de rutina", "presente");
        Turno turno9 = new Turno(med9, paciente9, LocalDate.parse("23/06/2024", formatter), "15:10", "Consulta psiquiátrica para evaluación", "ausente");
        Turno turno10 = new Turno(med10, paciente10, LocalDate.parse("24/06/2024", formatter), "09:45", "Rehabilitación traumatológica post-fractura", "presente");
        
    	//Agregar turnos
    	daohibernate.AgregarTurno(turno);
    	daohibernate.AgregarTurno(turno2);
    	daohibernate.AgregarTurno(turno3);
    	daohibernate.AgregarTurno(turno4);
    	daohibernate.AgregarTurno(turno5);
    	daohibernate.AgregarTurno(turno6);
    	daohibernate.AgregarTurno(turno7);
    	daohibernate.AgregarTurno(turno8);
    	daohibernate.AgregarTurno(turno9);
    	daohibernate.AgregarTurno(turno10);
    	
    	
    	//Modificar turno
    	Turno turnoMod = new Turno(med5, paciente5, LocalDate("19/06/2024"), "16:45", "Revisión ortopédica por dolor lumbar", "ausente");
    	turnoMod.setId(5);
    	daohibernate.Update(turnoMod);
    	//Borrar turno
    	turno10.setId(10);
    	daohibernate.Delete(turno10);
    	//Mostrar turnos
    	System.out.println("Turnos:");
    	ArrayList<Turno> turnos = daohibernate.ListarTodos();
    	for (Turno turno1:turnos){
    		System.out.println(turno1.toString());
    	}
    	//Mostrar datos bidirieccionados
    	System.out.println("Bidireccion:");
    	daohibernate.leerBidireccion();

    	
    	/*
    	Medicos medico1 = new Medicos(1001, "Laura", "González", "Femenino", "1985-03-15",
                "Av. Libertad 1234", "Buenos Aires", "laura.gonzalez@email.com", "11-3456-7890");
    	Medicos medico2 = new Medicos(1002, "Carlos", "Martínez", "Masculino", "1978-07-22",
                "Calle Rivadavia 567", "Córdoba", "carlos.martinez@email.com", "351-456-7890");
    	Medicos medico3 = new Medicos(1003, "Ana", "López", "Femenino", "1990-11-05",
                "Paseo Colón 890", "Rosario", "ana.lopez@email.com", "341-567-8901");
    	Medicos medico4 = new Medicos(1004, "Javier", "Rodríguez", "Masculino", "1982-09-30",
                "Av. San Martín 456", "Mendoza", "javier.rodriguez@email.com", "261-678-9012");
    	Medicos medico5 = new Medicos(1005, "Sofía", "Fernández", "Femenino", "1987-04-18",
                "Calle Belgrano 789", "La Plata", "sofia.fernandez@email.com", "221-789-0123");
    	Medicos medico6 = new Medicos(1006, "Diego", "Pérez", "Masculino", "1975-12-10",
                "Av. Corrientes 2345", "Mar del Plata", "diego.perez@email.com", "223-890-1234");
    	Medicos medico7 = new Medicos(1007, "Valeria", "Sánchez", "Femenino", "1989-06-25",
                "Calle Sarmiento 678", "Salta", "valeria.sanchez@email.com", "387-901-2345");
    	Medicos medico8 = new Medicos(1008, "Ricardo", "Gómez", "Masculino", "1980-08-12",
                "Av. Independencia 3456", "Tucumán", "ricardo.gomez@email.com", "381-012-3456");
    	Medicos medico9 = new Medicos(1009, "Patricia", "Díaz", "Femenino", "1973-02-28",
                "Calle Mitre 901", "Santa Fe", "patricia.diaz@email.com", "342-123-4567");
    	Medicos medico10 = new Medicos(1010, "Alejandro", "Torres", "Masculino", "1984-10-08",
                "Av. España 123", "San Juan", "alejandro.torres@email.com", "264-234-5678");
    	
    	/*daohibernate.AgregarMedico(medico1);
    	daohibernate.AgregarMedico(medico2);
    	daohibernate.AgregarMedico(medico3);
    	daohibernate.AgregarMedico(medico4);
    	daohibernate.AgregarMedico(medico5);
    	daohibernate.AgregarMedico(medico6);
    	daohibernate.AgregarMedico(medico7);
    	daohibernate.AgregarMedico(medico8);
    	daohibernate.AgregarMedico(medico9);
    	daohibernate.AgregarMedico(medico10);
 
    	///Listar medicos
    	ArrayList<Medicos> medicos = daohibernate.ListarTodos();
    	
		System.out.println("Primer Listado:");
    	for (Medicos medico:medicos){
    		System.out.println(medico.toString());
    	}
    	
    	//Modificar medico
    	Medicos medicoMod = new Medicos(1002, "Carlos", "Martínez", "Masculino", "1978-07-26",
                "Calle Rivadavia 321", "Córdoba", "carlos.martinez@email.com", "351-456-7890");
    	daohibernate.Update(medicoMod);
    	
    	//Leo el user modificado
    	Medicos medicoLeer = daohibernate.ReadOne(1002);
    	System.out.println("Modificado:");
    	System.out.println(medicoLeer.toString());
    	
    	//Elimino Medico
    	daohibernate.Delete(medico10);
    	
    	//listar dsp de todos los cambios
    	medicos = daohibernate.ListarTodos();
    	
    	System.out.println("Segundo Listado:");
    	for (Medicos medico:medicos){
    		System.out.println(medico.toString());
    	}
    	
       Medicos med = new Medicos();
       med.setLegajo("123456");
       med.setNombre("Juan");
       med.setApellido("Perez");
       med.setSexo("Masculino");
       med.setDireccion("Belgrano 3427");
       med.setEmail("juanperez@gmail.com");
       med.setFechaNac("12/06/1995");
       med.setTelefono("1167895050");
       med.setLocalidad("Olivos");
       session.save(med);
       
       med = new Medicos();
       med.setLegajo("123457");
       med.setNombre("maria");
       med.setApellido("esquen");
       med.setSexo("femenino");
       med.setDireccion("Belgrano 5214");
       med.setEmail("mariae@gmail.com");
       med.setFechaNac("18/07/1997");
       med.setTelefono("1126999842");
       med.setLocalidad("Munro");
       session.save(med);
       
       med = new Medicos();
       med.setLegajo("44556");
       med.setNombre("luis");
       med.setApellido("banco");
       med.setSexo("Masculino");
       med.setDireccion("Belgrano 5665");
       med.setEmail("luis@gmail.com");
       med.setFechaNac("22/06/1990");
       med.setTelefono("1123323333");
       med.setLocalidad("Olivos");
       session.save(med);*/
    }

	private static LocalDate LocalDate(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
