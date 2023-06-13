package com.teun.pokemonwriteservice.repo;

import com.teun.pokemonwriteservice.dto.UserPokemonDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserPokemonRepo extends MongoRepository<UserPokemonDTO, String> {

    Optional<UserPokemonDTO> findByUserId(Long userId);
    void deleteAllByUserId(Long userId);
}
