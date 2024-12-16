package com.example.cookz.cook;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.asm.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

//inject into the constructor the repository.
@Component //to make spring be aware of it to run it.
public class CookJsonLoader implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(CookJsonLoader.class);
    private final JdbcClientCookRepository cookRepository;
    private final ObjectMapper objectMapper;
    public CookJsonLoader(JdbcClientCookRepository cookRepository, ObjectMapper objectMapper){
        this.cookRepository = cookRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if(cookRepository.count() == 0){
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/cooks.json")){
                //deserialize json into objects into a list of cooks
                Cooks allCooks = objectMapper.readValue(inputStream, Cooks.class);
                log.info("Reading cooks from json data and saving to in memory collection", allCooks.cooks().size());
                cookRepository.saveAll(allCooks.cooks()); //persist these off to the db.
            } catch(IOException e){
                throw new RuntimeException("Failed to read json data.", e);
            }
        }
        else {
            log.info("Not loading cooks from json data bc collection contains data.");
        }
    }
}
