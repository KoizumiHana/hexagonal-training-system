package com.hexagonal.training.infrastructure.mapper;

import com.hexagonal.training.domain.model.entity.Description;
import com.hexagonal.training.domain.model.entity.Id;
import com.hexagonal.training.domain.model.entity.Name;
import com.hexagonal.training.domain.model.entity.Training;
import com.hexagonal.training.infrastructure.persistence.entity.TrainingEntity;

import java.util.Optional;

import static java.util.stream.Collectors.toList;


public class InfrastructureTrainingMapper {

    public static Training jpaEntityToBusinessEntity(TrainingEntity trainingEntity) {
        return new Training(Id.of(trainingEntity.getId()),
                Name.of(trainingEntity.getName()),
                Description.of(trainingEntity.getDescription()),
                trainingEntity.getLessonEntities().stream().map(InfrastructureLessonMapper::jpaEntityToBusinessEntity).collect(toList()),
                trainingEntity.getTraineeEntities().stream().map(InfrastructureTraineeMapper::jpaEntityToBusinessEntity).collect(toList()));
    }


    public static TrainingEntity businessEntityToJpaEntity(Training training) {
        return new TrainingEntity(Optional.ofNullable(training.getId()).map(Id::getValue).orElse(null),
                training.getName().getValue(),
                training.getDescription().getValue(),
                training.getLessons().stream().map(InfrastructureLessonMapper::businessEntityToJpaEntity).collect(toList()),
                training.getTrainees().stream().map(InfrastructureTraineeMapper::businessEntityToJpaEntity).collect(toList()));
    }

}
