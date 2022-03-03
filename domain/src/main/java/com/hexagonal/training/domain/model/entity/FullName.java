package com.hexagonal.training.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import static lombok.AccessLevel.PRIVATE;

@ToString
@Getter
@EqualsAndHashCode
@AllArgsConstructor(access = PRIVATE)
public class FullName {
    private String firstname;
    private String lastname;
    private String surname;

    public static FullName of(String firstname, String lastname, String surname) {
        return new FullName(firstname, lastname, surname);
    }
}
