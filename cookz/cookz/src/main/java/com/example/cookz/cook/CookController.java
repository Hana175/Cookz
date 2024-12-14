package com.example.cookz.cook;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

//we will build a crud rest API
// in memory representation.
@RestController
@RequestMapping("/api/cooks") // every mapping starts with /api/cooks
// controller takes requests and returns responses.
public class CookController {
    // but we'll place the list in a repository.
    // private List<Cook> cooks = new ArrayList<>();

    private final CookRepository cookRepository;

    // @Autowired //field injection.its not recommended to use field injection bc of
    // testing.

    public CookController(CookRepository cookRepository) {
        this.cookRepository = cookRepository;
    }

    @GetMapping("")
    List<Cook> findAll() {
        return cookRepository.findAll();
    }

    // Path variable passes the id dynamically from the parameters.
    @GetMapping("/{id}")
    Cook findById(@PathVariable int id) {

        Optional<Cook> cook = cookRepository.findById(id);
        if (cook.isEmpty()) {
            // to throw an exception, we use response status exception.
            throw new CookNotFoundException();
        }
        return cook.get();

    }

    // post
    // to test it we can use command line or postman or thunderclient.
    // coming from the request body, we are creating a new cook.
    // to tell springboot its a request body, we use @RequestBody
    @PostMapping("") // will make the post request to be allowed.
    @ResponseStatus(HttpStatus.CREATED) // to return 201 status code.
    // valid makes sure the object is valid. else, it will throw rexception 404
    void create(@Valid @RequestBody Cook cook) {
        cookRepository.create(cook);
    }

    // put
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    // valid makes sure the object is valid. else, it will throw rexception 404

    void update(@Valid @RequestBody Cook cook, @PathVariable int id) {
        cookRepository.update(cook, id);
    }

    // delete
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable int id) {
        cookRepository.delete(id);
    }
    // this is a rest controller, response is in form of json for example.
}
