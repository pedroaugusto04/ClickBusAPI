/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pedro.clickbus.domain.repository;

import com.pedro.clickbus.domain.model.Place;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pedro
 */
@Repository
public interface IPlaceRepository extends JpaRepository<Place,String> {
    
    public Optional<Place> findBySlug(String slug);
    
    public Optional<List<Place>> findByName(String name);
    
}
