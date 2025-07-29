package com.anv.transactionservice.controller;

import com.anv.transactionservice.entity.Account;
import com.anv.transactionservice.entity.TransactionEnt;
import com.anv.transactionservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

  @PostMapping("/deposit/{accountId}")
    public TransactionEnt doDeposit(@PathVariable Long accountId , @RequestBody BigDecimal amount) {
      Account account = this.AccountDetails(accountId);
      return transactionService.doDeposit(account,amount);
  }


    @PostMapping("/withdraw/{accountId}")
    public TransactionEnt doWithDraw(@PathVariable Long accountId , @RequestBody BigDecimal amount) {
        Account account = this.AccountDetails(accountId);
        return transactionService.doWithDraw(account,amount);

    }

    @PostMapping("/transfer/{fromAccountId}/{toAccountId}")
    public TransactionEnt doTransfer(@PathVariable Long fromAccountId , @PathVariable Long toAccountId , BigDecimal amount) {
      Account fromAccount = this.AccountDetails(fromAccountId);
      Account toAccount = this.AccountDetails(toAccountId);
      return transactionService.doTransfer(fromAccount, toAccount,amount);
    }


    @GetMapping("{accountId}")
    public List<TransactionEnt> getTransactions(@PathVariable Long accountId) {

      return transactionService.getTransactionsByAccountId(accountId);

    }

  private Account AccountDetails(Long accountId) {

    return transactionService.getAccountById(accountId);
  }
}
