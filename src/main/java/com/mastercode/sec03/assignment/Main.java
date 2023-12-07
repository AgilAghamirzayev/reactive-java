package com.mastercode.sec03.assignment;

import static com.mastercode.utils.Util.onCompleted;
import static com.mastercode.utils.Util.onError;
import static com.mastercode.utils.Util.onNext;
import static com.mastercode.utils.Util.subscriber;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        FileReaderService fileService = new FileReaderService();
        Path path = Paths.get("src/main/resources/assignment/sec03/file01.txt");
        fileService.readFile(path)
                .subscribe(subscriber());

    }
}
