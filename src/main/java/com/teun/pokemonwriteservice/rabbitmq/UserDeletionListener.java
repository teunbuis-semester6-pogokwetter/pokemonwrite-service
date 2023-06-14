package com.teun.pokemonwriteservice.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teun.pokemonwriteservice.service.UserPokemonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDeletionListener {

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    UserPokemonService service;
    private static final Logger logger = LoggerFactory.getLogger(UserDeletionListener.class);

    @RabbitListener(queues = "user_delete_queue")
    public void handleDeleteUser(String message){
        logger.info("Received user id for deletion");
        try {
            Long userId = objectMapper.readValue(message, Long.class);
            if(userId != null ){
                service.deleteUserPokemonByUserId(userId);

            }
        } catch (JsonProcessingException e) {
            logger.error("ERROR: " + e);
        }
    }
}
