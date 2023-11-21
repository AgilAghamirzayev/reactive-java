package com.mastercode.sec01;

import static com.mastercode.utils.Util.faker;
import static com.mastercode.utils.Util.onNext;

import java.util.concurrent.Callable;
import java.util.function.Supplier;
import reactor.core.publisher.Mono;

public class Lec05MonoFromSupplier {
    public static void main(String[] args) {
        Mono<String> just = Mono.just(getName());

        Supplier<String> supplier = Lec05MonoFromSupplier::getName;
        Mono.fromSupplier(supplier).subscribe(onNext());

        Callable<String> callable = Lec05MonoFromSupplier::getName;
        Mono.fromCallable(callable).subscribe(onNext());
    }

    private static String getName() {
        System.out.println("Generating name...");
        return faker().name().fullName();
    }
}
