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

import com.application.model.Teachers;
import com.application.repository.TeachersRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(path = "/API")
public class TeachersController {
    @Autowired

    private TeachersRepository teachersRepository;

    @GetMapping(path = "/teachers")
    public @ResponseBody Iterable<Teachers> getAllPieces() {
        return teachersRepository.findAll();
    }

    @GetMapping(path = "/teacher/{id}")
    public @ResponseBody Optional<Teachers> getEvent(@PathVariable Integer id) {
        return teachersRepository.findById(id);
    }

    @PostMapping(path = "/teacher/create", consumes = { "*/*" })
    public Teachers addNewUser(@ModelAttribute Teachers body) {
        teachersRepository.save(body);
        return body;
    }

    @PutMapping(path = "/teacher/{id}/update", consumes = { "*/*" })
    public Teachers updateEvent(@PathVariable(value = "id") Integer id, @ModelAttribute Teachers body) {
        Teachers teacher = teachersRepository.findById(id).get();
        teacher.setFirstname(body.getFirstname());
        teacher.setLastname(body.getLastname());
        teacher.setEmail(body.getEmail());
        teacher.setBiography(body.getBiography());
        teacher.setInstrument_id(body.getInstrument_id());
        teachersRepository.save(teacher);
        return teacher;
    }

    @DeleteMapping(path = "/teacher/{id}/delete")
    public @ResponseBody String delEvent(@PathVariable(value = "id") Integer id) {
        Teachers teacher = teachersRepository.findById(id).get();
        teachersRepository.delete(teacher);
        return "Le professeur a bien été supprimé";
    }
}