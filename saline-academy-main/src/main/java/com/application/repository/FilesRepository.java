package com.application.repository;

import org.springframework.data.repository.CrudRepository;
import com.application.model.Files;

public interface FilesRepository extends CrudRepository<Files, Integer> {
}
