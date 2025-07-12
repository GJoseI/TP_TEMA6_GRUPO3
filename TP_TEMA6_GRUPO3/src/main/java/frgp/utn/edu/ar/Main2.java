package frgp.utn.edu.ar;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import daoImp.Confighiberneate;
import daoImp.daohibernate;
import frgp.utn.edu.entidad.Especialidad;
import frgp.utn.edu.entidad.Medicos;
import frgp.utn.edu.entidad.Usuario;
import frgp.utn.edu.entidad.Turno;
import frgp.utn.edu.entidad.Paciente;


public class Main2 
{
    public static void main( String[] args ){
    	Confighiberneate ch = new Confighiberneate();
    	Session session = ch.abrirConexion();
/*
    	//Pacientes
    	Paciente paciente = new Paciente("Juan", "Pérez", "12345678A", "11-2345-6789",
                "Calle Falsa 123", "Springfield", "Buenos Aires",
                "12/05/1980", "juan.perez@email.com");
    	Paciente paciente2 = new Paciente("María", "Gómez", "87654321B", "351-987-6543",
                "Av. Siempreviva 456", "Córdoba Capital", "Córdoba",
                "23/09/1992", "maria.gomez@email.com");
    	Paciente paciente3 = new Paciente("Carlos", "López", "45678912C", "221-555-1234",
                "Paseo Colón 789", "La Plata", "Buenos Aires",
                "05/11/1975", "carlos.lopez@email.com");
    	Paciente paciente4 = new Paciente("Ana", "Martínez", "78912345D", "261-777-8888",
                "San Martín 101", "Mendoza", "Mendoza",
                "30/07/1988", "ana.martinez@email.com");
    	Paciente paciente5 = new Paciente("Luisa", "Fernández", "32165498E", "341-222-3333",
                "Belgrano 202", "Rosario", "Santa Fe",
                "14/02/1995", "luisa.fernandez@email.com");
    	Paciente paciente6 = new Paciente("Pedro", "Rodríguez", "11223344F", "381-444-5555",
                "Av. Independencia 303", "San Miguel de Tucumán", "Tucumán",
                "08/12/1983", "pedro.rodriguez@email.com");
    	Paciente paciente7 = new Paciente("Sofía", "Díaz", "55667788G", "299-666-7777",
                "Mitre 404", "Neuquén", "Neuquén",
                "19/04/1990", "sofia.diaz@email.com");
    	Paciente paciente8 = new Paciente("Luis", "Torres", "99887766H", "388-999-0000",
                "Av. España 505", "San Salvador de Jujuy", "Jujuy",
                "25/10/1978", "luis.torres@email.com");
    	Paciente paciente9 = new Paciente("Elena", "Ruiz", "44332211I", "280-111-2222",
                "Rivadavia 606", "Bahía Blanca", "Buenos Aires",
                "03/01/1987", "elena.ruiz@email.com");
    	Paciente paciente10 = new Paciente("Miguel", "Sánchez", "77889900J", "342-333-4444",
                "Urquiza 707", "Santa Fe", "Santa Fe",
                "17/08/1972", "miguel.sanchez@email.com");
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
    
    	/*
    	//Medicos y Usuarios
    	Usuario usuario = new Usuario("Laura.G", "lauragonzalez");
    	Medicos med = new Medicos(1001, "Laura", "González", "Femenino", "1985-03-15",
                "Av. Libertad 1234", "Buenos Aires", "laura.gonzalez@email.com", "11-3456-7890", usuario, especialidad);
    	
    	Usuario usuario2 = new Usuario("carlos.m","carlosmartinez");
    	Medicos med2 = new Medicos(1002, "Carlos", "Martínez", "Masculino", "1978-07-22",
                "Calle Rivadavia 567", "Córdoba", "carlos.martinez@email.com", "351-456-7890", usuario2, especialidad2);
    	
    	Usuario usuario3 = new Usuario("ana.l", "analopez");
    	Medicos med3 = new Medicos(1003, "Ana", "López", "Femenino", "1990-11-05",
                "Paseo Colón 890", "Rosario", "ana.lopez@email.com", "341-567-8901", usuario3, especialidad3);
    	
    	Usuario usuario4 = new Usuario("javier.r","javierrodriguez");
    	Medicos med4 = new Medicos(1004, "Javier", "Rodríguez", "Masculino", "1982-09-30",
                "Av. San Martín 456", "Mendoza", "javier.rodriguez@email.com", "261-678-9012", usuario4, especialidad4);
    	
    	Usuario usuario5 = new Usuario("sofia.f", "sofiafernandez");
    	Medicos med5 = new Medicos(1005, "Sofía", "Fernández", "Femenino", "1987-04-18",
                "Calle Belgrano 789", "La Plata", "sofia.fernandez@email.com", "221-789-0123", usuario5, especialidad5);
    	
    	Usuario usuario6 = new Usuario("diego.p", "diegoperez");
    	Medicos med6 = new Medicos(1006, "Diego", "Pérez", "Masculino", "1975-12-10",
                "Av. Corrientes 2345", "Mar del Plata", "diego.perez@email.com", "223-890-1234", usuario6, especialidad6);
    	
    	Usuario usuario7 = new Usuario("valeria.s", "valeriasanchez");
    	Medicos med7 = new Medicos(1007, "Valeria", "Sánchez", "Femenino", "1989-06-25",
                "Calle Sarmiento 678", "Salta", "valeria.sanchez@email.com", "387-901-2345", usuario7, especialidad7);
    	
    	Usuario usuario8 = new Usuario("ricardo.g", "rocardogomez");
    	Medicos med8 = new Medicos(1008, "Ricardo", "Gómez", "Masculino", "1980-08-12",
                "Av. Independencia 3456", "Tucumán", "ricardo.gomez@email.com", "381-012-3456", usuario8, especialidad8);
    	
    	Usuario usuario9 = new Usuario("patricia.d", "patriciadiaz");
    	Medicos med9 = new Medicos(1009, "Patricia", "Díaz", "Femenino", "1973-02-28",
                "Calle Mitre 901", "Santa Fe", "patricia.diaz@email.com", "342-123-4567", usuario9, especialidad9);
    	
    	Usuario usuario10 = new Usuario("alejandro.t", "alejandrotorres");
    	Medicos med10 = new Medicos(1010, "Alejandro", "Torres", "Masculino", "1984-10-08",
                "Av. España 123", "San Juan", "alejandro.torres@email.com", "264-234-5678", usuario10, especialidad10);
    	
    	//Agregar usuarios
    	
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
    	Turno turno = new Turno(med, paciente, "15/06/2024", "09:00", "Consulta cardiológica por dolor torácico", "presente");
    	Turno turno2 = new Turno(med2, paciente2, "16/06/2024", "10:30", "Examen dermatológico por erupción cutánea", "pendiente");
    	Turno turno3 = new Turno(med3, paciente3, "17/06/2024", "11:15", "Control pediátrico de niño sano", "ausente");
    	Turno turno4 = new Turno(med4, paciente4, "18/06/2024", "14:00", "Chequeo ginecológico anual", "presente");
    	Turno turno5 = new Turno(med5, paciente5, "19/06/2024", "16:45", "Revisión ortopédica por dolor lumbar", "pendiente");
    	Turno turno6 = new Turno(med6, paciente6, "20/06/2024", "08:30", "Evaluación neurológica por migrañas", "ausente");
    	Turno turno7 = new Turno(med7, paciente7, "21/06/2024", "13:20", "Examen oftalmológico de rutina", "presente");
    	Turno turno8 = new Turno(med8, paciente8, "21/06/2024", "13:20", "Examen oftalmológico de rutina", "presente");
    	Turno turno9 = new Turno(med9, paciente9, "23/06/2024", "15:10", "Consulta psiquiátrica para evaluación", "ausente");
    	Turno turno10 = new Turno(med10 ,paciente10, "24/06/2024", "09:45", "Rehabilitación traumatológica post-fractura", "presente");
    	
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
    	*/
    }
}
