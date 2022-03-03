package com.hexagonal.training.domain.ports.incoming;

import com.hexagonal.training.domain.model.entity.Training;

import java.util.List;

public interface FindTrainingUseCase {
    Training byId(Long id);

    List<Training> all();
}
