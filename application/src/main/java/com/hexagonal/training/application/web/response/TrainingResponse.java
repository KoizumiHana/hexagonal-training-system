package com.hexagonal.training.application.web.response;

import java.util.List;

public record TrainingResponse(
        Long id,
        String name,
        String description,
        List<LessonResponse> lessons
) {
}
