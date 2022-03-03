package com.hexagonal.training.domain.ports.incoming;

import com.hexagonal.training.domain.model.AssignTraineeCommand;

public interface AssignTraineeUseCase {
    void handle(AssignTraineeCommand assignTraineeCommand);
}
