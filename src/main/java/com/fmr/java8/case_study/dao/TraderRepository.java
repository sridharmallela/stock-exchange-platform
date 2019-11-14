package com.fmr.java8.case_study.dao;

import com.fmr.java8.case_study.domain.Trader;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TraderRepository extends PagingAndSortingRepository<Trader, String> {
}
