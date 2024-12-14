package com.example.cookz.cook;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/1")
    Cook findById() {
        return cookRepository.findById(1);
    }
    // this is a rest controller, response is in form of json for example.
}
