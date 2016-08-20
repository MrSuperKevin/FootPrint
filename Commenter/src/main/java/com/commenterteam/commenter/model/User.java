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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author stephen
 */
@Entity
@Table(name = "APP_USER")
public class User implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "ACCOUNT")
    private String account;
    
    @Column(name = "NAME")
    private String name;
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_COMMENT",
                joinColumns = {@JoinColumn(name = "USER_ID")},
                inverseJoinColumns = {@JoinColumn(name = "COMMENT_ID")})
    private Set<Comment> comments = new HashSet<>();
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_PLACE",
                joinColumns = {@JoinColumn(name = "USER_ID")},
                inverseJoinColumns = {@JoinColumn(name = "PLACE_ID")})
    private Set<Place> places = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Place> getPlaces() {
        return places;
    }

    public void setPlaces(Set<Place> places) {
        this.places = places;
    }

    /**
     * CAUTION!!! TOSTRING SETS WILL CAUSE STACKOVERFLOW
     * @return 
     */
    @Override
    public String toString() {
//        return "User{" + "id=" + id + ", account=" + account + ", name=" + name + ", comments=" + comments + ", places=" + places + '}';
        return "User{" + "id=" + id + ", account=" + account + ", name=" + name + '}';
    }
    
    
    
}
