package com.application.repository;

import org.springframework.data.repository.CrudRepository;
import com.application.model.Events;

public interface EventsRepository extends CrudRepository<Events, Integer> {
}
