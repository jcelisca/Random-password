package com.sofka.passwordRandom.model;

import reactor.core.publisher.Mono;

import java.util.Random;

public class PasswordDTO {
    private String password;
    private Integer size;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword() {
        this.password = String.valueOf(generateRandomPassword(getSize()));
    }

    public Mono<StringBuilder> generateRandomPassword(Integer size) {

        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&";
        Mono<StringBuilder> sb = Mono.just(new StringBuilder(size));

        Mono<StringBuilder> random = Mono.from(sb)
                .repeat(size)
                .map(st -> st.append(chars.charAt(new Random().nextInt(chars.length()))))
                .takeLast(1)
                .single();

        return random;
    }
}



