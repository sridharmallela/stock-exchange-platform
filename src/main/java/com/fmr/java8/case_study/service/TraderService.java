package com.fmr.java8.case_study.service;

import com.fmr.java8.case_study.domain.Trader;

import java.util.List;
import java.util.Optional;

public interface TraderService {

    Trader addTrader(Trader trader);

    List<Trader> getAllTraders();

    Optional<Trader> getTraderById(String id);

    List<Trader> getTraderByLastName(String name);

    Trader removeTrader(Trader trader);
}
