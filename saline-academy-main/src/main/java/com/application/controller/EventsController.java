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

import com.application.model.Events;
import com.application.repository.EventsRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(path = "/API")
public class EventsController {
    @Autowired

    private EventsRepository eventsRepository;

    @GetMapping(path = "/events")
    public @ResponseBody Iterable<Events> getAllEvents() {
        return eventsRepository.findAll();
    }

    @GetMapping(path = "/event/{id}")
    public @ResponseBody Optional<Events> getEvent(@PathVariable Integer id) {
        return eventsRepository.findById(id);
    }

    @PostMapping(path = "/event/create", consumes = { "*/*" })
    public Events addNewUser(@ModelAttribute Events body) {
        eventsRepository.save(body);
        return body;
    }

    @PutMapping(path = "/event/{id}/update", consumes = { "*/*" })
    public Events updateEvent(@PathVariable(value = "id") Integer id, @ModelAttribute Events body) {
        Events event = eventsRepository.findById(id).get();
        event.setDate(body.getDate());
        event.setRoom(body.getRoom());
        event.setTeacher_id(body.getTeacher_id());
        event.setStatus(body.getStatus());
        eventsRepository.save(event);
        return event;
    }

    @DeleteMapping(path = "/event/{id}/delete")
    public @ResponseBody String delEvent(@PathVariable(value = "id") Integer id) {
        Events event = eventsRepository.findById(id).get();
        eventsRepository.delete(event);
        return "L'évènement a bien été supprimé";
    }
}