package com.sofka.passwordRandom.repository;

import com.sofka.passwordRandom.model.Password;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PasswordRepository extends ReactiveCrudRepository<Password,String> {
}
