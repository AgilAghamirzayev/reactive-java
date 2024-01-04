package com.mastercode.sec11.assignment;

import lombok.Builder;
import lombok.Data;

import java.util.function.Consumer;

@Data
@Builder
public class SlackMember {
    private String name;
    private Consumer<String> messageConsumer;

    public void receives(String message) {
        System.out.println(message);
    }

    public void says(String message) {
        messageConsumer.accept(message);
    }
}
