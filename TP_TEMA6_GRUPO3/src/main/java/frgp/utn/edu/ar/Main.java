package frgp.utn.edu.ar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import dao.daohibernate;

import frgp.utn.edu.entidad.Medicos;

public class Main 
{
    public static void main( String[] args ){
       SessionFactory sessionFactory;
       
       Configuration configuration = new Configuration();
       configuration.configure();
       
       ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
       sessionFactory = configuration.buildSessionFactory(serviceRegistry);
       
       
       Session session = sessionFactory.openSession();
       session.beginTransaction();
       
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
       session.save(med);
       
       
       
       
       session.getTransaction().commit();
       session.close();
       
       sessionFactory.close();
    }
}
