package com.application.repository;

import org.springframework.data.repository.CrudRepository;
import com.application.model.Instruments;

public interface InstrumentsRepository extends CrudRepository<Instruments, Integer> {
}
