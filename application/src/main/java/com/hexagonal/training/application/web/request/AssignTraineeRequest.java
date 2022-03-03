package com.hexagonal.training.application.web.request;

import lombok.Getter;

@Getter
public class AssignTraineeRequest {
    private String firstname;
    private String lastname;
    private String surname;
    private String email;
}
