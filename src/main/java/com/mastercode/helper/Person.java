package com.mastercode.helper;

import lombok.Data;
import lombok.ToString;

import static com.mastercode.utils.Util.faker;

@Data
@ToString
public class Person {
    private String name;
    private Integer age;

    public Person() {
        this.name = faker().name().firstName();
        this.age = faker().number().numberBetween(10, 55);
    }
}
