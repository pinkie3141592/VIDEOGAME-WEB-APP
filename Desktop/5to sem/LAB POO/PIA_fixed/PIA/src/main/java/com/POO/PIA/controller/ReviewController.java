package com.POO.PIA.controller;

import com.POO.PIA.model.Review;
import com.POO.PIA.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    
    @Autowired
    private ReviewRepository repository;

    @GetMapping
    public List<Review> getAll(){
        return repository.findAll();
    }

    @PostMapping
    public Review create(@RequestBody Review review){
        return repository.save(review);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        repository.deleteById(id);
    }

}
