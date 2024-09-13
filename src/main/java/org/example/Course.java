package org.example;


import javax.persistence.*;
import java.util.Random;

@Entity
@Table (name = "courses")
public class Course {

    public static final String[] titles = {"Высшая математика","Логика","Социологи","Риторика","Политология","Экономика"};
    private static final Random rand = new Random();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private int duration;

    //region Конструкторы
    public Course() {
    }

    public Course(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }
    //endregion

    //region Getters/Setters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    //endregion

    //region Методы

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }

    //создание курса
    public static Course create(){
        return new Course(titles[rand.nextInt(titles.length)], rand.nextInt(1,7));
    }

    //метод изменения названия курса
    public static String newTitle(){
        return titles[rand.nextInt(titles.length)];
    }

    //endregion
}
