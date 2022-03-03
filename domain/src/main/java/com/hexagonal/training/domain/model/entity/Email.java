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
public class Email {

    private String value;

    public static Email of(String email) {
        return new Email(email);

    }
}
