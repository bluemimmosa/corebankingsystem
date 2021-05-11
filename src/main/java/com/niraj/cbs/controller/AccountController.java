/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.cbs.controller;

import com.niraj.cbs.entity.Account;
import com.niraj.cbs.entity.User;
import com.niraj.cbs.service.AccountService;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dell
 */
@Controller
public class AccountController {
    @Autowired
    AccountService as;
    
    @GetMapping("/listallaccounts")
    public ModelAndView showListOfAllAccounts(HttpSession session){
        if(session.getAttribute("username") == null){
            ModelAndView mav = new ModelAndView("dashboard");
            mav.addObject("message", "Login is required to do that.");
            return mav;
        }
        ArrayList<Account> accList = as.listAllAccounts();
        ModelAndView mav = new ModelAndView("listallaccountsView");
        mav.addObject("accList", accList);
        return mav;
    }
    
    @GetMapping("/deposit")
    public ModelAndView showDepositForm(HttpSession session){
        if(session.getAttribute("username") == null){
            ModelAndView mav = new ModelAndView("dashboard");
            mav.addObject("message", "Login is required to do that.");
            return mav;
        }
        ModelAndView mav = new ModelAndView("depositForm");
        mav.addObject("deposit", new Account());
        return mav;
    }
    
    @PostMapping("/depositProcess")
    public ModelAndView depositProcess(@ModelAttribute ("deposit") Account acc, HttpSession session){
        ModelAndView mav = new ModelAndView("dashboard");
        if(session.getAttribute("username") == null){
            mav.addObject("message", "Login is required to do that.");
            return mav;
        }
        if(as.deposit(acc.getAccNo(), acc.getAmount()) == null)
            mav.addObject("message", "Cannot Deposit, Something Wrong with account information!!");
        else
            mav.addObject("message", "Deposit successful!!");
        return mav;
    }
}
