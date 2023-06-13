package com.teun.pokemonwriteservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pokemon implements Serializable {

    //fields
    private Long dexNumber;
    private String name;
    private Boolean legendary;
}
