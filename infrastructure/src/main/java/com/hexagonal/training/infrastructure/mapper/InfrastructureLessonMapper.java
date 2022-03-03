package com.hexagonal.training.infrastructure.mapper;

import com.hexagonal.training.domain.model.entity.Id;
import com.hexagonal.training.domain.model.entity.Lesson;
import com.hexagonal.training.domain.model.entity.TopicName;
import com.hexagonal.training.infrastructure.persistence.entity.LessonEntity;
import com.hexagonal.training.infrastructure.persistence.entity.TrainingEntity;

import java.util.Optional;


public class InfrastructureLessonMapper {

    public static Lesson jpaEntityToBusinessEntity(LessonEntity lessonEntity) {
        return new Lesson(Id.of(lessonEntity.getId()),
                TopicName.of(lessonEntity.getTopicName()),
                lessonEntity.getLessonTime(),
                Id.of(lessonEntity.getTraining().getId()));
    }

    public static LessonEntity businessEntityToJpaEntity(Lesson lesson) {
        return new LessonEntity(Optional.ofNullable(lesson.getId()).map(Id::getValue).orElse(null),
                lesson.getTopicName().getValue(),
                lesson.getLessonTime(),
                new TrainingEntity(lesson.getTrainingId().getValue()));
    }
}
