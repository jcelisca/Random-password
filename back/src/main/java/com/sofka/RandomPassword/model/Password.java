package com.sofka.RandomPassword.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Random;

@Document(collection = "password")
public class Password {
    @Id
    private String id;

    private Date date;

    private String password;

    public Date getDate() {
        return date;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String generateRandomPassword(Integer size) {

        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&";
        /*Mono<StringBuilder> sb = Mono.just(new StringBuilder(size));

        Mono<StringBuilder> random = Mono.from(sb)
                .repeat(size)
                .map(st -> st.append(chars.charAt(new Random().nextInt(chars.length()))))
                .takeLast(1)
                .single();*/

        StringBuilder sb = new StringBuilder(size);

        for(int i =0; i < size; i++)
            sb.append(chars.charAt(new Random().nextInt(chars.length())));

        return String.valueOf(sb);
    }
}