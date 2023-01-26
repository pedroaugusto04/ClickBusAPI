/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pedro.clickbus.domain.service;

import com.pedro.clickbus.domain.exception.AlreadyRegisteredException;
import com.pedro.clickbus.domain.exception.NameNotFoundException;
import com.pedro.clickbus.domain.exception.SlugNotFoundException;
import com.pedro.clickbus.domain.model.Place;
import com.pedro.clickbus.domain.repository.IPlaceRepository;
import java.lang.reflect.Field;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author pedro
 */
@Service
public class PlaceService implements IPlaceService {

    private IPlaceRepository placeRepository;

    public PlaceService(IPlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public Place savePlace(Place place) throws AlreadyRegisteredException {
        isPlaceAlreadyRegistered(place);
        return placeRepository.save(place);
    }

    @Override
    public Place getPlace(String slug) throws SlugNotFoundException {
        Place place = placeRepository.findBySlug(slug).orElseThrow(() -> new SlugNotFoundException());
        return place;

    }

    @Override
    public List<Place> getPlaces() {
        return placeRepository.findAll();
    }

    @Override
    public List<Place> getPlaces(String name) throws NameNotFoundException {
        List<Place> places = placeRepository.findByName(name).orElseThrow(() -> new NameNotFoundException());
        return places;
    }

    @Override
    public void updatePlace(Place newPlace, String slug) throws SlugNotFoundException {
        Place oldPlace = placeRepository.findBySlug(slug).orElseThrow(() -> new SlugNotFoundException());
        updateFields(newPlace, oldPlace);
        newPlace.setSlug(oldPlace.getSlug());
        newPlace.setCreatedAt(oldPlace.getCreatedAt());
        placeRepository.save(newPlace);
    }

    @Override
    public void isPlaceAlreadyRegistered(Place place) throws AlreadyRegisteredException {
        if (placeRepository.findBySlug(place.getSlug()).isPresent()) {
            throw new AlreadyRegisteredException();
        }
    }

    @Override
    public void updateFields(Place newPlace, Place oldPlace) {
        Field[] fields = newPlace.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.get(newPlace) == null) {
                    field.set(newPlace, field.get(oldPlace));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
