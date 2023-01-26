/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pedro.clickbus.domain.service;

import com.pedro.clickbus.domain.exception.AlreadyRegisteredException;
import com.pedro.clickbus.domain.exception.NameNotFoundException;
import com.pedro.clickbus.domain.exception.SlugNotFoundException;
import com.pedro.clickbus.domain.model.Place;
import java.util.List;

/**
 *
 * @author pedro
 */
public interface IPlaceService {
    
    public Place savePlace(Place place) throws AlreadyRegisteredException;
    
    public Place getPlace(String slug) throws SlugNotFoundException;
    
    public List<Place> getPlaces();
    
    public List<Place> getPlaces(String name) throws NameNotFoundException;
    
    public void updatePlace(Place place, String slug) throws SlugNotFoundException;  
    
    public void isPlaceAlreadyRegistered(Place place) throws AlreadyRegisteredException;
    
    public void updateFields(Place newPlace, Place oldPlace);
}
