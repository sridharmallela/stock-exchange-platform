package com.fmr.java8.case_study.service;

import com.fmr.java8.case_study.dao.TraderRepository;
import com.fmr.java8.case_study.domain.Trader;
import com.fmr.java8.case_study.model.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraderServiceImpl implements TraderService {

    private final Logger logger = LoggerFactory.getLogger(TraderServiceImpl.class);

    @Autowired
    TraderRepository traderRepository;

    @Override
    public AppResponse<Trader> addTrader(final Trader trader) {
        logger.debug("Validated trader prior to save for " + trader.getFirstName());
        return createResponse(traderRepository.save(trader));
    }

    @Override
    public AppResponse<List<Trader>> getAllTraders() {
        return createResponse((List<Trader>) traderRepository.findAll());
    }

    @Override
    public AppResponse<Optional<Trader>> getTraderById(final String id) {
        return createResponse(traderRepository.findById(id));
    }

    @Override
    public AppResponse<List<Trader>> getTraderByLastName(final String name) {
        return createResponse(traderRepository.findAllByLastName(name));
    }

    @Override
    public AppResponse<Trader> removeTrader(final Trader trader) {
        traderRepository.delete(trader);
        return createResponseMsg(trader, "Delete successful for " + trader.getId());
    }

    private static <T> AppResponse<T> createResponse(T t) {
        return new AppResponse<T>(t);
    }

    private static <T> AppResponse<T> createResponseMsg(T t, String message) {
        AppResponse<T> app =  new AppResponse<T>(t);
        app.setMessage(message);
        return app;
    }
}
