package com.fmr.java8.case_study.dao;

import com.fmr.java8.case_study.domain.Trader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TraderRepository extends CrudRepository<Trader, String> {

    List<Trader> findAllByLastName(String firstName);
}
