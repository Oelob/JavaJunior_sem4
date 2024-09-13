package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Id;
import java.util.List;

public class HibernateCommands {

    //создание нового курса
    public static void createCourse(SessionFactory sessionFactory){
        try (Session session = sessionFactory.openSession()) {
            Course course = Course.create();
            session.save(course);
        }
    }

   //получить информацию по ID
   public static Course getCourse(SessionFactory sessionFactory, Integer id) {
       try (Session session = sessionFactory.openSession()) {
           return session.get(Course.class, id);
       }
   }


    //получить всю информацию по таблице
    public static List<Course> getAllCourses(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Course", Course.class).list();
        }
    }

    //изменить название курса
    public static void updateTitle(SessionFactory sessionFactory, Integer id){
       Session session = sessionFactory.openSession();
       try {
           session.beginTransaction();
           Course courseToUpdate = session.get(Course.class, id);
           courseToUpdate.setTitle(Course.newTitle());
           session.persist(courseToUpdate);
           session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
        }finally {
           session.close();
       }
    }

    //удаление курса по ID
    public static void removeCourse(SessionFactory sessionFactory, Integer id){
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Course courseToRemove = session.get(Course.class, id);
            session.remove(courseToRemove);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
    }

}
