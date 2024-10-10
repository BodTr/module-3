package com.books_manager.case_study.Entities;

import java.time.LocalDate;

public class Author {
    private int id;
    private String name;
    private LocalDate birthDate;
    private String bio;

    public Author(int id, String name, LocalDate birthDate, String bio) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.bio = bio;
    }

    public Author( String name, LocalDate birthDate, String bio) {
        this.name = name;
        this.birthDate = birthDate;
        this.bio = bio;
    }

    public Author(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", bio='" + bio + '\'' +
                '}';
    }
}
