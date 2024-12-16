package com.example.cookz.cook;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface CookRepository extends ListCrudRepository<Cook, Integer> {
    @Query
    List<Cook> findByName(String name);
}
