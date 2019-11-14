package com.fmr.java8.case_study.service;

import com.fmr.java8.case_study.dao.TraderRepository;
import com.fmr.java8.case_study.domain.Trader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraderServiceImpl implements TraderService {

    private final Logger logger = LoggerFactory.getLogger(TraderServiceImpl.class);

    @Autowired
    TraderRepository traderRepository;

    @Override
    public Trader addTrader(Trader trader) {
        logger.debug("Validated trader prior to save for " + trader.getFirstName());
        return traderRepository.save(trader);
    }
}
