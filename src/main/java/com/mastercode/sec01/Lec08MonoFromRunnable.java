package com.mastercode.sec01;

import reactor.core.publisher.Mono;

import static com.mastercode.utils.Util.onError;
import static com.mastercode.utils.Util.onNext;
import static com.mastercode.utils.Util.sleep;

public class Lec08MonoFromRunnable {
    public static void main(String[] args) {
        Mono.fromRunnable(timeConsumingOperation())
                .subscribe(
                        onNext(),
                        onError(),
                        () -> System.out.println("process is done. Sending emails...")
                );
    }

    private static Runnable timeConsumingOperation() {
        return () -> {
            sleep(3);
            System.out.println("Operation completed ...");
        };
    }

}
