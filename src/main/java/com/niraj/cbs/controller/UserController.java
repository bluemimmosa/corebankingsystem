/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.cbs.controller;

import com.niraj.cbs.entity.User;
import com.niraj.cbs.service.UserService;
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
public class UserController {
    @Autowired
    UserService us;
    @GetMapping("/")
    public ModelAndView showHomePage(){
        ModelAndView mav = new ModelAndView("loginForm");
        mav.addObject("newUser", new User());
        return mav;
    } 
    
    @GetMapping("/logout")
    public ModelAndView showLoginPage(HttpSession session){
        session.invalidate();
        return showHomePage();
    }
    
    @PostMapping("/loginProcess")
    public ModelAndView processLogin(@ModelAttribute ("newUser") User user, HttpSession session){
        ModelAndView mav = new ModelAndView();
        User loggedInUser = us.loginUser(user);
        if(loggedInUser != null){
            mav.setViewName("dashboard");
            mav.addObject("message", "Welcome to Core Banking System.");
            session.setAttribute("username",loggedInUser.getUname());
        }
        else{
            mav.setViewName("loginForm");
            mav.addObject("message", "Login Credentials Invalid!!!");
            //user or passsord not valid.
        }
        return mav;
    }
}
