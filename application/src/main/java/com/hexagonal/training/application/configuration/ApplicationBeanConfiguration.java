package com.hexagonal.training.application.configuration;

import com.hexagonal.training.domain.ports.TrainingService;
import com.hexagonal.training.domain.ports.incoming.AddLessonUseCase;
import com.hexagonal.training.domain.ports.incoming.CreateTrainingUseCase;
import com.hexagonal.training.domain.ports.incoming.FindTrainingUseCase;
import com.hexagonal.training.domain.ports.outcoming.TrainingStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public CreateTrainingUseCase createTrainingUseCase(TrainingStorage trainingStorage) {
        return new TrainingService(trainingStorage);
    }

    @Bean
    public FindTrainingUseCase findTrainingUseCase(TrainingStorage trainingStorage) {
        return new TrainingService(trainingStorage);
    }

    @Bean
    public AddLessonUseCase addLessonUseCase(TrainingStorage trainingStorage) {
        return new TrainingService(trainingStorage);
    }
}
