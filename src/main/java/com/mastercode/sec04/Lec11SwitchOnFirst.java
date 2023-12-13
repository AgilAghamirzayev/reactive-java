package com.mastercode.sec04;

import static com.mastercode.utils.Util.subscriber;

import com.mastercode.helper.Person;
import java.util.function.Function;
import reactor.core.publisher.Flux;

public class Lec11SwitchOnFirst {
    public static void main(String[] args) {
        getPerson()
                .switchOnFirst(((signal, personFlux) ->
                        signal.isOnNext() && signal.get().getAge() > 20 ?
                                personFlux : applyFilterMap().apply(personFlux)))
                .subscribe(subscriber());
    }

    private static Flux<Person> getPerson() {
        return Flux.range(1, 10)
                .map(i -> new Person());
    }

    private static Function<Flux<Person>, Flux<Person>> applyFilterMap() {
        return flux -> flux
                .filter(p -> p.getAge() > 10)
                .doOnNext(p -> p.setName(p.getName().toUpperCase()))
                .doOnDiscard(Person.class, p -> System.out.println("Not allowed: " + p.getName()));

    }

}
