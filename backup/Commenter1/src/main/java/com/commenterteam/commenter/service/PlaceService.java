/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commenterteam.commenter.service;

import com.commenterteam.commenter.model.Place;

/**
 *
 * @author stephen
 */
public interface PlaceService {
    
    Place getPlaceById(int id);
    
    Place getPlaceByName(String name);
        
    void savePlace(Place place);
    
    void updatePlace(Place place);
    
}
