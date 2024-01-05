package com.mastercode.sec12.helper;

import reactor.core.publisher.Mono;
import reactor.util.context.Context;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static com.mastercode.utils.Util.faker;

public class BookService {
    private static Map<String, Integer> map = new HashMap<>();

    static {
        map.put("standard", 2);
        map.put("prime", 3);
    }

    public static Mono<String> getBook() {
        return Mono.deferContextual(ctx -> {
                    if (ctx.get("allow")) {
                        return Mono.just(faker().book().title());
                    }

                    return Mono.error(new RuntimeException("not allowed"));
                })
                .contextWrite(rateLimiterContext());
    }

    private static Function<Context, Context> rateLimiterContext() {
        return ctx -> {
            if (ctx.hasKey("category")) {
                String category = ctx.get("category").toString();
                Integer attempts = map.get(category);
                if (attempts > 0) {
                    map.put(category, attempts - 1);
                    return ctx.put("allow", true);
                }
            }
            return ctx.put("allow", false);
        };
    }
}
