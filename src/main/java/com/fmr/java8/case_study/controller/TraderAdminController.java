package com.fmr.java8.case_study.controller;

import com.fmr.java8.case_study.domain.Trader;
import com.fmr.java8.case_study.service.TraderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(
    path = "admin/traders",
    produces = MediaType.APPLICATION_JSON_VALUE
)
public class TraderAdminController {

    private static final Logger logger = LoggerFactory.getLogger(TraderAdminController.class);

    @Autowired
    private TraderService traderService;

    @GetMapping
    public ResponseEntity<List<Trader>> findAllTraders() {
        return new ResponseEntity<List<Trader>>(traderService.getAllTraders(), HttpStatus.OK);
    }

    @GetMapping(path = "id/{id}")
    public ResponseEntity<Trader> findTraderByTraderId(@PathVariable(name = "id") final String id) {
        return new ResponseEntity<Trader>(traderService.getTraderById(id).get(), HttpStatus.OK);
    }

    @GetMapping(path = "name/{name}")
    public ResponseEntity<List<Trader>> findTraderByLastName(@PathVariable(name = "name") final String name) {
        return new ResponseEntity<List<Trader>>(traderService.getTraderByLastName(name), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Trader> createOrUpdateTrader(@Valid @RequestBody final Trader trader) {
        logger.info("Rest API --> Create/Update trader for " + trader.toString());
        return new ResponseEntity<Trader>(traderService.addTrader(trader), HttpStatus.CREATED);
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Trader> deleteTrader(@Valid @RequestBody final Trader trader) {
        return new ResponseEntity<Trader>(traderService.removeTrader(trader), HttpStatus.OK);
    }
}
