/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.cbs.service;

import com.niraj.cbs.entity.Account;
import com.niraj.cbs.repository.AccountRepository;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;
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
        Account acc;
        
        try{
            Optional<Account> accResponse = ar.findById(a.getAccNo());
            if(accResponse.isPresent()){
                return null;
            }
            else{
                return ar.save(a);
            }
        }catch(NoSuchElementException ex){
            //System.out.println("NoSuchElementException triggered..");
            System.out.println(ex);
        }
        
        return null;
        
//       Optional<Account> accResponse = findByAccNo(a.getAccNo());
//       Account x;
//       try{
//           x = accResponse.get();
//       }catch(NoSuchElementException e){
//           x = null;
//       }
       
    }

    @Override
    public ArrayList<Account> listAllAccounts() {
        return (ArrayList<Account>)ar.findAll();
    }

    @Override
    public Account deposit(int accNo, float amount) {
        
        Optional<Account> accResponse = findByAccNo(accNo);
        if(accResponse.isPresent()){
            Account a = accResponse.get();
            //System.out.println(a);
            a.setAmount(a.getAmount()+amount);
            return ar.save(a);
        }
        return null;
    }

    @Override
    public Account withdraw(int accNo, float amount) {
        Optional<Account> accResponse = findByAccNo(accNo);
        if(accResponse.isPresent()){
            Account a = accResponse.get();
            //System.out.println(a);
            if(a.getAmount()<amount){
                return null;
            }
            a.setAmount(a.getAmount()-amount);
            return ar.save(a);
        }
        return null;
        
    }

    @Override
    public int fundTransfer(int srcAccNo, int trgtAccNo, float amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<Account> findByAccNo(int accNo) {
        return ar.findById(accNo);
    }

    @Override
    public boolean deleteAccount(int accNo) {
        ar.deleteById(accNo);
        return !ar.existsById(accNo);
    }

    @Override
    public ArrayList<Account> findByName(String name) {
        return ar.findAllByName(name);
    }
    
}
