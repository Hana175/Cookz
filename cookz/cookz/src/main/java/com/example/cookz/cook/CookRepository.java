package com.example.cookz.cook;

import java.util.*;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class CookRepository {
    private List<Cook> cooks = new ArrayList<>();

    List<Cook> findAll() {
        return cooks;
    }

    Cook findById(int id) {
        return cooks.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    

    // its like seed data, we are adding some data to the list.
    // used on a method that needs to be executed after dependency injection to
    // perform any initialization.
    @PostConstruct
    private void init() {
        cooks.add(new Cook(1, "Pasta", "Italian pasta", "pasta, tomato sauce, cheese",
                "boil pasta, add sauce, add cheese", "Italian", "pasta.jpg"));
        cooks.add(new Cook(2, "Pizza", "Italian pizza", "dough, tomato sauce, cheese",
                "make dough, add sauce, add cheese, bake", "Italian", "pizza.jpg"));
        cooks.add(new Cook(3, "Sushi", "Japanese sushi", "rice, fish, seaweed",
                "make rice, add fish, wrap in seaweed", "Japanese", "sushi.jpg"));
    }
}
