package com.hexagonal.training.infrastructure.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "trainee")
@NoArgsConstructor
@AllArgsConstructor
public class TraineeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;
    @ManyToMany
    @JoinTable(name = "training_enrolment",
            joinColumns = @JoinColumn(name = "training_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "trainee_id", referencedColumnName = "id")
    )
    private List<TrainingEntity> trainingEntityList;
}
