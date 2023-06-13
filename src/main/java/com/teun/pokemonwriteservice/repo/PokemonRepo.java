package com.teun.pokemonwriteservice.repo;

import com.teun.pokemonwriteservice.models.Pokemon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepo extends MongoRepository<Pokemon, String> {
}
