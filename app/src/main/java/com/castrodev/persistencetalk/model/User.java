package com.castrodev.persistencetalk.model;

/**
 * Created by rodrigocastro on 21/06/17.
 */

public class User {
    private int id;
    private String name;
    private String lastname;
    private int age;

    public User(int id, String name, String lastname, int age) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "\n\t\tid=" + id +
                "\n\t\t, name='" + name + '\'' +
                "\n\t\t, lastname='" + lastname + '\'' +
                "\n\t\t, age=" + age +
                "\n\t}";
    }
}
