package br.com.otavio.restwithspringbootandjavaerudio.Models;

import lombok.Data;

@Data
public class Greetings {
    private final Long id;
    private final String content;


    public Greetings(Long id, String content) {
        this.id = id;
        this.content = content;
    }
}
