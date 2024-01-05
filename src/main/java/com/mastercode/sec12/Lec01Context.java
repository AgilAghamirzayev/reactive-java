package com.mastercode.sec12;

import reactor.core.publisher.Mono;
import reactor.util.context.Context;

import static com.mastercode.utils.Util.subscriber;

public class Lec01Context {
    public static void main(String[] args) {
        getWelcomeMessage()
                .contextWrite(ctx -> ctx.put("user", ctx.get("user").toString().toUpperCase()))
                .contextWrite(Context.of("user", "ali"))
                .subscribe(subscriber());
    }

    private static Mono<String> getWelcomeMessage() {
        return Mono.deferContextual(ctx -> {
            if (ctx.hasKey("user")) {
                return Mono.just("Welcome " + ctx.get("user"));
            }
            return Mono.error(new RuntimeException("unauthenticated"));
        });
    }
}
