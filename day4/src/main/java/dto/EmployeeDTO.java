/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Employee;

/**
 *
 * @author PC
 */
public class EmployeeDTO {
    private int id;
    private String name;
    private String addressString;

    public EmployeeDTO(Employee e) {
        this.id = e.getId();
        this.name = e.getName();
        this.addressString = e.getAddressString();
    }
    
  
}
