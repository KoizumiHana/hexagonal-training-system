package com.hexagonal.training.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Id {
    private final Long value;

    public static Id of(final Long id) {
        //todo validation of id parameter here
        return new Id(id);
    }
}
