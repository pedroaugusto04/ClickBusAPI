/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pedro.clickbus.domain.service;

import com.pedro.clickbus.domain.model.Place;
import java.util.List;

/**
 *
 * @author pedro
 */
public interface IPlaceService {
    
    public Place savePlace(Place place);
    
    public Place getPlace(int id);
    
    public List<Place> getPlaces();
    
    public List<Place> getPlaces(String name);
    
    public void updatePlace(Place place, int id);  
    
    public void placeAlreadyRegistered(Place place);
}
