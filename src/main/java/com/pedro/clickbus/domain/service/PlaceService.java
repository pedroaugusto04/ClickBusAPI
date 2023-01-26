/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pedro.clickbus.domain.service;

import com.pedro.clickbus.domain.model.Place;
import com.pedro.clickbus.domain.repository.IPlaceRepository;
import java.util.List;

/**
 *
 * @author pedro
 */
public class PlaceService implements IPlaceService {
    
    private IPlaceRepository placeRepository;

    public PlaceService(IPlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public Place savePlace(Place place) {
        //if (placeAlreadyRegistered)
        return placeRepository.save(place);
        
    }

    @Override
    public Place getPlace(int id) {
        // id not found exception
        return placeRepository.findById(id);
        
    }

    @Override
    public List<Place> getPlaces() {
        return placeRepository.findAll();
    }

    @Override
    public List<Place> getPlaces(String name) {
        return placeRepository.findByName(name);
    }

    @Override
    public void updatePlace(Place newPlace, int id) {
        Place oldPlace = placeRepository.findById(id);
        newPlace.setId(oldPlace.getId());
        placeRepository.save(newPlace);
    }

    @Override
    public void placeAlreadyRegistered(Place place) {
        //
    }
    
    
}
