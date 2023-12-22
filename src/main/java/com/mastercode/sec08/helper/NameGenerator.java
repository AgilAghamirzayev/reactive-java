package com.mastercode.sec08.helper;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

import static com.mastercode.utils.Util.faker;
import static com.mastercode.utils.Util.sleep;

public class NameGenerator {
    private final List<String> list = new ArrayList<>();

    public Flux<String> generateNames() {
        return Flux.generate(stringSynchronousSink -> {
                    System.out.println("Generating");
                    sleep(1);
                    String name = faker().name().firstName();
                    list.add(name);
                    stringSynchronousSink.next(name);
                })
                .cast(String.class)
                .startWith(getFromCache());
    }

    private Flux<String> getFromCache() {
        return Flux.fromIterable(list);
    }
}
