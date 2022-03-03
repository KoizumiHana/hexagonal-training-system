package com.hexagonal.training.infrastructure.mapper;

import com.hexagonal.training.domain.model.entity.Email;
import com.hexagonal.training.domain.model.entity.FullName;
import com.hexagonal.training.domain.model.entity.Id;
import com.hexagonal.training.domain.model.entity.Trainee;
import com.hexagonal.training.infrastructure.persistence.entity.TraineeEntity;
import com.hexagonal.training.infrastructure.persistence.entity.TrainingEntity;

import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class InfrastructureTraineeMapper {

    public static Trainee jpaEntityToBusinessEntity(TraineeEntity traineeEntity) {
        return new Trainee(Id.of(traineeEntity.getId()),
                FullName.of(traineeEntity.getFirstname(), traineeEntity.getLastname(), traineeEntity.getSurname()),
                Email.of(traineeEntity.getEmail()),
                traineeEntity.getTrainingEntityList().stream()
                        .map(TrainingEntity::getId)
                        .map(Id::of)
                        .collect(toList()));
    }

    public static TraineeEntity businessEntityToJpaEntity(Trainee trainee) {
        return new TraineeEntity(Optional.ofNullable(trainee.getId()).map(Id::getValue).orElse(null),
                trainee.getFullName().getFirstname(),
                trainee.getFullName().getLastname(),
                trainee.getFullName().getSurname(),
                trainee.getEmail().getValue(),
                trainee.getTrainingIds().stream().map(id -> new TrainingEntity(id.getValue())).collect(toList())
        );
    }
}
