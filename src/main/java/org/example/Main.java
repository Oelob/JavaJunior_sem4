package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory()) {

            //Создание нового курса
//           HibernateCommands.createCourse(sessionFactory);

            //получить даные по всем курсам
//            List<Course> allCourses = HibernateCommands.getAllCourses(sessionFactory);
//            System.out.println(allCourses.toString());

            //получить данные по конкретному курсу по его ID
//            System.out.println(HibernateCommands.getCourse(sessionFactory, 3));

            //изменить данные курса по ID
//            HibernateCommands.updateTitle(sessionFactory, 3);
//            System.out.println(HibernateCommands.getCourse(sessionFactory, 3));

            //удалить курс по ID
//            HibernateCommands.removeCourse(sessionFactory, 3);
//            List<Course> allCoursesAfterRemove = HibernateCommands.getAllCourses(sessionFactory);
//            System.out.println(allCoursesAfterRemove.toString());

        }catch (Exception e){
             e.printStackTrace();
        }
    }
}