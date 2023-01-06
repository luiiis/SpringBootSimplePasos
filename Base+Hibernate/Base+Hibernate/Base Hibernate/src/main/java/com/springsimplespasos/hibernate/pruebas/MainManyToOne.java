package com.springsimplespasos.hibernate.pruebas;

import com.springsimplespasos.hibernate.entidades.manyToOne.Persona;
import com.springsimplespasos.hibernate.entidades.manyToOne.Telefono;
import com.springsimplespasos.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Arrays;

public class MainManyToOne {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSeccionSessionFactory().openSession();


        Persona juan = new Persona(null,"Juan");
        Persona mariana = new Persona(null,"Mariana");

        Telefono celularJuan = new Telefono(null,"4881288724");
        Telefono lineaJuan = new Telefono(null,"4881288888");

        celularJuan.setPersona(juan);
        lineaJuan.setPersona(juan);

        juan.setTelefonos(Arrays.asList(celularJuan,lineaJuan));

        session.beginTransaction();
        //session.saveOrUpdate(juan);
        //session.saveOrUpdate(mariana);

        Persona persona = session.get(Persona.class,3);
        persona.getTelefonos().forEach(t->System.out.println(t.getNumero()));

        session.getTransaction().commit();
        session.close();
    }
}
