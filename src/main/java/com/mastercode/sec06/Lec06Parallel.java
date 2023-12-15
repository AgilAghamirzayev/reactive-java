package com.mastercode.sec06;

import static com.mastercode.utils.Util.sleep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec06Parallel {

    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>();

        Flux.range(1, 1000)
                .parallel(20)
                .runOn(Schedulers.parallel())
//                .doOnNext(i -> printThreadName("nxt " + i))
                .subscribe(list::add);

        sleep(2);
        System.out.println(list.size());
    }

    private static void printThreadName(String message) {
        System.out.println(message + "\t\t: Thread : " + Thread.currentThread().getName());
    }
}
