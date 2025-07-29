package com.anv.transactionservice.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "ACCOUNTS")
public class Account implements Serializable {

   private  Long Id;
   private  String accountHolderName;
   private BigDecimal balance;
   private String accountType;
   private Date createdAt;


    public Account() {
    }

    public Account(Long id, String accountHolderName, BigDecimal balance, String accountType, Date createdAt) {
        Id = id;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.accountType = accountType;
        this.createdAt = createdAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID" , unique = true , nullable = false)
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Column(name = "ACCOUNT_HOLDER_NAME" ,  length= 100)
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    @Column(name = "BALANCE" , precision = 10, scale = 2)
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Column(name = "ACCOUNT_TYPE" , length = 50)
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Column(name = "CREATE_AT" , length = 7)
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Account{" +
                "Id=" + Id +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                ", accountType='" + accountType + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }


}
