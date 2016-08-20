/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commenterteam.commenter.dao;

import com.commenterteam.commenter.model.Comment;
import java.util.List;

/**
 *
 * @author stephen
 */
public interface CommentDao {
    
    Comment findById(int id);
    
    List<Comment> findAll();
    
    void save(Comment comment);
    
    List<Comment> findNew(String userId, String placeId);
    
}
