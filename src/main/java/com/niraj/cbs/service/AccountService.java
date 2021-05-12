/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.cbs.service;

import com.niraj.cbs.entity.Account;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author Dell
 */
public interface AccountService {
    public Account createNewAccount(Account a);
    public Optional<Account> findByAccNo(int accNo);
    public ArrayList<Account> listAllAccounts();
    public Account deposit(int accNo, float amount);
    public Account withdraw(int accNo, float amount);
    public boolean deleteAccount(int accNo);
    public int fundTransfer(int srcAccNo, int trgtAccNo, float amount);
}
