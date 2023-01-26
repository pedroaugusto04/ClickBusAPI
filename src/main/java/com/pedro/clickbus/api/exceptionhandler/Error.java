/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pedro.clickbus.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/**
 *
 * @author pedro
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error {

    private Integer status;
    private String description;
    private List<Field> fields;

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public List<Field> getFields() {
        return fields;
    }
    
    

}
