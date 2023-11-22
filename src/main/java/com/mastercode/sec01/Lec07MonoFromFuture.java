package com.mastercode.sec01;

import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

import static com.mastercode.utils.Util.faker;
import static com.mastercode.utils.Util.onNext;

public class Lec07MonoFromFuture {
    public static void main(String[] args) {
        Mono.fromFuture(getName()).subscribe(onNext());
    }

    private static CompletableFuture<String> getName() {
        return  CompletableFuture.supplyAsync(() -> faker().name().fullName());
    }
}
