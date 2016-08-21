/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commenterteam.commenter.service;

import com.commenterteam.commenter.model.Comment;
import java.util.List;

/**
 *
 * @author stephen
 */
public interface CommentService {
    
    Comment findByCommentId(int id);
    
    List<Comment> findNewComments(String userId, String placeId);
    
}
