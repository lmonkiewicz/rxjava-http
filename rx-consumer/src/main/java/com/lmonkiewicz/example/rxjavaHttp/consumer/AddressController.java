package com.lmonkiewicz.example.rxjavaHttp.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lmonkiewicz on 2017-02-05.
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public String random(){
        return addressService.randomAddress().blockingGet();
    }
}
