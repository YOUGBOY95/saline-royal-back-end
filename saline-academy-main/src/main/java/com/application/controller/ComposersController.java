package com.application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.model.Composers;
import com.application.repository.ComposersRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(path = "/API")
public class ComposersController {
    @Autowired

    private ComposersRepository composersRepository;

    @GetMapping(path = "/composers")
    public @ResponseBody Iterable<Composers> getAllComposers() {
        return composersRepository.findAll();
    }

    @GetMapping(path = "/composer/{id}")
    public @ResponseBody Optional<Composers> getComposer(@PathVariable Integer id) {
        return composersRepository.findById(id);
    }

    @PostMapping(path = "/composer/create", consumes = { "*/*" })
    public Composers addNewComposer(@ModelAttribute Composers body) {
        composersRepository.save(body);
        return body;
    }

    @PutMapping(path = "/composer/{id}/update", consumes = { "*/*" })
    public Composers updateComposer(@PathVariable(value = "id") Integer id, @ModelAttribute Composers body) {
        Composers composer = composersRepository.findById(id).get();
        composer.setFirstname(body.getFirstname());
        composer.setLastname(body.getLastname());
        composer.setDescription(body.getDescription());
        composersRepository.save(composer);
        return composer;
    }

    @DeleteMapping(path = "/composer/{id}/delete")
    public @ResponseBody String delComposer(@PathVariable(value = "id") Integer id) {
        Composers composer = composersRepository.findById(id).get();
        composersRepository.delete(composer);
        return "Le compositeur a bien été supprimé";
    }
}