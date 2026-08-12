package com.example.Model;

import java.util.Objects;

public class Personaje {

    private int id;
    private String name;
    private String ki;
    private String race;
    private String gender;
    private String image;

    public Personaje(int id, String name, String ki, String race, String gender, String image) {
        this.id = id;
        this.name = name;
        this.ki = ki;
        this.race = race;
        this.gender = gender;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getKi() {
        return ki;
    }

    public String getRace() {
        return race;
    }

    public String getGender() {
        return gender;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ki='" + ki + '\'' +
                ", race='" + race + '\'' +
                ", gender='" + gender + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Personaje personaje)) return false;
        return id == personaje.id && Objects.equals(name, personaje.name) && Objects.equals(ki, personaje.ki) && Objects.equals(race, personaje.race) && Objects.equals(gender, personaje.gender) && Objects.equals(image, personaje.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ki, race, gender, image);
    }

}
