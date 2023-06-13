package com.teun.pokemonwriteservice.repo;

import com.teun.pokemonwriteservice.models.UserPokemon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserPokemonRepo extends MongoRepository<UserPokemon, String> {
}
