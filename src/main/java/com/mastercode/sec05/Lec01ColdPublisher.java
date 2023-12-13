package com.mastercode.sec05;

import static com.mastercode.utils.Util.sleep;
import static com.mastercode.utils.Util.subscriber;

import java.time.Duration;
import java.util.stream.Stream;
import reactor.core.publisher.Flux;

public class Lec01ColdPublisher {
    public static void main(String[] args) {
        Flux<String> movieStream = Flux.fromStream(Lec01ColdPublisher::getMovie)
                .delayElements(Duration.ofSeconds(2));

        movieStream.subscribe(subscriber("ali"));

        sleep(6);

        movieStream.subscribe(subscriber("vali"));

        sleep(600);
    }

    public static Stream<String> getMovie() {
        System.out.println("Start getting movie stream");
        return Stream.of(
                "Scene 1",
                "Scene 2",
                "Scene 3",
                "Scene 4",
                "Scene 5",
                "Scene 6",
                "Scene 7",
                "Scene 8"
                );
    }
}
