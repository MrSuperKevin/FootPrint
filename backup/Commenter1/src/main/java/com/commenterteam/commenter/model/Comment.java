/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commenterteam.commenter.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author stephen
 */
@Entity
@Table(name = "APP_COMMENT")
public class Comment implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "TEXT")
    private String text;
    
    @Column(name = "IMAGE")
    private String image;
    
    @Column(name = "APPROVE")
    private Integer approve;
    
    @Column(name = "TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_COMMENT",
                joinColumns = {@JoinColumn(name = "COMMENT_ID")},
                inverseJoinColumns = {@JoinColumn(name = "USER_ID")})
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getApprove() {
        return approve;
    }

    public void setApprove(Integer approve) {
        this.approve = approve;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", text=" + text + ", image=" + image + ", approve=" + approve + ", time= " + time.toString() + ", user=" + user.getName() + '}';
    }
    
    
}
