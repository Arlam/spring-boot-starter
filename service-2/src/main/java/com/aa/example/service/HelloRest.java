package com.aa.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
public class HelloRest {

    private static final Logger LOG = LoggerFactory.getLogger(HelloRest.class);

    @RequestMapping(method = RequestMethod.GET, path = "hello")
    public String hello() {
        LOG.info("hello service 2");

        return "hello";
    }
}
