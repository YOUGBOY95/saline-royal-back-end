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

import com.application.model.Comments;
import com.application.repository.CommentsRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(path = "/API")
public class CommentsController {
    @Autowired

    private CommentsRepository commentsRepository;

    @GetMapping(path = "/comments")
    public @ResponseBody Iterable<Comments> getAllComposers() {
        return commentsRepository.findAll();
    }

    @GetMapping(path = "/comment/{id}")
    public @ResponseBody Optional<Comments> getComposer(@PathVariable Integer id) {
        return commentsRepository.findById(id);
    }

    @PostMapping(path = "/comment/create", consumes = { "*/*" })
    public Comments addNewComposer(@ModelAttribute Comments body) {
        commentsRepository.save(body);
        return body;
    }

    @PutMapping(path = "/comment/{id}/update", consumes = { "*/*" })
    public Comments updateComposer(@PathVariable(value = "id") Integer id, @ModelAttribute Comments body) {
        Comments comment = commentsRepository.findById(id).get();
        comment.setUser_id(body.getUser_id());
        comment.setLesson_id(body.getLesson_id());
        comment.setContent(body.getContent());
        comment.setUpdated_at(body.getUpdated_at());
        commentsRepository.save(comment);
        return comment;
    }

    @DeleteMapping(path = "/comment/{id}/delete")
    public @ResponseBody String delComposer(@PathVariable(value = "id") Integer id) {
        Comments comment = commentsRepository.findById(id).get();
        commentsRepository.delete(comment);
        return "Le commentaire a bien été supprimé";
    }
}