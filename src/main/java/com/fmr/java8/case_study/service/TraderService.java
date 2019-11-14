package com.fmr.java8.case_study.service;

import com.fmr.java8.case_study.domain.Trader;
import com.fmr.java8.case_study.model.AppResponse;

import java.util.List;
import java.util.Optional;

public interface TraderService {

    AppResponse<Trader> addTrader(Trader trader);

    AppResponse<List<Trader>> getAllTraders();

    AppResponse<Optional<Trader>> getTraderById(String id);

    AppResponse<List<Trader>> getTraderByLastName(String name);

    AppResponse<Trader> removeTrader(Trader trader);
}
