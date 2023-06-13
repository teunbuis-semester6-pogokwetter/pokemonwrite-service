package com.teun.pokemonwriteservice.repo;

import com.teun.pokemonwriteservice.models.PokemonImg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonImgRepo extends JpaRepository<PokemonImg, Integer> {
}
