package com.mastercode.sec08;

import com.mastercode.sec08.helper.NameGenerator;

import static com.mastercode.utils.Util.subscriber;

public class Lec01StartWith {
    public static void main(String[] args) {
        NameGenerator nameGenerator = new NameGenerator();

        nameGenerator.generateNames()
                .take(2)
                .subscribe(subscriber("ali"));

        nameGenerator.generateNames()
                .take(3)
                .subscribe(subscriber("valid"));

        nameGenerator.generateNames()
                .filter(name -> name.startsWith("A"))
                .take(2)
                .subscribe(subscriber("omar"));
    }
}
