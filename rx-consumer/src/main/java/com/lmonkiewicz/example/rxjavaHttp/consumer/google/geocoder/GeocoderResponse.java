package com.lmonkiewicz.example.rxjavaHttp.consumer.google.geocoder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by lmonkiewicz on 2017-02-05.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocoderResponse {
    private List<GeocoderResult> results;

    public List<GeocoderResult> getResults() {
        return results;
    }

    public void setResults(List<GeocoderResult> results) {
        this.results = results;
    }
}
