package com.mastercode.sec09.helper;

import static com.mastercode.utils.Util.faker;

import com.github.javafaker.Book;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BookOrder {
    private final String title;
    private final String author;
    private final String category;
    private final Double price;

    public BookOrder() {
        Book book = faker().book();
        title = book.title();
        author = book.author();
        category = book.genre();
        price = Double.parseDouble(faker().commerce().price());
    }
}
