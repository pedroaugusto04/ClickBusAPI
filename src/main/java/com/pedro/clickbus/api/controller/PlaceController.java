/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pedro.clickbus.api.controller;

import com.pedro.clickbus.api.model.UpdatePlace;
import com.pedro.clickbus.domain.exception.AlreadyRegisteredException;
import com.pedro.clickbus.domain.exception.NameNotFoundException;
import com.pedro.clickbus.domain.exception.SlugNotFoundException;
import com.pedro.clickbus.domain.model.Place;
import com.pedro.clickbus.domain.service.IPlaceService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pedro
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/places")
public class PlaceController {

    private IPlaceService placeService;

    public PlaceController(IPlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping
    public ResponseEntity<Place> createPlace(@Valid @RequestBody Place place) throws AlreadyRegisteredException {
        Place newPlace = placeService.savePlace(place);
        return ResponseEntity.status(201).body(newPlace);
    }

    @GetMapping("/{slug}")
    public ResponseEntity<Place> getPlace(@PathVariable String slug) throws SlugNotFoundException {
        Place place = placeService.getPlace(slug);
        return ResponseEntity.ok(place);

    }

    @GetMapping
    public ResponseEntity<List<Place>> getPlaces() {
        List<Place> places = placeService.getPlaces();
        return ResponseEntity.ok(places);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Place>> getPlacesByName(@PathVariable String name) throws NameNotFoundException {
        List<Place> places = placeService.getPlaces(name);
        return ResponseEntity.ok(places);
    }

    @PutMapping("/{slug}")
    public ResponseEntity<Object> updatePlace(@Valid @RequestBody UpdatePlace updatePlace, @PathVariable String slug) throws SlugNotFoundException {
        placeService.updatePlace(updatePlace.getPlace(), slug);
        return ResponseEntity.noContent().build();
    }

}
