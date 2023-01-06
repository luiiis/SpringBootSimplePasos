package com.springsimplespasos.hibernate.pruebas;

import com.springsimplespasos.hibernate.entidades.manyToOne.Persona;
import com.springsimplespasos.hibernate.entidades.manyToOne.Telefono;
import org.hibernate.Session;
import com.springsimplespasos.hibernate.util.HibernateUtil;
import javax.persistence.Query;
import java.util.List;

public class MainJPQL {
    public static void main(String[] args) {
        //SQL NATIVO SELECT*FROM personas WHERE codigo =?
        Session session= HibernateUtil.getSeccionSessionFactory().openSession();
        Query query =session.createQuery("select p from Persona p where p.codigo =?1");
        query.setParameter(1,Integer.parseInt("1"));

        Persona persona =(Persona) query.getSingleResult();
        System.out.println(persona.getNombre());

        //SELECT*FROM personas p JOIN telefonos t  on p.codigo=t.codigo where p.codigo =?
          Query quer2= session.createQuery("select p.telefonos from Persona p where p.codigo=:codigo");
          quer2.setParameter("codigo",Integer.parseInt("1"));
        List<Telefono> telefonos = (List<Telefono>)quer2.getResultList();
        telefonos.forEach(telefono->System.out.println(telefono.getNumero()));

        session.close();

    }
}
