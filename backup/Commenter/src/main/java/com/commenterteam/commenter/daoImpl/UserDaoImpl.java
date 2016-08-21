/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commenterteam.commenter.daoImpl;

import com.commenterteam.commenter.dao.AbstractDao;
import com.commenterteam.commenter.dao.UserDao;
import com.commenterteam.commenter.model.User;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author stephen
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

    @Override
    public User findById(int id) {
        User user = getByKey(id);
        /** use this to initialize sub pros when change FetchType.EAGER to FetchType.LAZY
        if(user != null) {
            initializeCollection(user.getComments());
        }
        */
//        if(user != null) {
//            initializeCollection(user.getComments());
//            initializeCollection(user.getPlaces());
//        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users = getEntityManager()
                            .createQuery("SELECT u FROM User u ORDER BY u.id")
                            .getResultList();
        return users;
    }

    @Override
    public void save(User user) {
        persist(user);
    }
    
//    protected void initializeCollection(Collection<?> collection) {
//        if(collection == null) {
//            return;
//        }
//        collection.iterator().hasNext();
//    }

    @Override
    public User findByAccount(String account) {
        User user = (User) getEntityManager()
                        .createQuery("SELECT u FROM User u WHERE u.account LIKE :account")
                        .setParameter("account", account)
                        .getSingleResult();
        return user;
    }
    
}
