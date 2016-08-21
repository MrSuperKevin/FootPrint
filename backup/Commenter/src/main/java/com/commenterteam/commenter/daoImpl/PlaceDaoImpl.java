/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commenterteam.commenter.daoImpl;

import com.commenterteam.commenter.dao.AbstractDao;
import com.commenterteam.commenter.dao.PlaceDao;
import com.commenterteam.commenter.model.Place;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author stephen
 */
@Repository("placeDao")
public class PlaceDaoImpl extends AbstractDao<Integer, Place> implements PlaceDao {

    @Override
    public Place findById(int id) {
        Place place = getByKey(id);
//        if(place != null) {
//            initializeCollection(place.getComments());
//            initializeCollection(place.getUsers());
//        }
        return getByKey(id);
    }

    @Override
    public void save(Place place) {
        persist(place);
    }

    @Override
    public List<Place> findAll() {
        List<Place> places = getEntityManager()
                                    .createQuery("SELECT p from Place p ORDER BY p.id")
                                    .getResultList();
        return places;
    }
    
    protected void initializeCollection(Collection<?> collection) {
        if(collection == null) {
            return;
        }
        collection.iterator().hasNext();
    }

    @Override
    public Place findByPlaceName(String name) {
        Place place = (Place) getEntityManager()
                        .createQuery("SELECT p FROM Place p WHERE p.name LIKE :name")
                        .setParameter("name", name)
                        .getSingleResult();
        return place;
    }
}
