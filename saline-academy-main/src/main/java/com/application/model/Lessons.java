package com.application.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Lessons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id", updatable = false, nullable = false)
    private Integer lesson_id;

    private String title;

    private String date;

    private Integer subtitle_id;

    private Integer teacher_id;

    private Integer composer_id;

    private Integer instrument_id;

    private String image;

    private String status;

    public Integer getLesson_id() {
        return lesson_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getSubtitle_id() {
        return subtitle_id;
    }

    public void setSubtitle_id(Integer subtitle_id) {
        this.subtitle_id = subtitle_id;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Integer getComposer_id() {
        return composer_id;
    }

    public void setComposer_id(Integer composer_id) {
        this.composer_id = composer_id;
    }

    public Integer getInstrument_id() {
        return instrument_id;
    }

    public void setInstrument_id(Integer instrument_id) {
        this.instrument_id = instrument_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
