package com.anv.transactionservice.clientinterfaces;


import com.anv.transactionservice.entity.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "accountservice" , url= "http://localhost:8084/api")
public interface AccountClient {

    @GetMapping("/account/{id}")
    public Account getAccountById(@PathVariable Long id);

}
