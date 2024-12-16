package com.example.cookz.cook;

import java.util.*;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcClientCookRepository {

    private List<Cook> cooks = new ArrayList<>();
    private final Logger logger = LoggerFactory.getLogger(JdbcClientCookRepository.class);
    private final JdbcClient jdbcClient;

    public JdbcClientCookRepository(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    public List<Cook> findAll(){
        return jdbcClient.sql("select * from cook")
                .query(Cook.class)
                .list();
    }
    public int count(){
        return jdbcClient.sql("select * from cook")
                .query()
                .listOfRows()
                .size();
    }
    public void delete(int id)
    {
        var updated = jdbcClient.sql("delete from cook where id=:id")
                .param("id", id)
                .update();
    }
    public void create(Cook cook) {
        var updated = jdbcClient.sql("insert into cook(id, name, description, ingredients, instructions, category, image) values(?,?,?,?,?,?,?)")
                .params(List.of(cook.id, cook.name, cook.description, cook.ingredients, cook.instructions, cook.category, cook.image))
                .update();
    }


    public void update(Cook cook, int id) {
        var updates = jdbcClient.sql("update cook set name =?, description=?, ingredients=?, instructions=?, category=?, image=? where id = ?")
                .params(List.of(cook.name, cook.description, cook.ingredients, cook.instructions, cook.category, cook.image, id))
                .update();
    }

    public Optional<Cook> findById(int id){
        return jdbcClient.sql("select * from cook where id=:id ")
                .param("id",id)
                .query(Cook.class)
                .optional();
    }
    public void saveAll(List<Cook> cooks){
        cooks.stream()
                .forEach(this::create);
    }

//    List<Cook> findAll() {
//        return cooks;
//    }
//
//    // Optional instead of Cook because the id might not exist. a non null value.
//    Optional<Cook> findById(int id) {
//        return cooks.stream()
//                .filter(c -> c.getId() == id)
//                .findFirst();
//    }
//
//    // post
//    void create(Cook cook) {
//        cooks.add(cook);
//    }
//
//    // update
//
//    void update(Cook cook, Integer id) {
//        Optional<Cook> existingCook = findById(id);
//        if (existingCook.isPresent()) {
//            cooks.set(cooks.indexOf(existingCook.get()), cook);
//
//        }
//    }
//
//    // delete
//
//    void delete(Integer id) {
//        Optional<Cook> existingCook = findById(id);
//        if (existingCook.isPresent()) {
//            cooks.remove(existingCook.get());
//        }
//        // OR
//        // cooks.removeIf(c -> c.getId() == id);
//    }

    // its like seed data, we are adding some data to the list.
    // used on a method that needs to be executed after dependency injection to
    // perform any initialization.
//    @PostConstruct
//    private void init() {
//        cooks.add(new Cook(1, "Pasta", "Italian pasta", "pasta, tomato sauce, cheese",
//                "boil pasta, add sauce, add cheese", "Italian", "pasta.jpg"));
//        cooks.add(new Cook(2, "Pizza", "Italian pizza", "dough, tomato sauce,cheese",
//                "make dough, add sauce, add cheese, bake", "Italian", "pizza.jpg"));
//        cooks.add(new Cook(3, "Sushi", "Japanese sushi", "rice, fish, seaweed",
//                "make rice, add fish, wrap in seaweed", "Japanese", "sushi.jpg"));
//    }
}
