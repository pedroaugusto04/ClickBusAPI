/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pedro.clickbus.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Calendar;

/**
 *
 * @author pedro
 */
@Entity
public class Place {
    @Id
    private int id;
    private String name;
    private String slug;
    private String city;
    private String state;
    private Calendar createdAt;
    private Calendar updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
