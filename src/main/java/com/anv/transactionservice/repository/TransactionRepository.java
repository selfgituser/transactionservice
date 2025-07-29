package com.anv.transactionservice.repository;

import com.anv.transactionservice.entity.TransactionEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEnt, Long> {

    List<TransactionEnt> findByFromAccountId(Long accountId);
    List<TransactionEnt> findByToAccountId(Long accountId);
}
