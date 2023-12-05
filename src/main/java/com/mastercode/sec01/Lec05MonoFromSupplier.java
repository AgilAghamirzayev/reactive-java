package com.mastercode.sec01;

import static com.mastercode.utils.Util.faker;
import static com.mastercode.utils.Util.onNext;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Callable;
import java.util.function.Supplier;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec05MonoFromSupplier {
    public static void main(String[] args) throws InterruptedException {
        Mono<String> just = Mono.just(getName());

        Supplier<String> supplier = Lec05MonoFromSupplier::getName;
        Mono.fromSupplier(supplier).subscribe(onNext());

        Callable<String> callable = Lec05MonoFromSupplier::getName;
        Mono.fromCallable(callable)
//                .subscribeOn(Schedulers.parallel())
//                .delayElement(Duration.of(4, ChronoUnit.SECONDS))
                .subscribe(onNext());
        System.out.println("MAAAAin");
        Thread.sleep(5000);
    }

    private static String getName() {
        System.out.println("Generating name...");

        return faker().name().fullName();
    }
}
