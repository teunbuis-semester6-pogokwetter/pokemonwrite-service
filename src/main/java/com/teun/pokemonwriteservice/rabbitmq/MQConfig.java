package com.teun.pokemonwriteservice.rabbitmq;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;




@Configuration
public class MQConfig {
    static final String QUEUENAME = "userpokemon_queue";
    static final String EXCHANGENAME = "userpokemon_exchange";
    static final String ROUTINGKEY = "userpokemon_routingkey";

    static final String DELETEROUTINGKEY = "userpokemon_delete_routingkey";

    static final String DELETEQUEUENAME = "userpokemon_delete_queue";

    @Bean
    Queue userPokemonQueue(){
        return new Queue(QUEUENAME, true);
    }

    @Bean
    Queue userPokemonDeleteQueue(){
        return new Queue(DELETEQUEUENAME, true);
    }

    @Bean
    TopicExchange userPokemonExchange(){
        return new TopicExchange(EXCHANGENAME);
    }

    @Bean
    Binding bindingDelete(){
        return BindingBuilder.bind(userPokemonDeleteQueue()).to(userPokemonExchange()).with(DELETEROUTINGKEY);
    }

    @Bean
    Binding binding(TopicExchange exchange){
        return BindingBuilder.bind(userPokemonQueue()).to(exchange).with(ROUTINGKEY);
    }
}
