package com.teun.pokemonwriteservice.repo;

import com.teun.pokemonwriteservice.models.PokemonImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PokemonImgRepo extends JpaRepository<PokemonImg, Integer> {
}
