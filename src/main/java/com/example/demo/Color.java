package com.example.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Color {
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    private String colorName;
    @ManyToMany()
    private Set<Person> peopleLikingColor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public Set<Person> getPeopleLikingColor() {
        return peopleLikingColor;
    }

    public void setPeopleLikingColor(Set<Person> peopleLikingColor) {
        this.peopleLikingColor = peopleLikingColor;
    }

    public Color() {
        peopleLikingColor = new HashSet<>();
    }
}