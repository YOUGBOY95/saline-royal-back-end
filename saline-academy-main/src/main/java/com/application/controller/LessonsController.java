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

import com.application.model.Lessons;
import com.application.repository.LessonsRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(path = "/API")
public class LessonsController {
    @Autowired

    private LessonsRepository lessonsRepository;

    @GetMapping(path = "/lessons")
    public @ResponseBody Iterable<Lessons> getAllLessons() {
        return lessonsRepository.findAll();
    }

    @GetMapping(path = "/lesson/{id}")
    public @ResponseBody Optional<Lessons> getLesson(@PathVariable Integer id) {
        return lessonsRepository.findById(id);
    }

    @PostMapping(path = "/lesson/create", consumes = { "*/*" })
    public Lessons addNewLesson(@ModelAttribute Lessons body) {
        lessonsRepository.save(body);
        return body;
    }

    @PutMapping(path = "/lesson/{id}/update", consumes = { "*/*" })
    public Lessons updateLesson(@PathVariable(value = "id") Integer id, @ModelAttribute Lessons body) {
        Lessons lesson = lessonsRepository.findById(id).get();
        lesson.setTitle(body.getTitle());
        lesson.setDate(body.getDate());
        lesson.setSubtitle_id(body.getSubtitle_id());
        lesson.setTeacher_id(body.getTeacher_id());
        lesson.setComposer_id(body.getComposer_id());
        lesson.setInstrument_id(body.getInstrument_id());
        lesson.setImage(body.getImage());
        lesson.setStatus(body.getStatus());
        lessonsRepository.save(lesson);
        return lesson;
    }

    @DeleteMapping(path = "/lesson/{id}/delete")
    public @ResponseBody String delLesson(@PathVariable(value = "id") Integer id) {
        Lessons event = lessonsRepository.findById(id).get();
        lessonsRepository.delete(event);
        return "Le cours a bien été supprimé";
    }
}