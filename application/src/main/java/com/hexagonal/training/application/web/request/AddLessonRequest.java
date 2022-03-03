package com.hexagonal.training.application.web.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AddLessonRequest {
    private String topicName;
    private LocalDateTime lessonTime;
}
