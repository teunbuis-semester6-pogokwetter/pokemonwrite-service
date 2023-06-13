package com.teun.pokemonwriteservice.controller;

import com.teun.pokemonwriteservice.dto.UserPokemonDTO;
import com.teun.pokemonwriteservice.service.UserPokemonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/userpokemonwrite")
public class UserPokemonController {

    @Autowired
    UserPokemonService service;

    private final static Logger logger = LoggerFactory.getLogger(UserPokemonController.class);
    private final static String ERROR = "ERROR: ";


    @PostMapping()
    public ResponseEntity<UserPokemonDTO> saveUserPokemonDTO(@RequestBody UserPokemonDTO userPokemonDTO){
        try{
            UserPokemonDTO saved = service.saveUserPokemon(userPokemonDTO);
            return ResponseEntity.ok().body(saved);
        }
        catch (Exception e){
            logger.error(ERROR + e);
            return ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping()
    public ResponseEntity deleteUserPokemonDTO(@RequestBody UserPokemonDTO userPokemonDTO){
        try{
            service.deleteUserPokemon(userPokemonDTO);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            logger.error(ERROR + e);
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping()
    public ResponseEntity<String> updateUserPokemonDTO(@RequestBody UserPokemonDTO userPokemonDTO){
        try{
            String updated = service.updateUserPokemon(userPokemonDTO);
            return ResponseEntity.ok().body(updated);
        }
        catch (Exception e){
            logger.error(ERROR + e);
            return ResponseEntity.badRequest().build();
        }
    }
}
