package com.ecomerce.test.entities;

import java.time.LocalDate;

public class Staff {
    private int id;
    private String name;
    private LocalDate birthdate;
    private String Adress;

    public Staff(int id, String name, LocalDate birthdate, String adress) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        Adress = adress;
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }
}
