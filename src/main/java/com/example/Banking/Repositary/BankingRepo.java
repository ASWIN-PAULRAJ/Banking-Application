package com.example.Banking.Repositary;

import com.example.Banking.Model.Banking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankingRepo extends JpaRepository<Banking,Long> {

}
