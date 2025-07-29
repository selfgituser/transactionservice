package com.anv.transactionservice.util;

// Custom checked exception (extend Exception)
public class InsufficientFundsException extends RuntimeException {

    // Constructor with custom message
    public InsufficientFundsException(String message) {
        super(message);
    }
}

