package com.application.repository;

import org.springframework.data.repository.CrudRepository;
import com.application.model.Composers;

public interface ComposersRepository extends CrudRepository<Composers, Integer> {
}
