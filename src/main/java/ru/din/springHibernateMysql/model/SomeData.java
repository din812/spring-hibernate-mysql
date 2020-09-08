package ru.din.springHibernateMysql.model;


import javax.persistence.*;

// some POJO
@Entity
@Table(name = "someData")
public class SomeData {


    private int id;
    private String name;
    private String surName;
    private String birthDate;
    private String gender;
    private boolean someBoolean;


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "surname")
    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Column(name = "birthdate")
    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column(name = "someBoolean")
    public boolean isSomeBoolean() {
        return someBoolean;
    }

    public void setSomeBoolean(boolean someBoolean) {
        this.someBoolean = someBoolean;
    }

    @Override
    public String toString() {
        return "SomeData:\n" +
                "\nid=" + id +
                "\nname='" + name + '\'' +
                "\nsurName='" + surName + '\'' +
                "\nbirthDate='" + birthDate + '\'' +
                "\ngender='" + gender + '\'' +
                "\nsomeBoolean=" + someBoolean;
    }
}
