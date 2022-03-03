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
public class TopicName {

    private final String value;

    public static TopicName of(final String topicName) {
        //todo some validation here
        return new TopicName(topicName);
    }
}
