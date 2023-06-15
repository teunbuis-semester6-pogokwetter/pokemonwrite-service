package com.teun.pokemonwriteservice.service;

import com.teun.pokemonwriteservice.dto.UserPokemonDTO;
import com.teun.pokemonwriteservice.rabbitmq.Publisher;
import com.teun.pokemonwriteservice.repo.UserPokemonRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPokemonService {
    @Autowired
    UserPokemonRepo repo;

    @Autowired
    Publisher publisher;

    Logger logger = LoggerFactory.getLogger(UserPokemonService.class);


    public void deleteUserPokemon(UserPokemonDTO userPokemonDTO){
        deleteUserPokemonFromDataBase(userPokemonDTO);
        publisher.publishUserPokemonDTODelete(userPokemonDTO);
    }
    public void deleteAllUserPokemonByUserId(Long userId){

        deleteAllUserPokemonByUserIdFromDatabase(userId);
    }
    public String updateUserPokemon(UserPokemonDTO userPokemonDTO){
        return updateUserPokemonInDatabase(userPokemonDTO);
    }

    public UserPokemonDTO saveUserPokemon(UserPokemonDTO userPokemonDTO){
        UserPokemonDTO saved = saveUserPokemonToDatabase(userPokemonDTO);
        if(saved != null){
            publisher.publishUserPokemonDTO(saved);
        }
        return saved;
    }
    private UserPokemonDTO saveUserPokemonToDatabase(UserPokemonDTO userPokemonDTO){
        UserPokemonDTO savedUserPokemon = repo.save(userPokemonDTO);
        logger.info("[ 🌟 ] Saved userpokemon to database [ 🌟 ]");
        return savedUserPokemon;
    }
    private void deleteUserPokemonFromDataBase(UserPokemonDTO userPokemonDTO){
        repo.delete(userPokemonDTO);
    }
    private void deleteAllUserPokemonByUserIdFromDatabase(Long userId){
        repo.deleteAllByUserId(userId);
    }
    private String updateUserPokemonInDatabase(UserPokemonDTO userPokemonDTO){
        UserPokemonDTO toUpdate = repo.findByUserId(userPokemonDTO.getUserId()).orElse(null);
        if(toUpdate != null){
            repo.save(userPokemonDTO);
            logger.info("Updated");
            return "Updated";
        }
        else{
            logger.info("No UserPokemon Could Be Found");
            return "Could not Update";
        }
    }

    public void deleteUserPokemonByUserId(Long userId) {
        deleteUserPokemonFromDataBaseByUserId(userId);
    }

    private void deleteUserPokemonFromDataBaseByUserId(Long userId) {

        repo.deleteAllByUserId(userId);
        logger.info("Deleted all userPokemons with userId: " + userId );
    }
}
