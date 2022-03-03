package com.hexagonal.training.domain.ports.incoming;

import com.hexagonal.training.domain.model.AddLessonCommand;

public interface AddLessonUseCase {
    void handle(AddLessonCommand addLessonCommand);
}
