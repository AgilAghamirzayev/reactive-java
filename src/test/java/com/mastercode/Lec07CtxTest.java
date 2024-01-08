package com.mastercode;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.test.StepVerifierOptions;
import reactor.util.context.Context;

public class Lec07CtxTest {

    @Test
    public void test1() {
        StepVerifier.create(getWelcomeMessage())
                .verifyError(RuntimeException.class);
    }

    @Test
    public void test2() {
        StepVerifierOptions options = StepVerifierOptions.create().withInitialContext(Context.of("user", "Ali"));

        StepVerifier.create(getWelcomeMessage(), options)
                .expectNext("Welcome Ali")
                .verifyComplete();
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
