package com.sofka.passwordRandom.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "password")
public class Password {
    @Id
    private String id;

    private LocalDate date;

    private String password;

    public LocalDate getDate() {
        return date;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
