package com.lmonkiewicz.example.rxjavaHttp.consumer;

import com.lmonkiewicz.example.rxjavaHttp.consumer.google.geocoder.GeocoderResponse;
import com.lmonkiewicz.example.rxjavaHttp.consumer.google.geocoder.GeocoderResult;
import com.lmonkiewicz.example.rxjavaHttp.consumer.google.geocoder.GeocoderService;
import com.lmonkiewicz.example.rxjavaHttp.consumer.numbers.NumbersService;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lmonkiewicz on 2017-02-05.
 */
@Service
public class AddressService {

    @Autowired
    NumbersService numbersService;

    @Autowired
    GeocoderService geocoderService;

    final ExecutorService executorService = Executors.newFixedThreadPool(2);


    public Single<String> randomAddress(){
        return numbersService.random(49,55) // get first coord
                .concatWith(numbersService.random(14,24)) // get second coordinate and add it to stream
                .map(Number::toString) // convert values to String
                .toList() // make a list from stream
                .map(list -> list.get(0)+", "+list.get(1)) // join two values together into String
                .toObservable() // convert back to Observable because we got Single as a result
                .flatMap(latlng -> geocoderService.byLatLng(latlng))  // query google service with coordinates and unwrap Observable
                .map(GeocoderResponse::getResults)  // extract results from response
                .filter(list -> !list.isEmpty())   // filter out empty results
                .flatMap(Observable::fromIterable)   // convert to Observable from List
                .map(GeocoderResult::getFormattedAddress)  // get adres from results
                .firstOrError()   // get first result or throw error
                .retry(4) // if we have error, retry whole chain
                .subscribeOn(Schedulers.from(executorService));
    }


}
