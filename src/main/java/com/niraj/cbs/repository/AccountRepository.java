/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.cbs.repository;

import com.niraj.cbs.entity.Account;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Dell
 */
@Repository
public interface AccountRepository extends JpaRepository<Account,Integer>{
    
    @Query(value = "SELECT * FROM account WHERE account.name LIKE :name%", nativeQuery = true)
    public ArrayList<Account> findAllByName(@Param("name")String name);    
}
