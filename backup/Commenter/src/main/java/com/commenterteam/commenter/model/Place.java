/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commenterteam.commenter.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author stephen
 */
@Entity
@Table(name = "APP_PLACE")
public class Place implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "LAT")
    private Integer lat;
    
    @Column(name = "LON")
    private Integer lon;
    
    @Column(name = "IMAGE")
    private String image;
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "PLACE_COMMENT",
                joinColumns = {@JoinColumn(name = "PLACE_ID")},
                inverseJoinColumns = {@JoinColumn(name = "COMMENT_ID")})
    private Set<Comment> comments = new HashSet<>();
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_PLACE",
                joinColumns = {@JoinColumn(name = "PLACE_ID")},
                inverseJoinColumns = {@JoinColumn(name = "USER_ID")})
    private Set<User> users = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLat() {
        return lat;
    }

    public void setLat(Integer lat) {
        this.lat = lat;
    }

    public Integer getLon() {
        return lon;
    }

    public void setLon(Integer lon) {
        this.lon = lon;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Place{" + "id=" + id + ", name=" + name + ", lat=" + lat + ", lon=" + lon + '}';
    }
    
    
    
}
