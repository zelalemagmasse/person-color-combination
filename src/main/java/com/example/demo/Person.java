package com.example.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Person {


    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String personName;

    public long getId() {
        return id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setId(long id) {
        this.id = id;

    }
    public Set<Color> getColorChoice() {
        return colorChoice;
    }

    public void setColorChoice(Set<Color> colorChoice) {
        this.colorChoice = colorChoice;
    }

    @ManyToMany(mappedBy = "peopleLikingColor")
    private Set<Color> colorChoice;
    public Person() {
        colorChoice = new HashSet<>();
    }
}
