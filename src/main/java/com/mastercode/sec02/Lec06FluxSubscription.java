package com.mastercode.sec02;

import static com.mastercode.utils.Util.sleep;

import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

public class Lec06FluxSubscription {
    public static void main(String[] args) {

        AtomicReference<Subscription> atomicReference = new AtomicReference<>();

        Flux.range(1, 20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Received sub: " + subscription);
                        atomicReference.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("onError: " + throwable);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });

        sleep(3);
        atomicReference.get().request(3);
        sleep(5);
        atomicReference.get().request(3);
        sleep(5);
        System.out.println("Cancelling...");
        atomicReference.get().cancel();
        sleep(3);
        atomicReference.get().request(4);
        sleep(3);

    }
}
