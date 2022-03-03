package com.hexagonal.training.domain.ports;

import com.hexagonal.training.domain.model.AddLessonCommand;
import com.hexagonal.training.domain.model.AssignTraineeCommand;
import com.hexagonal.training.domain.model.CreateTrainingCommand;
import com.hexagonal.training.domain.model.entity.*;
import com.hexagonal.training.domain.ports.incoming.AddLessonUseCase;
import com.hexagonal.training.domain.ports.incoming.AssignTraineeUseCase;
import com.hexagonal.training.domain.ports.incoming.CreateTrainingUseCase;
import com.hexagonal.training.domain.ports.incoming.FindTrainingUseCase;
import com.hexagonal.training.domain.ports.outcoming.TrainingStorage;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class TrainingService implements CreateTrainingUseCase, FindTrainingUseCase, AddLessonUseCase, AssignTraineeUseCase {

    private final TrainingStorage trainingStorage;

    @Override
    public Training handle(CreateTrainingCommand createTrainingCommand) {
        var training = Training.builder()
                .name(Name.of(createTrainingCommand.getName()))
                .description(Description.of(createTrainingCommand.getDescription())).build();
        return trainingStorage.save(training);
    }

    @Override
    public Training byId(Long id) {
        return trainingStorage.findById(id);
    }

    @Override
    public List<Training> all() {
        return trainingStorage.findAll();
    }

    @Override
    public void handle(AddLessonCommand addLessonCommand) {
        var training = trainingStorage.findById(addLessonCommand.getTrainingId());
        var lesson = Lesson.builder()
                .topicName(TopicName.of(addLessonCommand.getTopicName()))
                .lessonTime(addLessonCommand.getLessonTime())
                .trainingId(Id.of(addLessonCommand.getTrainingId()))
                .build();
        training.addLesson(lesson);
        trainingStorage.save(training);
    }

    @Override
    public void handle(AssignTraineeCommand assignTraineeCommand) {
        var training = trainingStorage.findById(assignTraineeCommand.getTrainingId());
        var trainee = new Trainee();
    }
}
