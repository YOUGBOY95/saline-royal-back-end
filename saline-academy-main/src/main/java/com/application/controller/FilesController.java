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

import com.application.model.Files;
import com.application.repository.FilesRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(path = "/API")
public class FilesController {
    @Autowired

    private FilesRepository filesRepository;

    @GetMapping(path = "/files")
    public @ResponseBody Iterable<Files> getAllFiles() {
        return filesRepository.findAll();
    }

    @GetMapping(path = "/file/{id}")
    public @ResponseBody Optional<Files> getFile(@PathVariable Integer id) {
        return filesRepository.findById(id);
    }

    @PostMapping(path = "/file/create", consumes = { "*/*" })
    public Files addNewFile(@ModelAttribute Files body) {
        filesRepository.save(body);
        return body;
    }

    @PutMapping(path = "/file/{id}/update", consumes = { "*/*" })
    public Files updateFile(@PathVariable(value = "id") Integer id, @ModelAttribute Files body) {
        Files file = filesRepository.findById(id).get();
        file.setType(body.getType());
        file.setUrl(body.getUrl());
        file.setDate(body.getDate());
        file.setEvent_id(body.getEvent_id());
        file.setLesson_id(body.getLesson_id());
        file.setStatus(body.getStatus());
        filesRepository.save(file);
        return file;
    }

    @DeleteMapping(path = "/file/{id}/delete")
    public @ResponseBody String delFile(@PathVariable(value = "id") Integer id) {
        Files composer = filesRepository.findById(id).get();
        filesRepository.delete(composer);
        return "Le document a bien été supprimé";
    }
}