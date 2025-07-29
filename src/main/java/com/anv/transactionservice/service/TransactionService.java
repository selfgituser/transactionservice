package com.anv.transactionservice.service;

import com.anv.transactionservice.clientinterfaces.AccountClient;
import com.anv.transactionservice.entity.Account;
import com.anv.transactionservice.entity.TransactionEnt;
import com.anv.transactionservice.repository.TransactionRepository;
import com.anv.transactionservice.util.InsufficientFundsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {


    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountClient accountClient;


    public TransactionEnt doDeposit(Account account, BigDecimal amount) {
      account.setBalance(account.getBalance().add(amount));
        TransactionEnt transactionEnt = new TransactionEnt();
        transactionEnt.setToAccountId(account);
        transactionEnt.setAmount(amount);
        transactionEnt.setTransactionType("Deposit");
      return  transactionRepository.save(transactionEnt);
    }

    public TransactionEnt doWithDraw(Account account, BigDecimal amount) {
        if(account.getBalance().compareTo(amount) < 0){
            throw new InsufficientFundsException("Not enough funds for withdrawal");
        }

        account.setBalance(account.getBalance().subtract(amount));
        TransactionEnt transactionEnt = new TransactionEnt();
        transactionEnt.setFromAccountId(account);
        transactionEnt.setAmount(amount);
        transactionEnt.setTransactionType("Withdrawal");
        return transactionRepository.save(transactionEnt);
    }

    public TransactionEnt doTransfer(Account fromAccount , Account toAccount , BigDecimal amount)  {

        if (fromAccount.getBalance().compareTo(amount) < 0) {
            throw new InsufficientFundsException("Not enough funds for transfer");
        }

        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
        toAccount.setBalance(toAccount.getBalance().add(amount));

        TransactionEnt transaction =  new TransactionEnt();
        transaction.setFromAccountId(fromAccount);
        transaction.setToAccountId(toAccount);
        transaction.setAmount(amount);
        transaction.setTransactionType("Transfer");
        return transactionRepository.save(transaction);

    }

    public List<TransactionEnt> getTransactionsByAccountId(Long accountId) {
        List<TransactionEnt> transactions = new ArrayList<>();
        transactions.addAll(transactionRepository.findByFromAccountId(accountId));
        transactions.addAll(transactionRepository.findByToAccountId(accountId));
        return transactions;
    }

    public Account getAccountById(Long accountId) {
       return accountClient.getAccountById(accountId);
    }
}
