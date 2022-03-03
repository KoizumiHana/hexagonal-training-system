package com.hexagonal.training.domain.ports.outcoming;

import com.hexagonal.training.domain.model.entity.Lesson;
import com.hexagonal.training.domain.model.entity.Trainee;
import com.hexagonal.training.domain.model.entity.Training;

import java.util.List;

public interface TrainingStorage {
    Training save(Training training);

    Training findById(Long id);

    List<Training> findAll();

    Long save(Lesson lesson);

    Trainee save(Trainee trainee);
}
