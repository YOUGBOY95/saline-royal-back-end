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

import com.application.model.Subtitles;
import com.application.repository.SubtitlesRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(path = "/API")
public class SubtitlesController {
    @Autowired

    private SubtitlesRepository subtitlesRepository;

    @GetMapping(path = "/subtitles")
    public @ResponseBody Iterable<Subtitles> getAllPieces() {
        return subtitlesRepository.findAll();
    }

    @GetMapping(path = "/subtitle/{id}")
    public @ResponseBody Optional<Subtitles> getEvent(@PathVariable Integer id) {
        return subtitlesRepository.findById(id);
    }

    @PostMapping(path = "/subtitle/create", consumes = { "*/*" })
    public Subtitles addNewUser(@ModelAttribute Subtitles body) {
        subtitlesRepository.save(body);
        return body;
    }

    @PutMapping(path = "/subtitle/{id}/update", consumes = { "*/*" })
    public Subtitles updateEvent(@PathVariable(value = "id") Integer id, @ModelAttribute Subtitles body) {
        Subtitles subtitle = subtitlesRepository.findById(id).get();
        subtitle.setLanguage(body.getLanguage());
        subtitle.setLesson_id(body.getLesson_id());
        subtitle.setStatus(body.getStatus());
        subtitlesRepository.save(subtitle);
        return subtitle;
    }

    @DeleteMapping(path = "/subtitle/{id}/delete")
    public @ResponseBody String delEvent(@PathVariable(value = "id") Integer id) {
        Subtitles subtitle = subtitlesRepository.findById(id).get();
        subtitlesRepository.delete(subtitle);
        return "Le fichier de sous-titrage a bien été supprimé";
    }
}