package com.fmr.java8.case_study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockExchangePlatformApp {

    private static final Logger logger = LoggerFactory.getLogger(StockExchangePlatformApp.class);

    public static void main(final String[] args) {
        SpringApplication.run(StockExchangePlatformApp.class, args);
        logger.info(">>>>>>> Application Started >>>>>>> ");
    }
}
