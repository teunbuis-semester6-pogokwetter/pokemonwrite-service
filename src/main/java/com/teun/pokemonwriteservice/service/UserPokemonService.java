package com.teun.pokemonwriteservice.service;

import com.teun.pokemonwriteservice.dto.UserPokemonDTO;
import com.teun.pokemonwriteservice.models.UserPokemon;
import com.teun.pokemonwriteservice.repo.UserPokemonRepo;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPokemonService {

    private static final String FROM_DATABASE = "[ 🌟 ] Retreived pokemon from database [ 🌟 ]";
    @Autowired
    UserPokemonRepo repo;
    @Autowired
    ModelMapper modelMapper;

    Logger logger = LoggerFactory.getLogger(UserPokemonService.class);

    @CachePut(value = "userPokemon", key ="#userId")
    public UserPokemonDTO saveUserPokemon(UserPokemonDTO userPokemonDTO, long userId){
        return saveUserPokemonToDatabase(userPokemonDTO);
    }
    private UserPokemonDTO saveUserPokemonToDatabase(UserPokemonDTO userPokemonDTO){
        UserPokemon toSave = modelMapper.map(userPokemonDTO, UserPokemon.class);
        UserPokemon savedUserPokemon = repo.save(toSave);
        logger.info("[ 🌟 ] Saved userpokemon to database [ 🌟 ]");
        return modelMapper.map(savedUserPokemon, UserPokemonDTO.class);
    }
}
