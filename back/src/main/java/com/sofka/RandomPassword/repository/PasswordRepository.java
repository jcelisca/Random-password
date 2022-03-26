package com.sofka.RandomPassword.repository;

import com.sofka.RandomPassword.model.Password;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PasswordRepository extends ReactiveCrudRepository<Password,String> {
}
