package com.mastercode.sec02;

import static com.mastercode.helper.NameGenerator.getNamesFlux;
import static com.mastercode.helper.NameGenerator.getNamesStream;

public class Lec07FluxVsList {
    public static void main(String[] args) {
//        List<String> names = getNames(5);

        getNamesFlux(5)
                .subscribe(System.out::println);

        getNamesStream(5)
                .forEach(System.out::println);
    }
}
