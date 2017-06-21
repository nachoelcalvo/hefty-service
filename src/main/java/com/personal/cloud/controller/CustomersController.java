package com.personal.cloud.controller;

import com.personal.cloud.config.CustomerServiceProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;

/**
 * Created by josgar on 20/06/2017.
 */
@RestController
@RequestMapping(path = "hefty")
public class CustomersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomersController.class);

    private CustomerServiceProperties customerServiceProperties;

    @Autowired
    public CustomersController(CustomerServiceProperties customerServiceProperties) {
        this.customerServiceProperties = customerServiceProperties;
    }

    @GetMapping("/customers")
    public String heftyCustomers() throws Exception{

        if(new Random().nextInt() % 2 == 0){
           throw new RuntimeException("Uuuups, there was an error...");
        }

        long processsingTime = customerServiceProperties.getTimeout();

        LOGGER.info("Obtaining customers with a processing time of {} ms", processsingTime);

        Thread.sleep(processsingTime);

        return "customer_" + UUID.randomUUID().toString();
    }
}
