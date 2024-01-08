package com.mastercode;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.StepVerifierOptions;

import java.time.Duration;

public class Lec06ScenarioNameTest {

    @Test
    public void test1() {
        Flux<String> flux = Flux.just("a", "b", "c");
        StepVerifierOptions scenarioName = StepVerifierOptions.create().scenarioName("alphabets-test");

        StepVerifier.create(flux, scenarioName)
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    public void test2() {
        Flux<String> flux = Flux.just("a", "b", "c");

        StepVerifier.create(flux)
                .expectNext("a")
                .as("a-test")
                .expectNext("b")
                .as("b-test")
                .expectNext("c")
                .as("c-test")
                .verifyComplete();
    }

}
