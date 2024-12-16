package com.example.cookz.cook;

import java.util.*;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//we will build a crud rest API
// in memory representation.
@RestController
@RequestMapping("/api/cooks") // every mapping starts with /api/cooks
// controller takes requests and returns responses.
public class CookController{
    // but we'll place the list in a repository.
    // private List<Cook> cooks = new ArrayList<>();

    private final JdbcClientCookRepository cookRepository;
    private final CookRepository cookRepository1;
    // @Autowired //field injection.its not recommended to use field injection bc of
    // testing.

    public CookController(JdbcClientCookRepository cookRepository) {
        this.cookRepository = cookRepository;
    }

    @GetMapping("")
    List<Cook> findAll() {
        return cookRepository.findAll();
    }

    // // Path variable passes the id dynamically from the parameters.
     @GetMapping("/{id}")
     Cook findById(@PathVariable int id) {

     Optional<Cook> cook = cookRepository.findById(id);
     if (cook.isEmpty()) {
     // to throw an exception, we use response status exception.
     throw new CookNotFoundException();
     }
     return cook.get();

     }

    // // post
    // // to test it we can use command line or postman or thunderclient.
    // // coming from the request body, we are creating a new cook.
    // // to tell springboot its a request body, we use @RequestBody
    // @PostMapping("") // will make the post request to be allowed.
    // @ResponseStatus(HttpStatus.CREATED) // to return 201 status code.
    // // valid makes sure the object is valid. else, it will throw rexception 404
     void create(@Valid @RequestBody Cook cook) {
     cookRepository.create(cook);
     }

    // // put
     @PutMapping("/{id}")
    // @ResponseStatus(HttpStatus.NO_CONTENT)
     // valid makes sure the object is valid. else, it will throw rexception 404
     void update(@Valid @RequestBody Cook cook, @PathVariable int id) {
     cookRepository.update(cook, id);
     }

    // // delete
     @DeleteMapping("/{id}")
     @ResponseStatus(HttpStatus.NO_CONTENT)
     void delete(@PathVariable int id) {
     cookRepository.delete(id);
     }

     @GetMapping("/name/{name}")
        List<Cook> findByName(@PathVariable String name) {
            return cookRepository1.findByName(name);
        }
    // // this is a rest controller, response is in form of json for example.
}
