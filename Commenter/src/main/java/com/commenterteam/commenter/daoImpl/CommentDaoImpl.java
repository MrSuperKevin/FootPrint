/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commenterteam.commenter.daoImpl;

import com.commenterteam.commenter.dao.AbstractDao;
import com.commenterteam.commenter.dao.CommentDao;
import com.commenterteam.commenter.model.Comment;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author stephen
 */
@Repository("commentDao")
public class CommentDaoImpl extends AbstractDao<Integer, Comment> implements CommentDao {

    @Override
    public Comment findById(int id) {
        return getByKey(id);
    }

    @Override
    public List<Comment> findAll() {
        List<Comment> comments = getEntityManager()
                                    .createQuery("SELECT c from Comment c ORDER BY c.id")
                                    .getResultList();
        return comments;
    }

    @Override
    public void save(Comment comment) {
        persist(comment);
    }

    //To be continued. Should return new ones.
    @Override
    public List<Comment> findNew(String userId, String placeId) {
        List<Comment> comments = findAll();
        List<Comment> newComments = new ArrayList<>();
        for(Comment comment: comments) {
            
        }
        return new ArrayList<>();
    }
    
}
