package com.mastercode.sec08;

import static com.mastercode.utils.Util.sleep;
import static com.mastercode.utils.Util.subscriber;

import com.mastercode.sec08.helper.American;
import com.mastercode.sec08.helper.Emirates;
import com.mastercode.sec08.helper.Qatar;
import reactor.core.publisher.Flux;

public class Lec03Merge {
    public static void main(String[] args) {
        Flux<String> merge = Flux.merge(
                Qatar.getFlights(),
                Emirates.getFlights(),
                American.getFlights()
        );

        merge.subscribe(subscriber());

        sleep(100);
    }
}
