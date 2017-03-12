package com.lmonkiewicz.example.rxjavaHttp.producer;

import io.reactivex.Observable;
import org.junit.Test;

/**
 * Created by lmonkiewicz on 2017-02-13.
 */

public class RxJavaExamplesTests {

    @Test
    public void simplestForm() throws Exception {
        Observable.just(5)
                .subscribe(System.out::println);
    }

    @Test
    public void simpleArray() throws Exception {
        Observable.fromArray(1,2,3,4,5,6,7)
                .subscribe(System.out::println);
    }

    @Test
    public void mapSquareArray() throws Exception {
        Observable.fromArray(1, 2, 3, 4, 5, 6, 7, 8)
                .map(x -> x * x)
                .subscribe(System.out::println);
    }

    @Test
    public void mapSquare2Array() throws Exception {
        Observable.fromArray(1, 2, 3, 4, 5, 6, 7, 8)
                .map(x -> x * x)
                .filter( x -> x % 2 == 0)
                .subscribe(System.out::println);
    }
}
