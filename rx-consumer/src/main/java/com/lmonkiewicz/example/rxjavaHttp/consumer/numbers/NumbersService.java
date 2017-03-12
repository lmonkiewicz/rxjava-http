package com.lmonkiewicz.example.rxjavaHttp.consumer.numbers;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

/**
 * Created by lmonkiewicz on 2017-02-05.
 */
public interface NumbersService {

    @GET("generate/{count}")
    Observable<List<Integer>> generate(@Path("count") Integer count);

    @GET("random/{from}/{to}")
    Observable<Double> random(@Path("from") double from, @Path("to") double to);

    @GET("random/{count}/{from}/{to}")
    Observable<List<Double>> randomList(@Path("count") int count, @Path("from") double from, @Path("to") double to);

}
