package com.mastercode.utils;

import com.github.javafaker.Faker;

import java.util.function.Consumer;
import lombok.SneakyThrows;

public class Util {
    private static final Faker FAKER = Faker.instance();

    public static Consumer<Object> onNext() {
        return o -> System.out.println("Received: " + o);
    }

    public static Consumer<Throwable> onError() {
        return e -> System.out.println("ERROR: " + e.getMessage());
    }

    public static Runnable onCompleted() {
        return () -> System.out.println("Completed");
    }

    public static Faker faker() {
        return FAKER;
    }

    @SneakyThrows
    public static void sleep(int seconds) {
        Thread.sleep(seconds * 1000L);
    }
}
