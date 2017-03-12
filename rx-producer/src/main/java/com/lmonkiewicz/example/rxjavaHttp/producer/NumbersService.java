package com.lmonkiewicz.example.rxjavaHttp.producer;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by lmonkiewicz on 2017-02-05.
 */
@Service
public class NumbersService {

    final ExecutorService executorService = Executors.newFixedThreadPool(2);

    public Observable<Integer> generate(int count){
        return Observable.range(1, count) // generate values stream from 1 to count
                .subscribeOn(Schedulers.from(executorService));
    }

    public Observable<Double> random(double from, double to){
        return Observable.just(Math.random()) // start with random
                    .subscribeOn(Schedulers.from(executorService))
                    .map(v -> from + (v * (to - from))); // calculate result in range of from -> to from random value
    }

    public Observable<Double> generateRandom(double from, double to, int count){
        return Observable.interval(5, TimeUnit.MILLISECONDS) // every 5 ms do...
                .subscribeOn(Schedulers.from(executorService))
                .flatMap(x -> random(from, to)) // get random number
                .distinct() // filter out duplicates
                .take(count) // limit results to count
                .sorted(); // sort results

    }
}
