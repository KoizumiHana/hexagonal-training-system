package com.hexagonal.training.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssignTraineeCommand {
    private String firstname;
    private String lastname;
    private String surname;
    private String email;
    private Long trainingId;
}
