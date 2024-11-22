package com.example.Banking.Service;

import com.example.Banking.Model.Banking;
import com.example.Banking.Repositary.BankingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private BankingRepo bankingRepo;

    public Banking createAccount(Banking banking){
        return bankingRepo.save(banking);
    }



    public Optional<Banking> getAccountById(Long id){
        return bankingRepo.findById(id);
    }
    public List<Banking> getAllAccount(){
        return bankingRepo.findAll();
    }
    public Optional<Banking> getAccount(Long id){
        return bankingRepo.findById(id);
    }

    public Banking deposit(Long id , Double amount){
        Banking banking = getAccount(id).orElseThrow(()->new RuntimeException("Account not found"));
        banking.setBalance(banking.getBalance()+amount);

        return bankingRepo.save(banking);
    }

    public Banking withdraw(Long id, Double amount){
        Banking banking = getAccount(id).orElseThrow(()-> new RuntimeException("Account Not Found"));
        if(banking.getBalance()<amount){
            throw new RuntimeException ("Insufficient Balance");
        }

        banking.setBalance((long) (banking.getBalance()-amount));
        return bankingRepo.save(banking);
    }
}
