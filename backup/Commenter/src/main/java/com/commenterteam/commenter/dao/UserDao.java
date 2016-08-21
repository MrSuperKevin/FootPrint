/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commenterteam.commenter.dao;

import com.commenterteam.commenter.model.User;
import java.util.List;

/**
 *
 * @author stephen
 */
public interface UserDao {
    
    User findById(int id);
    
    User findByAccount(String account);
    
    List<User> findAll();
    
    void save(User user);
    
}
