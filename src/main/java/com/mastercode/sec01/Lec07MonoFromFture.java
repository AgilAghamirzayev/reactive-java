package com.mastercode.sec01;

import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

import static com.mastercode.utils.Util.faker;
import static com.mastercode.utils.Util.onNext;
import static com.mastercode.utils.Util.sleep;

public class Lec07MonoFromFture {
    public static void main(String[] args) {
        Mono.fromFuture(getName()).subscribe(onNext());
    }

    private static CompletableFuture<String> getName() {
        return  CompletableFuture.supplyAsync(() -> faker().name().fullName());
    }
}
