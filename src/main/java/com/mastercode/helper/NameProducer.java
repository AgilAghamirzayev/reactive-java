package com.mastercode.helper;

import static com.mastercode.utils.Util.faker;

import java.util.function.Consumer;
import reactor.core.publisher.FluxSink;

public class NameProducer implements Consumer<FluxSink<String>> {

    private FluxSink<String> fluxSink;

    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        fluxSink = stringFluxSink;
    }

    public void produce() {
        String name = faker().name().fullName();
        String thread = Thread.currentThread().getName();
        fluxSink.next(thread + " : " + name);
    }
}
