package com.hexagonal.training.infrastructure.configuration;

import com.hexagonal.training.domain.ports.outcoming.TrainingStorage;
import com.hexagonal.training.infrastructure.persistence.LessonRepository;
import com.hexagonal.training.infrastructure.persistence.TraineeRepository;
import com.hexagonal.training.infrastructure.persistence.TrainingDatabaseAdapter;
import com.hexagonal.training.infrastructure.persistence.TrainingRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.hexagonal.training.infrastructure.persistence")
@EntityScan("com.hexagonal.training.infrastructure.persistence")
public class InfrastructureBeanConfiguration {

    @Bean
    public TrainingStorage trainingStorage(TrainingRepository trainingRepository,
                                           LessonRepository lessonRepository,
                                           TraineeRepository traineeRepository) {
        return new TrainingDatabaseAdapter(trainingRepository, lessonRepository, traineeRepository);
    }
}
