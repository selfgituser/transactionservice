package com.anv.transactionservice.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "TRANSACTION")
public class TransactionEnt {

    private Long Id;
    private Account fromAccountId;
    private Account toAccountId;
    private BigDecimal amount;
    private String transactionType;
    private Date transactionDate;

    public TransactionEnt() {
    }

    public TransactionEnt(Long id, Account fromAccountId, Account toAccountId, BigDecimal amount, String transactionType, Date transactionDate) {
        Id = id;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_account_id")
    public Account getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Account fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_account_id")
    public Account getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Account toAccountId) {
        this.toAccountId = toAccountId;
    }

    @Column(name = "amount" , precision = 10, scale = 2)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Column(name= "transaction_type" , length= 50)
    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Column(name= "transaction_date" , length = 7)
    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }


    @Override
    public String toString() {
        return "TransactionEnt{" +
                "Id=" + Id +
                ", fromAccountId=" + fromAccountId +
                ", toAccountId=" + toAccountId +
                ", amount=" + amount +
                ", transactionType='" + transactionType + '\'' +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
