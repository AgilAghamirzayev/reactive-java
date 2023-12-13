package com.mastercode.helper;

import static com.mastercode.utils.Util.faker;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
    private Integer userId;
    private String name;

    public User(int userId) {
        this.userId = userId;
        this.name = faker().name().username();
    }
}
