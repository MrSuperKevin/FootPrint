/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commenterteam.commenter.service;

import com.commenterteam.commenter.dao.UserDao;
import com.commenterteam.commenter.model.Place;
import com.commenterteam.commenter.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author stephen
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    
    @Override
    public User findUserByAccount(String account) {
        return userDao.findByAccount(account);
    }

    @Override
    public List<Place> findPlaces(String account) {
        List<Place> list = (List<Place>) userDao.findByAccount(account).getPlaces();
        return list;
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        User entity = userDao.findById(user.getId());
        if(entity != null) {
//            entity.setId(user.getId());
            entity.setName(user.getName());
            entity.setAccount(user.getAccount());
            entity.setComments(user.getComments());
            entity.setPlaces(user.getPlaces());
        } else {
            userDao.save(user);
        }
    }

    @Override
    public User findUserById(int id) {
        return userDao.findById(id);
    }
    
}
