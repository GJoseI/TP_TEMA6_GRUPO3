package frgp.utn.edu.ar;

import java.util.ArrayList;

import dao.daohibernate;
import frgp.utn.edu.entidad.Medicos;

public class Main 
{
    public static void main( String[] args ){
    	
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
    	daohibernate.AgregarMedico(medico10);*/
 
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
    	
       /*Medicos med = new Medicos();
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
}
