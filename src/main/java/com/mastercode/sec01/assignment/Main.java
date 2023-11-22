package com.mastercode.sec01.assignment;

import static com.mastercode.utils.Util.onCompleted;
import static com.mastercode.utils.Util.onError;
import static com.mastercode.utils.Util.onNext;

public class Main {
    public static void main(String[] args) {
        FileService fileService = new FileService();

        fileService.read("file01.txt")
                .subscribe(onNext(), onError(), onCompleted());

//        fileService.delete("file01.txt")
//                .subscribe(onNext(), onError(), onCompleted());
//
        fileService.write("file01.txt", "This is file 01")
                .subscribe(onNext(), onError(), onCompleted());


    }
}
