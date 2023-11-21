package com.mastercode.sec01;

import static com.mastercode.utils.Util.faker;
import static com.mastercode.utils.Util.onNext;
import static com.mastercode.utils.Util.sleep;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec06RefactoringSupplier {
    public static void main(String[] args) {
        getName();
        getName()
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(onNext());
        String name = getName()
                .subscribeOn(Schedulers.boundedElastic())
                .block();
        System.out.println(name);
    }

    private static Mono<String> getName() {
        System.out.println("getName().START: thread:" + Thread.currentThread().getName());
        return Mono.fromSupplier(() -> {
            System.out.println("Generating name...");
            sleep(3);
            return faker().name().fullName();
        }).map(String::toUpperCase);
    }
}
