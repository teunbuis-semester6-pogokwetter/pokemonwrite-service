package com.teun.pokemonwriteservice.service;

import com.teun.pokemonwriteservice.dto.PokemonDTO;
import com.teun.pokemonwriteservice.repo.PokemonRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PokemonService {

    private static final String FROM_DATABASE = "[ 🌟 ] Retrieved pokemon from database [ 🌟 ]";
    @Autowired
    PokemonRepo repo;
    Logger logger = LoggerFactory.getLogger(PokemonService.class);

    public PokemonDTO savePokemonToDatabase(PokemonDTO pokemonDTO){
        return repo.save(pokemonDTO);
    }
    public void deletePokemonFromDatabase(PokemonDTO pokemonDTO){
        repo.delete(pokemonDTO);
    }
    public void updatePokemonToDatabase(PokemonDTO pokemonDTO){
        if(repo.findByDexNumber(pokemonDTO.getDexNumber()).isPresent()){
            repo.save(pokemonDTO);
        }
        else{
            logger.info("Could Not Update Pokemon");
        }

    }


}
