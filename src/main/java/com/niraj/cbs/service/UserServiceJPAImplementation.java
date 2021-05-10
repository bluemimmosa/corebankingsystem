/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.cbs.service;

import com.niraj.cbs.entity.User;
import com.niraj.cbs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dell
 */
@Service
public class UserServiceJPAImplementation implements UserService{
    @Autowired
    UserRepository ur;
    
    @Override
    public User addUser(User u) {
        return ur.save(u);
    }

    @Override
    public User loginUser(User u) {
        User dbUser=ur.findByUname(u.getUname());
        System.out.println(dbUser);
        if(dbUser.getUpassword().equals(u.getUpassword())){
            return dbUser;
        }
        return null;
    }
    
    
}
