package com.mastercode.sec02;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.SneakyThrows;
import reactor.core.publisher.Flux;

public class Assignment {


    @SneakyThrows
    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(1);

        AtomicInteger currentPrice = new AtomicInteger(100);

        updatePrice()
                .map(currentPrice::getAndAdd)
                .filter(price -> price < 90 || price > 110)
                .next()
                .subscribe(
                        price -> {
                            System.out.println(price);
                            latch.countDown();
                        },
                        price -> latch.countDown(),
                        latch::countDown
                );

        latch.await();
    }


    public static Flux<Integer> updatePrice() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(price -> new Random().nextInt(11) - 5);
    }
}
