package com.teun.pokemonwriteservice.repo;

import com.teun.pokemonwriteservice.dto.PokemonDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonRepo extends MongoRepository<PokemonDTO, String> {
    Optional<PokemonDTO> findByDexNumber(Long dexNumber);
}
