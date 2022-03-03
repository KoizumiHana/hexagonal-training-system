package com.hexagonal.training.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Trainee {

    private Id id;
    private FullName fullName;
    private Email email;
    private List<Id> trainingIds;

    public Trainee(FullName fullName, Email email) {
        this.fullName = fullName;
        this.email = email;
    }
}
