/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.cbs.service;

import com.niraj.cbs.entity.Account;
import com.niraj.cbs.repository.AccountRepository;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dell
 */
@Service
public class AccountServiceJPAImplementation implements AccountService {
    @Autowired
    AccountRepository ar;
    
    @Override
    public Account createNewAccount(Account a) {
       return ar.save(a);
    }

    @Override
    public ArrayList<Account> listAllAccounts() {
        return (ArrayList<Account>)ar.findAll();
    }

    @Override
    public Account deposit(int accNo, float amount) {
        
        Optional<Account> accResponse = findByAccNo(accNo);
        Account a = accResponse.get();
        //System.out.println(a);
        a.setAmount(a.getAmount()+amount);
        return ar.save(a);
    }

    @Override
    public int withdraw(int accNo, float amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int fundTransfer(int srcAccNo, int trgtAccNo, float amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<Account> findByAccNo(int accNo) {
        return ar.findById(accNo);
    }
    
}
