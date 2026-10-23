package com.example.demo.Model.Entity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends MongoRepository <Usuario, String> {

	Optional<Usuario> findByEmailAndPassword(String email, String password);

}
