package com.hexagonal.training.infrastructure.persistence;

import com.hexagonal.training.domain.model.entity.Lesson;
import com.hexagonal.training.domain.model.entity.Trainee;
import com.hexagonal.training.domain.model.entity.Training;
import com.hexagonal.training.domain.ports.outcoming.TrainingStorage;
import com.hexagonal.training.infrastructure.mapper.InfrastructureLessonMapper;
import com.hexagonal.training.infrastructure.mapper.InfrastructureTraineeMapper;
import com.hexagonal.training.infrastructure.mapper.InfrastructureTrainingMapper;
import com.hexagonal.training.infrastructure.persistence.entity.TraineeEntity;
import com.hexagonal.training.infrastructure.persistence.entity.TrainingEntity;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor
public class TrainingDatabaseAdapter implements TrainingStorage {

    private final TrainingRepository trainingRepository;
    private final LessonRepository lessonRepository;
    private final TraineeRepository traineeRepository;

    @Override
    public Training save(Training training) {
        TrainingEntity entity = InfrastructureTrainingMapper.businessEntityToJpaEntity(training);
        return InfrastructureTrainingMapper.jpaEntityToBusinessEntity(trainingRepository.save(entity));
    }

    @Override
    public Training findById(Long id) {
        return trainingRepository.findById(id)
                .map(InfrastructureTrainingMapper::jpaEntityToBusinessEntity)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Training> findAll() {
        return trainingRepository.findAll().stream()
                .map(InfrastructureTrainingMapper::jpaEntityToBusinessEntity)
                .toList();
    }

    @Override
    public Long save(Lesson lesson) {
        return lessonRepository.save(InfrastructureLessonMapper.businessEntityToJpaEntity(lesson)).getId();
    }

    @Override
    public Trainee save(Trainee trainee) {
        TraineeEntity traineeEntity = InfrastructureTraineeMapper.businessEntityToJpaEntity(trainee);
        return InfrastructureTraineeMapper.jpaEntityToBusinessEntity(traineeRepository.save(traineeEntity));
    }
}
