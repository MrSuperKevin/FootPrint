/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commenterteam.commenter.service;

import com.commenterteam.commenter.model.Place;
import com.commenterteam.commenter.model.User;
import java.util.List;

/**
 *
 * @author stephen
 */
public interface UserService {
    
    User findUserById(int id);
    
    User findUserByAccount(String account);
    
    List<Place> findPlaces(String account);
        
    void save(User user);
    
    void update(User user);
    
}
