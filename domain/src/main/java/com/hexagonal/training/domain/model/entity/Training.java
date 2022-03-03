package com.hexagonal.training.domain.model.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Training {
    private Id id;
    private Name name;
    private Description description;
    private List<Lesson> lessons = new ArrayList<>();
    private List<Trainee> trainees = new ArrayList<>();

    @Builder
    private Training(final Name name, final Description description) {
        this.name = name;
        this.description = description;
    }

    public Training(final Id id, final Name name, final Description description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public void addLesson(Lesson lesson) {
        this.lessons.add(lesson);
    }

    public void assignTrainee(Trainee trainee) {
        this.trainees.add(trainee);
    }
}
