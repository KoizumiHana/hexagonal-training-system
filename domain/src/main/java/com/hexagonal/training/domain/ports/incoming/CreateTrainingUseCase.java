package com.hexagonal.training.domain.ports.incoming;

import com.hexagonal.training.domain.model.CreateTrainingCommand;
import com.hexagonal.training.domain.model.entity.Training;

public interface CreateTrainingUseCase {
    Training handle(CreateTrainingCommand createTrainingCommand);
}


