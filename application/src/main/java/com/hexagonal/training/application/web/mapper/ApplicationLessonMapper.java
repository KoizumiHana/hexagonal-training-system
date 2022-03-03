package com.hexagonal.training.application.web.mapper;

import com.hexagonal.training.application.web.response.LessonResponse;
import com.hexagonal.training.domain.model.entity.Lesson;

public class ApplicationLessonMapper {
    public static LessonResponse businessEntityToResponse(Lesson lesson) {
        return new LessonResponse(lesson.getId().getValue(),
                lesson.getTopicName().getValue(),
                lesson.getLessonTime(),
                lesson.getTrainingId().getValue());
    }
}
