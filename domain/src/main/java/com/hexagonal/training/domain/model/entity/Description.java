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
public class Description {

    private final String value;

    public static Description of(final String description) {
        //todo some validation here
        return new Description(description);
    }
}
