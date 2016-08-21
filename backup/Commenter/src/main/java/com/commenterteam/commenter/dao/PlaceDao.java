/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commenterteam.commenter.dao;

import com.commenterteam.commenter.model.Place;
import java.util.List;

/**
 *
 * @author stephen
 */
public interface PlaceDao {
    
    Place findById(int id);
    
    Place findByPlaceName(String name);
    
    void save(Place place);
    
    List<Place> findAll();
    
}
