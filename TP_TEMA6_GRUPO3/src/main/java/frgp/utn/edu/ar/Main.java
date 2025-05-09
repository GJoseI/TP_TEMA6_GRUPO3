package frgp.utn.edu.ar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

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
       
       session.getTransaction().commit();
       session.close();
       
       sessionFactory.close();
    }
}
