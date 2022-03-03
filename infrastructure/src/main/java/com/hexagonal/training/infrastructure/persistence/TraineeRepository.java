package com.hexagonal.training.infrastructure.persistence;

import com.hexagonal.training.infrastructure.persistence.entity.TraineeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraineeRepository extends JpaRepository<TraineeEntity, Long> {
}
