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
public class Address 
{
    private String streetNumber;
    private String streetName;
    private String surburb;
    private String city;
    private State state;
    private int postcode;
    
    public Address(String streetNumber, String streetName, String surburb, String city, State state, int postcode)
    {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.surburb = surburb;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
    }
    
    @Override
    public String toString()
    {
        return "Address [Street number: " + streetNumber + ", street name: " + streetName
                + ", surburb: " + surburb + ", city: " + city + ", state: " + state
                + ", postcode: " + postcode + "]";
    }
    
    public String getAttributeToSaveToFile()
    {
        return "streetNumberm,streetName,surburb,city,state,postcode";
    }
    
    public String getDataToSaveToFile()
    {
        return streetNumber + "," + streetName + "," + surburb + ","
                + city + "," + state + "," + postcode;
    }
    
    public void setStreetNumber(String streetNumber)
    {
        this.streetNumber = streetNumber;
    }
    
    public void setStreetName(String streetName)
    {
        this.streetName = streetName;
    }
    
    public void setSurburb(String surburb)
    {
        this.surburb = surburb;
    }
    
    public void setCity (String city)
    {
        this.city = city;
    }
    
    public void setState(State state)
    {
        this.state = state;
    }
    
    public void setPostcode(int postcode)
    {
        this.postcode = postcode;
    }
    
    public String getStreetNumber()
    {
        return streetNumber;
    }
    
    public String getStreetName()
    {
        return streetName;
    }
    
    public String getSurburb()
    {
        return surburb;
    }
    
    public String getCity()
    {
        return city;
    }
    
    public String getState()
    {
        return state.toString();
    }
    
    public int getPostcode()
    {
        return postcode;
    }
}
