/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pedro.clickbus.domain.repository;

import com.pedro.clickbus.domain.model.Place;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author pedro
 */
public interface IPlaceRepository extends JpaRepository<Place,String> {
    
    public Place findById(int id);
    
    public List<Place> findByName(String name);
    
}
