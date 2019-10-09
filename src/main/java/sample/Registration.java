package sample;

import java.util.ArrayList;
import java.util.Date;

public class Registration {

    private String name;
    private String surname;
    private Integer age;
    private ArrayList<Date> courseDate ;

    public Registration(String name, String surname, Integer age, ArrayList<Date> courseDate) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.courseDate = courseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public ArrayList<Date> getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(ArrayList<Date> courseDate) {
        this.courseDate = courseDate;
    }
}
