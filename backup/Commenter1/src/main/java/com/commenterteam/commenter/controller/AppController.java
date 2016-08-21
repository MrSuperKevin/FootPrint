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
import com.commenterteam.commenter.service.CommentService;
import com.commenterteam.commenter.service.PlaceService;
import com.commenterteam.commenter.service.UserService;
import java.util.Set;
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
    
    @Autowired
    UserService userService;
    
    @Autowired
    PlaceService placeService;
    
    @Autowired
    CommentService commentService;
    
    @RequestMapping("/place/{placeId}/user/{userId}")
    public String indexHandler(Model model, @PathVariable("placeId") String placeId, @PathVariable("userId") String userId) {
        Place place = placeService.getPlaceById(Integer.valueOf(placeId));
        model.addAttribute("place", place);
        int approve = (int)(Math.random() * 100);
        model.addAttribute("approve", approve);
        return "index";
    }
    
    @RequestMapping("/user/{userId}")
    public String getUserById(Model model, @PathVariable("userId") String userId) {
        User user = userService.findUserById(Integer.valueOf(userId));
        Set<Place> places = user.getPlaces();
        String coordinate = "";
        for(Place place:places) {
            coordinate += "[" + ((float)place.getLon() / 1000000) + "," + ((float)place.getLat() / 1000000) + ",'地址：" + place.getName() + "'],";
        }
        coordinate = coordinate.substring(0,coordinate.length()-1);
        System.out.println("===   coordinate   ===/n" + coordinate);
        model.addAttribute("user", user);
        model.addAttribute("coordinate", coordinate);
        return "map";
    }
        
    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public String index(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        
        return "test";
    }
                
//    @RequestMapping("/user/{userId}")
//    public String getUserById(Model model, @PathVariable("userId") String userId) {
//        User user = userService.findUserByAccount(userId);
//        model.addAttribute("user", user);
//        return "test";
//    }
//    
//    @RequestMapping("/place/{placeId}")
//    public String getPlaceById(Model model, @PathVariable("placeId") String placeId) {
////        Place place = placeDaoImpl.findById(Integer.valueOf(placeId));
//        Place place = placeService.getPlaceById(Integer.valueOf(placeId));
//        model.addAttribute("place", place);
//        return "index";
//    }
//    
    @RequestMapping("/comment/{commentId}")
    public String getCommentById(Model model, @PathVariable("commentId") String commentId) {
//        Comment comment = commentDaoImpl.findById(Integer.valueOf(commentId));
        Comment comment = commentService.findByCommentId(Integer.valueOf(commentId));
        model.addAttribute("comment", comment);
        return "test_comment";
    }
//    
//    @RequestMapping("/map")
//    public String map(Model model) {
//        model.addAttribute("lan", 116.417854);
//        model.addAttribute("lon", 39.921988);
//
//        return "map";
//    }
    
}
