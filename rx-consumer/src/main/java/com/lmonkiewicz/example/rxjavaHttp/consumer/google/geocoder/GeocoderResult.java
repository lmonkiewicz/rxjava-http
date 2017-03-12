package com.lmonkiewicz.example.rxjavaHttp.consumer.google.geocoder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by lmonkiewicz on 2017-02-05.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocoderResult {

    @JsonProperty("formatted_address")
    private String formattedAddress;

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }
}
