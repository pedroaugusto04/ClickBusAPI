/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pedro.clickbus.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import java.util.Calendar;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author pedro
 */
@Entity
public class Place {
    @NotBlank
    private String name;
    @Id
    @NotBlank
    @Column(unique = true)
    private String slug;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @CreationTimestamp
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) 
    private Calendar createdAt;
    @UpdateTimestamp
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) 
    private Calendar updatedAt;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }
    
    
}
