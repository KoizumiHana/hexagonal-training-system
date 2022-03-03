package com.hexagonal.training.infrastructure.persistence;

import com.hexagonal.training.infrastructure.persistence.entity.TrainingEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<TrainingEntity, Long> {
    @EntityGraph("training-with-lessons")
    List<TrainingEntity> findAll();
}
