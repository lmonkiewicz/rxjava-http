package com.lmonkiewicz.example.rxjavaHttp.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lmonkiewicz on 2017-02-05.
 */
@RestController
@RequestMapping("/numbers")
public class NumbersController {

    @Autowired
    private NumbersService numbersService;

    @RequestMapping(value = "/generate/{count}", method = RequestMethod.GET)
    public List<Integer> generate(@PathVariable("count") Integer count){
        return numbersService.generate(count)
                .toList()
                .blockingGet();
    }

    @RequestMapping(value = "/random/{from}/{to}", method = RequestMethod.GET)
    public Double random(@PathVariable("from") Double from, @PathVariable("to") Double to){
        return numbersService.random(from, to).blockingFirst();
    }

    @RequestMapping("/random/{count}/{from}/{to}")
    public List<Double> randomList(@PathVariable("count") Integer count, @PathVariable("from") Double from, @PathVariable("to") Double to){
        return numbersService.generateRandom(from, to, count).toList().blockingGet();
    }
}
