package com.sofka.passwordRandom.controller;

import com.sofka.passwordRandom.model.Password;
import com.sofka.passwordRandom.model.PasswordDTO;
import com.sofka.passwordRandom.repository.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/password")
public class PasswordController {

    @Autowired
    private PasswordRepository repository;

    @GetMapping("")
    public Flux<Password> get() {
        return repository.findAll();
    }

    @PostMapping("")
    public Mono<Password> post(@RequestBody PasswordDTO request){
        return Mono.just(new Password()).map(passw -> {
            passw.setDate(LocalDate.now());
            passw.setPassword(passw.generateRandomPassword(request.getSize()));
            return passw;
        }).flatMap(repository::save);
    }

}
