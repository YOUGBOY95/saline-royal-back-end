package com.application.repository;

import org.springframework.data.repository.CrudRepository;
import com.application.model.Lessons;

public interface LessonsRepository extends CrudRepository<Lessons, Integer> {
}
