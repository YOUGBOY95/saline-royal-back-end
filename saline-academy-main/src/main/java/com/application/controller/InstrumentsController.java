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

import com.application.model.Instruments;
import com.application.repository.InstrumentsRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(path = "/API")
public class InstrumentsController {
    @Autowired

    private InstrumentsRepository instrumentsRepository;

    @GetMapping(path = "/instruments")
    public @ResponseBody Iterable<Instruments> getAllInstruments() {
        return instrumentsRepository.findAll();
    }

    @GetMapping(path = "/instrument/{id}")
    public @ResponseBody Optional<Instruments> getInstrument(@PathVariable Integer id) {
        return instrumentsRepository.findById(id);
    }

    @PostMapping(path = "/instrument/create", consumes = { "*/*" })
    public Instruments addNewInstrument(@ModelAttribute Instruments body) {
        instrumentsRepository.save(body);
        return body;
    }

    @PutMapping(path = "/instrument/{id}/update", consumes = { "*/*" })
    public Instruments updateInstrument(@PathVariable(value = "id") Integer id, @ModelAttribute Instruments body) {
        Instruments instrument = instrumentsRepository.findById(id).get();
        instrument.setName(body.getName());
        instrumentsRepository.save(instrument);
        return instrument;
    }

    @DeleteMapping(path = "/instrument/{id}/delete")
    public @ResponseBody String delInstrument(@PathVariable(value = "id") Integer id) {
        Instruments event = instrumentsRepository.findById(id).get();
        instrumentsRepository.delete(event);
        return "L'instrument a bien été supprimé";
    }
}