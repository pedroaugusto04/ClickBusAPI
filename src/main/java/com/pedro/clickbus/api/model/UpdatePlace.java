/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pedro.clickbus.api.model;

import com.pedro.clickbus.domain.model.Place;
import com.pedro.clickbus.domain.validation.ValidationGroup.Update;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;

/**
 *
 * @author pedro
 */
public class UpdatePlace {
    
    @NotNull
    @Valid
    @ConvertGroup(from = Default.class, to = Update.class)
    private Place place;

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
    
    
}
