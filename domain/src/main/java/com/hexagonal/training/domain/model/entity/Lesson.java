package com.hexagonal.training.domain.model.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Lesson {
    private Id id;
    private TopicName topicName;
    private LocalDateTime lessonTime;
    private Id trainingId;

    @Builder
    private Lesson(TopicName topicName, LocalDateTime lessonTime, Id trainingId) {
        this.topicName = topicName;
        this.lessonTime = lessonTime;
        this.trainingId = trainingId;
    }
}

