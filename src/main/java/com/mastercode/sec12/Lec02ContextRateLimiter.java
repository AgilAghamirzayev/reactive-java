package com.mastercode.sec12;

import com.mastercode.sec12.helper.BookService;
import com.mastercode.sec12.helper.UserService;
import reactor.util.context.Context;

import static com.mastercode.utils.Util.subscriber;

public class Lec02ContextRateLimiter {
    public static void main(String[] args) {
        BookService.getBook()
                .repeat(3)
                .contextWrite(UserService.userCategoryContext())
                .contextWrite(Context.of("user", "ali"))
                .subscribe(subscriber());
    }
}
