package com.mastercode.utils;

import com.github.javafaker.Faker;
import com.mastercode.helper.DefaultSubscriber;
import java.util.function.Consumer;
import lombok.SneakyThrows;
import org.reactivestreams.Subscriber;

public class Util {
    private static final Faker FAKER = Faker.instance();

    public static Consumer<Object> onNext() {
        return o -> {
            System.out.println("Received: " + o);
        };
    }

    public static Consumer<Throwable> onError() {
        return e -> {
            System.out.println("ERROR: " + e.getMessage());
            System.out.println("Thread:" + Thread.currentThread().getName());
        };
    }

    public static Runnable onCompleted() {
        return () -> {
            System.out.println("Completed");
            System.out.println("Thread:" + Thread.currentThread().getName());
        };
    }

    public static Subscriber<Object> subscriber() {
        return new DefaultSubscriber();
    }

    public static Subscriber<Object> subscriber(String name) {
        return new DefaultSubscriber(name);
    }

    public static Faker faker() {
        return FAKER;
    }

    public static void sleep(int seconds) {
        sleepMillis(seconds * 1000);
    }

    @SneakyThrows
    public static void sleepMillis(int milliseconds) {
        Thread.sleep(milliseconds);
    }
}
