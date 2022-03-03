package com.hexagonal.training.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddLessonCommand {
    private Long trainingId;
    private String topicName;
    private LocalDateTime lessonTime;
}
