package com.mastercode.sec01;

import reactor.core.publisher.Mono;

import static com.mastercode.utils.Util.faker;
import static com.mastercode.utils.Util.onCompleted;
import static com.mastercode.utils.Util.onError;
import static com.mastercode.utils.Util.onNext;

public class Lec04MonoEmptyOrError {
    public static void main(String[] args) {
        userRepository(1)
                .subscribe(onNext(), onError(), onCompleted());
    }

    private static Mono<String> userRepository(int userId) {
       return switch (userId) {
           case 1 -> Mono.just(faker().name().firstName());
           case 2 -> Mono.empty();
           default -> Mono.error(new RuntimeException("User not found"));
       };
    }
}
