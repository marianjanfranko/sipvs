package sample;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;

public class Registration {

    private String name;
    private String surname;
    private Integer age;
    @JacksonXmlElementWrapper(useWrapping = false)
    private ArrayList<String> courseDate ;

    public Registration(String name, String surname, Integer age, ArrayList<String> courseDate) {
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

    public ArrayList<String> getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(ArrayList<String> courseDate) {
        this.courseDate = courseDate;
    }
}
