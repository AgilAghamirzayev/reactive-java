package com.mastercode.sec04;

import static com.mastercode.utils.Util.subscriber;

import com.mastercode.helper.Person;
import com.mastercode.helper.microservices.OrderService;
import com.mastercode.helper.microservices.UserService;
import java.util.function.Function;
import reactor.core.publisher.Flux;

public class Lec12FlatMap {
    public static void main(String[] args) {
//        UserService.getUsers()
//                .flatMap(user -> OrderService.getOrders(user.getUserId()))
//                .subscribe(subscriber());

        Flux<Integer> originalStream = Flux.just(1, 2, 3);
         originalStream
                 .map(number -> "Value: " + number)
                 .subscribe(subscriber());

         originalStream
                 .flatMap(number -> Flux.just("Value: " + number, "Doubled: " + number * 2))
                 .subscribe(subscriber());

    }

}
