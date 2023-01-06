package com.springsimplespasos.hibernate.pruebas;

import com.springsimplespasos.hibernate.entidades.SimpleEntity;
import com.springsimplespasos.hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class HibernateMain {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSeccionSessionFactory().openSession();
        session.beginTransaction();
        //insertar

        /*SimpleEntity entity = new SimpleEntity();
        entity.setNombre("Descripcion");
        session.save(entity);*/

        //actualizar
        /*SimpleEntity entity = new SimpleEntity();
        entity.setCodigo(2);
        entity.setNombre("Descripcion update");
        session.update(entity);*/

        //eliminar
        /*SimpleEntity entity = new SimpleEntity();
        entity.setCodigo(1);
        session.delete(entity);*/

        /*SimpleEntity entityRead = session.get(SimpleEntity.class,1);
        System.out.println(entityRead.getCodigo());*/

        SimpleEntity entity = new SimpleEntity();
        entity.setNombre("Descripcion");

        SimpleEntity entityU = new SimpleEntity();
        entityU.setCodigo(1);
        entityU.setNombre("Descripcion update");

       session.saveOrUpdate(entityU);
        session.saveOrUpdate(entity);

        session.getTransaction().commit();
        session.close();
    }

}
