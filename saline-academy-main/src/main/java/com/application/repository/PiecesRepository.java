package com.application.repository;

import org.springframework.data.repository.CrudRepository;
import com.application.model.Pieces;

public interface PiecesRepository extends CrudRepository<Pieces, Integer> {
}
