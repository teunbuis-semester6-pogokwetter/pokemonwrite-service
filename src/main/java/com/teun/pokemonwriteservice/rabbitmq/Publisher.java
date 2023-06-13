package com.teun.pokemonwriteservice.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teun.pokemonwriteservice.dto.UserPokemonDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Publisher{

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    ObjectMapper objectMapper;
    Logger logger = LoggerFactory.getLogger(Publisher.class);

    public void publishUserPokemonDTO (UserPokemonDTO userPokemonDTO){
        try{
            String userPokemon = objectMapper.writeValueAsString(userPokemonDTO);
            rabbitTemplate.convertAndSend(MQConfig.EXCHANGENAME, MQConfig.ROUTINGKEY, userPokemon);
            logger.info("[ ✨ ] " + "Send userPokemon to Queue: " + userPokemonDTO + " [ ✨ ]");
        }
        catch (Exception e){
            logger.error("Error:" + e);
        }
    }
    public void publishUserPokemonDTODelete (UserPokemonDTO userPokemonDTO){
        try{
            String userPokemon = objectMapper.writeValueAsString(userPokemonDTO);
            rabbitTemplate.convertAndSend(MQConfig.EXCHANGENAME, MQConfig.DELETEROUTINGKEY, userPokemon);
            logger.info("[ ✨ ] " + "Send userPokemon to Queue for deletion: " + userPokemonDTO + " [ ✨ ]");
        }
        catch (Exception e){
            logger.error("Error:" + e);
        }
    }
}
