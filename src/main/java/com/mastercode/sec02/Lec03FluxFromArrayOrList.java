package com.mastercode.sec02;

import reactor.core.publisher.Flux;

import java.util.List;

import static com.mastercode.utils.Util.onNext;

public class Lec03FluxFromArrayOrList {
    public static void main(String[] args) {
        List<String> strings = List.of("a", "b", "d", "e");
        Flux.fromIterable(strings)
                .subscribe(onNext());
    }
}
