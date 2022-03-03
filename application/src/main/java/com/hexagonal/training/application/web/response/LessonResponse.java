package com.hexagonal.training.application.web.response;

import java.time.LocalDateTime;

public record LessonResponse(
        Long id,
        String topicName,
        LocalDateTime lessonTime,
        Long trainingId
) {
}
