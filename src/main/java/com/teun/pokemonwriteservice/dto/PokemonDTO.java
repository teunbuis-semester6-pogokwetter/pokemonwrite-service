package com.teun.pokemonwriteservice.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "pokemon")
public class PokemonDTO implements Serializable {
    private Long dexNumber;
    private String name;
    private Boolean legendary;


    public Long getDexNumber() {
        return dexNumber;
    }

    public void setDexNumber(Long dexNumber) {
        this.dexNumber = dexNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getLegendary() {
        return legendary;
    }

    public void setLegendary(Boolean legendary) {
        this.legendary = legendary;
    }
}
