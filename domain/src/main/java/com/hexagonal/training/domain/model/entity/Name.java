package com.hexagonal.training.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Name {

    private final String value;

    public static Name of(final String name) {
        //todo some validation here
        return new Name(name);
    }
}
