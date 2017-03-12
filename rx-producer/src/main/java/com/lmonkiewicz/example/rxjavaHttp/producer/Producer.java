package com.lmonkiewicz.example.rxjavaHttp.producer;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lmonkiewicz on 2017-02-05.
 */
@Configuration
@ComponentScan( basePackageClasses = ProducerApplication.class)
@EnableAutoConfiguration
public class Producer {

}
