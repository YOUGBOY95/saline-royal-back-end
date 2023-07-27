package com.application.repository;

import org.springframework.data.repository.CrudRepository;
import com.application.model.Comments;

public interface CommentsRepository extends CrudRepository<Comments, Integer> {
}