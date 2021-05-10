/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.cbs.service;

import com.niraj.cbs.entity.User;

/**
 *
 * @author Dell
 */
public interface UserService {
    public User addUser(User u);
    public User loginUser(User u);
}
