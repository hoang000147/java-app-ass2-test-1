/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment2.test1;

/**
 *
 * @author Asus
 */
public enum PermissionType 
{
    Edit("Allow to view or edit", 1), 
    Booking("Only allow to view and booking the service", 2),
    View("Only allow to view the services", 3),
    None("Don't have any permission", 5);
    
    private String name;
    private int id;
    
    PermissionType(String name, int id)
    {
        this.name = name;
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getId()
    {
        return id;
    }
    
    @Override
    public String toString()
    {
        return id + " " + name;
    }
}
