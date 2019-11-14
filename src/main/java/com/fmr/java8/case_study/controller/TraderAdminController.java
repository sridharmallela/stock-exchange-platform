package com.fmr.java8.case_study.controller;

import com.fmr.java8.case_study.domain.Trader;
import com.fmr.java8.case_study.service.TraderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(
    path = "admin/traders",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
)
public class TraderAdminController {

    private static final Logger logger = LoggerFactory.getLogger(TraderAdminController.class);

    @Autowired
    private TraderService traderService;

    @PostMapping
    public ResponseEntity<Trader> createOrUpdateTrader(@Valid @RequestBody final Trader trader) {
        logger.info("Rest API --> Create/Update trader for " + trader.toString());
        return new ResponseEntity<Trader>(traderService.addTrader(trader), HttpStatus.CREATED);
    }
}
