package cz.educanet.webik;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class Animal {

    public  int id;
    public  String name;
    public  int age;
    public  double weight;
    public  String gender;

    public Animal(int id, String name, int age, double weight, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
