/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commenterteam.commenter.service;

import com.commenterteam.commenter.dao.CommentDao;
import com.commenterteam.commenter.model.Comment;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author stephen
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;
    
    @Override
    public Comment findByCommentId(int id) {
        return commentDao.findById(id);
    }

    // To be continued. Should find the new ones
    @Override
    public List<Comment> findNewComments(String userId, String placeId) {
        return commentDao.findAll();
    }
    
}
