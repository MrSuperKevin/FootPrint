/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commenterteam.commenter.controller;

import com.commenterteam.commenter.daoImpl.CommentDaoImpl;
import com.commenterteam.commenter.daoImpl.PlaceDaoImpl;
import com.commenterteam.commenter.daoImpl.UserDaoImpl;
import com.commenterteam.commenter.model.Comment;
import com.commenterteam.commenter.model.Place;
import com.commenterteam.commenter.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author stephen
 */
@Controller
@RequestMapping("/")
public class AppController {
    
    @Autowired
    UserDaoImpl userDaoImpl;
    
    @Autowired
    CommentDaoImpl commentDaoImpl;
    
    @Autowired
    PlaceDaoImpl placeDaoImpl;
    
    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public String index(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        
        return "test";
    }
                
    @RequestMapping("/user/{userId}")
    public String getUserById(Model model, @PathVariable("userId") String userId) {
        User user = userDaoImpl.findById(Integer.valueOf(userId));
        model.addAttribute("user", user);
        return "test";
    }
    
    @RequestMapping("/place/{placeId}")
    public String getPlaceById(Model model, @PathVariable("placeId") String placeId) {
        Place place = placeDaoImpl.findById(Integer.valueOf(placeId));
        model.addAttribute("place", place);
        return "index";
    }
    
    @RequestMapping("/comment/{commentId}")
    public String getCommentById(Model model, @PathVariable("commentId") String commentId) {
        Comment comment = commentDaoImpl.findById(Integer.valueOf(commentId));
        model.addAttribute("comment", comment);
        return "test_comment";
    }
    
}
