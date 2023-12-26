package com.mastercode.sec09;

import static com.mastercode.utils.Util.sleep;
import static com.mastercode.utils.Util.subscriber;

import com.mastercode.sec09.helper.BookOrder;
import com.mastercode.sec09.helper.RevenueReport;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import reactor.core.publisher.Flux;

public class Lec03Assignment {
    public static void main(String[] args) {
        Set<String> allowedCategories = Set.of(
                "Science fiction",
                "Fantasy",
                "Suspense/Thriller"
        );

        bookStream()
                .filter(book -> allowedCategories.contains(book.getCategory()))
                .buffer(Duration.ofSeconds(5))
                .map(Lec03Assignment::revenueReport)
                .subscribe(subscriber());

        sleep(60);
    }

    private static RevenueReport revenueReport(List<BookOrder> books) {
        Map<String, Double> map = books.stream()
                .collect(Collectors.groupingBy(
                        BookOrder::getCategory,
                        Collectors.summingDouble(BookOrder::getPrice)
                ));

        return new RevenueReport(map);
    }

    private static Flux<BookOrder> bookStream() {
        return Flux.interval(Duration.ofMillis(200))
                .map(i -> new BookOrder());
    }
}
