package com.application.repository;

import org.springframework.data.repository.CrudRepository;
import com.application.model.Teachers;

public interface TeachersRepository extends CrudRepository<Teachers, Integer> {
}
