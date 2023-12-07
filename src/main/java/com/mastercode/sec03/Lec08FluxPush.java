package com.mastercode.sec03;

import static com.mastercode.utils.Util.faker;
import static com.mastercode.utils.Util.subscriber;

import com.mastercode.helper.NameProducer;
import reactor.core.publisher.Flux;

public class Lec08FluxPush {
    public static void main(String[] args) {

        NameProducer nameProducer = new NameProducer();

        Flux.push(nameProducer)
                .subscribe(subscriber());

        Runnable runnable = nameProducer::produce;

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }


    }
}
