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
public enum UserType {
    Customer("Customer"), VIP("VIP"), Guest("Guest"), Staff("Staff");
    
    private String type;
    
    UserType(String type)
    {
        this.type = type;
    }
    
    public static UserType parseCsv(String string)
    {
        switch(string)
        {
            case "Customer":
                return UserType.Customer;

            case "VIP":
                return UserType.VIP;

            case "Guest":
                return UserType.Guest;

            case "Staff":
                return UserType.Staff;

            default: return null;
        }
    }
}
