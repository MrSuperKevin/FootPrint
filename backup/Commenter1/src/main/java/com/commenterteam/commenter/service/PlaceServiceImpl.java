package com.commenterteam.commenter.service;

import com.commenterteam.commenter.dao.PlaceDao;
import com.commenterteam.commenter.model.Place;
import com.commenterteam.commenter.api.BaiduApi;
import java.math.BigDecimal;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author stephen
 */
@Service("placeService")
public class PlaceServiceImpl implements PlaceService {

//    @Autowired
//    private BaiduApi api;
    
    @Autowired
    private PlaceDao placeDao;
    
    @Override
    public Place getPlaceByName(String name) {
        
        Place place = placeDao.findByPlaceName(name);
        // init place if there is no such name
        if(place == null) {
            Place newPlace = new Place();
            newPlace.setName(name);
            Map<String, BigDecimal> position = BaiduApi.getLatAndLngByAddress(name);
            newPlace.setLon(convert(position.get("lng")));
            newPlace.setLat(convert(position.get("lat")));
            // Add place picture here...
            placeDao.save(place);
        }
        return place;
    }

    @Override
    public void savePlace(Place place) {
        placeDao.save(place);
    }

    @Override
    public void updatePlace(Place place) {
        Place entity = placeDao.findById(place.getId());
        if(entity != null) {
//            entity.setId(user.getId());
            entity.setName(place.getName());
            entity.setLat(place.getLat());
            entity.setLon(place.getLon());
            // Add place picture here...

        } else {
            placeDao.save(place);
        }
    }
    
    private Integer convert(BigDecimal d) {
        return (d.intValue() * 1000000);
    }

    @Override
    public Place getPlaceById(int id) {
        return placeDao.findById(id);
    }
}
