package com.sofka.RandomPassword.controller;

import com.sofka.RandomPassword.model.Password;
import com.sofka.RandomPassword.model.PasswordDTO;
import com.sofka.RandomPassword.repository.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/r")
public class PasswordController {

    private PasswordRepository repository;

    @Autowired
    public PasswordController(PasswordRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Flux<Password> get() {
        return repository.findAll();
    }

    @PostMapping("")
    public Mono<Password> post(@RequestBody PasswordDTO request){
        return Mono.just(new Password()).map(passw -> {
            passw.setDate(new Date());
            passw.setPassword(passw.generateRandomPassword(Integer.parseInt(request.getSize())));
            return passw;
        }).flatMap(repository::save);
    }

}
