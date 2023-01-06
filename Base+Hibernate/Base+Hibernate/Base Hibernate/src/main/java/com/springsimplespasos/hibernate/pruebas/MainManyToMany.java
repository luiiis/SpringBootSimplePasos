package com.springsimplespasos.hibernate.pruebas;

import com.springsimplespasos.hibernate.entidades.manyToOne.Persona;
import com.springsimplespasos.hibernate.entidades.manyToOne.Telefono;
import com.springsimplespasos.hibernate.entidades.manytomany.Publicacion;
import com.springsimplespasos.hibernate.entidades.manytomany.Usuario;
import com.springsimplespasos.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Arrays;

public class MainManyToMany {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSeccionSessionFactory().openSession();

        Usuario admin = new Usuario(1,"Administrador");
        Usuario user = new Usuario(2,"Usuario");

        Publicacion p1 = new Publicacion(1,"texto de la publicacion uno");
        Publicacion p2 = new Publicacion(2,"texto de la publicacion dos");
        Publicacion p3 = new Publicacion(3,"texto de la publicacion tres");
        Publicacion p4 = new Publicacion(4,"texto de la publicacion cuatro");

        admin.setPublicaciones(Arrays.asList(p1,p2));
        user.setPublicaciones(Arrays.asList(p1,p2,p3,p4));

        /*session.saveOrUpdate(admin);
        session.saveOrUpdate(user);
        session.saveOrUpdate(p1);
        session.saveOrUpdate(p2);
        session.saveOrUpdate(p3);
        session.saveOrUpdate(p4);*/

        session.beginTransaction();

       Usuario usuario= session.get(Usuario.class,2);
        usuario.getPublicaciones().forEach(t->System.out.println(t.getTexto()));

        session.getTransaction().commit();
        session.close();
    }
}
