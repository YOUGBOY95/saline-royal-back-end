package com.application.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pieces {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "piece_id", updatable = false, nullable = false)
    private Integer piece_id;

    private String name;

    private String description;

    private Integer composer_id;

    public Integer getPiece_id() {
        return piece_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getComposer_id() {
        return composer_id;
    }

    public void setComposer_id(Integer composer_id) {
        this.composer_id = composer_id;
    }
}
