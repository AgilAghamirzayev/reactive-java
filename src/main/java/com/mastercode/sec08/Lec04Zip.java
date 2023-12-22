package com.mastercode.sec08;

import static com.mastercode.utils.Util.sleep;
import static com.mastercode.utils.Util.subscriber;

import com.mastercode.sec08.helper.American;
import com.mastercode.sec08.helper.Emirates;
import com.mastercode.sec08.helper.Qatar;
import reactor.core.publisher.Flux;

public class Lec04Zip {
    public static void main(String[] args) {
        Flux.zip(getBody(), getEngine(), getEngine())
                .subscribe(subscriber());
    }

    private static Flux<String> getBody() {
        return Flux.range(1,5)
                .map(i -> "body");
    }

    private static Flux<String> getEngine() {
        return Flux.range(1,2)
                .map(i -> "engine");
    }

    private static Flux<String> getTiers() {
        return Flux.range(1,6)
                .map(i -> "tiers");
    }
}
