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

import com.application.model.Pieces;
import com.application.repository.PiecesRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(path = "/API")
public class PiecesController {
    @Autowired

    private PiecesRepository piecesRepository;

    @GetMapping(path = "/pieces")
    public @ResponseBody Iterable<Pieces> getAllPieces() {
        return piecesRepository.findAll();
    }

    @GetMapping(path = "/piece/{id}")
    public @ResponseBody Optional<Pieces> getPiece(@PathVariable Integer id) {
        return piecesRepository.findById(id);
    }

    @PostMapping(path = "/piece/create", consumes = { "*/*" })
    public Pieces addNewPiece(@ModelAttribute Pieces body) {
        piecesRepository.save(body);
        return body;
    }

    @PutMapping(path = "/piece/{id}/update", consumes = { "*/*" })
    public Pieces updatePiece(@PathVariable(value = "id") Integer id, @ModelAttribute Pieces body) {
        Pieces piece = piecesRepository.findById(id).get();
        piece.setName(body.getName());
        piece.setDescription(body.getDescription());
        piece.setComposer_id(body.getComposer_id());
        piecesRepository.save(piece);
        return piece;
    }

    @DeleteMapping(path = "/piece/{id}/delete")
    public @ResponseBody String delPiece(@PathVariable(value = "id") Integer id) {
        Pieces piece = piecesRepository.findById(id).get();
        piecesRepository.delete(piece);
        return "Le morceau a bien été supprimé";
    }
}