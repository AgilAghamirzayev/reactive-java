package com.mastercode.sec09;

import static com.mastercode.utils.Util.sleep;

import java.time.Duration;
import reactor.core.publisher.Flux;

public class Lec05Group {

    public static void main(String[] args) {
        Flux.range(1, 30)
                .delayElements(Duration.ofSeconds(1))
                .groupBy(i -> i % 2 == 0 ? "EVEN" : "ODD")
                .subscribe(gf ->
                        gf.subscribe(flux -> System.out.println(flux + " is " + gf.key()))
                );

        sleep(111);
    }


}
