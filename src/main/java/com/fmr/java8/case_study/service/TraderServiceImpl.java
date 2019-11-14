package com.fmr.java8.case_study.service;

import com.fmr.java8.case_study.dao.TraderRepository;
import com.fmr.java8.case_study.domain.Trader;
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
    public Trader addTrader(final Trader trader) {
        logger.debug("Validated trader prior to save for " + trader.getFirstName());
        return traderRepository.save(trader);
    }

    @Override
    public List<Trader> getAllTraders() {
        return (List<Trader>) traderRepository.findAll();
    }

    @Override
    public Optional<Trader> getTraderById(final String id) {
        return traderRepository.findById(id);
    }

    @Override
    public List<Trader> getTraderByLastName(final String name) {
        return traderRepository.findAllByLastName(name);
    }

    @Override
    public Trader removeTrader(final Trader trader) {
        traderRepository.delete(trader);
        return trader;
    }
}
