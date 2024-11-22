package com.example.Banking.Controller;

import com.example.Banking.Model.Banking;
import com.example.Banking.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/create")
    public Banking createAccount(@RequestBody Banking banking){
        return accountService.createAccount(banking);
    }



    @GetMapping("/all")
    public List<Banking> getAllAccount(){
        return accountService.getAllAccount();
    }


    @GetMapping("/{id}")
    public Optional<Banking> getAccount(@PathVariable Long id){
        return accountService.getAccountById(id);
    }

    @PostMapping("/{id}/deposit")
    public Banking deposit(@PathVariable Long id,@RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
        return accountService.deposit(id,amount);
    }


    @PostMapping("/{id}/withdraw")
    public Banking withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
        return accountService.withdraw(id,amount);
    }

}
