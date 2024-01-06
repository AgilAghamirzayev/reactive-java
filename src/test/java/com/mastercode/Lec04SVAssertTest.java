package com.mastercode;

import com.mastercode.sec09.helper.BookOrder;
import com.mastercode.sec12.helper.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;

public class Lec04SVAssertTest {

    @Test
    public void test1() {
        Mono<BookOrder> mono = Mono.fromSupplier(BookOrder::new);

        StepVerifier.create(mono)
                .assertNext(book -> Assertions.assertNotNull(book.getAuthor()))
                .verifyComplete();
    }

    @Test
    public void test2() {
        Mono<BookOrder> mono = Mono.fromSupplier(BookOrder::new)
                .delayElement(Duration.ofSeconds(3));

        StepVerifier.create(mono)
                .assertNext(book -> Assertions.assertNotNull(book.getAuthor()))
                .expectComplete()
                .verify(Duration.ofSeconds(4));
    }
}
