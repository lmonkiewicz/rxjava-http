package com.lmonkiewicz.example.rxjavaHttp.consumer;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.lmonkiewicz.example.rxjavaHttp.consumer.google.geocoder.GeocoderService;
import com.lmonkiewicz.example.rxjavaHttp.consumer.numbers.NumbersService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by lmonkiewicz on 2017-02-05.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = RxConsumerApplication.class)
public class RxConsumer {


    @Bean
    public NumbersService numbersService(@Value(value = "${numbersService.url}") String baseUrl){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(NumbersService.class);
    }

    @Bean
    public GeocoderService geocoderService(@Value(value = "${googleGeocodeService.url}") String baseUrl){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(GeocoderService.class);
    }

}
