package com.mastercode.sec02;

import static com.mastercode.utils.Util.onCompleted;
import static com.mastercode.utils.Util.onError;
import static com.mastercode.utils.Util.onNext;

import java.util.List;
import java.util.stream.Stream;
import reactor.core.publisher.Flux;

public class Lec04FluxFromStream {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();

//        stream.forEach(System.out::println);
//        stream.forEach(System.out::println);

//        Flux<Integer> integerFlux = Flux.fromStream(stream);
//        Flux<Integer> integerFlux = Flux.fromStream(() -> stream);
        Flux<Integer> integerFlux = Flux.fromStream(list::stream);
        integerFlux.subscribe(onNext(), onError(), onCompleted());
        integerFlux.subscribe(onNext(), onError(), onCompleted());
    }
}
