/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.cbs.service;

import com.niraj.cbs.entity.Account;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public interface AccountService {
    public Account createNewAccount(Account a);
    public ArrayList<Account> listAllAccounts();
    public boolean deposit(int accNo, float amount);
    public int withdraw(int accNo, float amount);
    public int fundTransfer(int srcAccNo, int trgtAccNo, float amount);
}
