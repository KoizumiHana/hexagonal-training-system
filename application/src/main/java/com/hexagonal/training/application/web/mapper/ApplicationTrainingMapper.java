package com.hexagonal.training.application.web.mapper;

import com.hexagonal.training.application.web.response.TrainingResponse;
import com.hexagonal.training.domain.model.entity.Training;

public class ApplicationTrainingMapper {
    public static TrainingResponse businessEntityToResponse(Training training) {
        return new TrainingResponse(training.getId().getValue(),
                training.getName().getValue(),
                training.getDescription().getValue(),
                training.getLessons().stream().map(ApplicationLessonMapper::businessEntityToResponse).toList());
    }
}
