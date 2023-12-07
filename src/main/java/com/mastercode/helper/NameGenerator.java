package com.mastercode.helper;

import static com.mastercode.utils.Util.faker;
import static com.mastercode.utils.Util.sleep;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import reactor.core.publisher.Flux;

public class NameGenerator {


    public static List<String> getNamesList(int count) {
        ArrayList<String> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(getName());
        }
        return list;
    }

    public static Stream<String> getNamesStream(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> getName());
    }

    public static Flux<String> getNamesFlux(int count) {
        return Flux.range(0, count)
                .map(i -> getName());
    }


    private static String getName() {
        sleep(1);
        return faker().name().fullName();
    }
}
