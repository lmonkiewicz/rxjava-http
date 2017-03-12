package com.lmonkiewicz.example.rxjavaHttp.consumer.google.geocoder;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lmonkiewicz on 2017-02-05.
 */
public interface GeocoderService {

    @GET("json")
    Observable<GeocoderResponse> byLatLng(@Query("latlng") String latlng);
}
