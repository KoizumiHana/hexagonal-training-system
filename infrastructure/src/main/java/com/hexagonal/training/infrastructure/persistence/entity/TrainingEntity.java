package com.hexagonal.training.infrastructure.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "training")
@NamedEntityGraph(name = "training-with-lessons", attributeNodes = @NamedAttributeNode("lessonEntities"))
@NoArgsConstructor
@AllArgsConstructor
public class TrainingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL)
    private List<LessonEntity> lessonEntities;
    @ManyToMany(mappedBy = "trainingEntityList")
    private List<TraineeEntity> traineeEntities;

    public TrainingEntity(Long id) {
        this.id = id;
    }
}
