package com.mastercode.sec01;

import java.util.stream.Stream;

public class Lec01Stream {
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .filter(i -> i % 2 == 0)
                .map(i -> {
                    System.out.println(i);
                    return 2 * i;
                });
    }
}
