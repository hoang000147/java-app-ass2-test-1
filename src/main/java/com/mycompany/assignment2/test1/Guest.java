/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment2.test1;

import static java.lang.System.out;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class Guest extends Billing
{
    
    
    public Guest(String id, String firstName, String lastName, String username,
            String password, boolean status, String email)
    {
        super(id, firstName, lastName, username, password, UserType.Guest,
              PermissionType.View, status, email);
        if (!(id.charAt(0) == '2' && id.length() == 7))
            super.setId("0");
    }
    
    public Guest(String id, String firstName, String lastName, String username,
            String password, boolean status)
    {
        super(id, firstName, lastName, username, password, UserType.Guest,
                PermissionType.View, status);
        if (!(id.charAt(0) == '2' && id.length() == 7))
            super.setId("0");
    }
    
    public static Guest parseCsv(String line)
    {
        String[] input = line.split(",");
        boolean status = Boolean.parseBoolean(input[5]);
        Guest guest = null;
        if (input.length == 7)
        {
            guest = new Guest(input[0], input[1], input[2], input[3], input[4], status, input[6]);
        }
        else
        {
            guest = new Guest(input[0], input[1], input[2], input[3], input[4], status);
        }
        return guest;  
    }
    
    @Override
    protected boolean setId(String id)
    {
        if (id.charAt(0) == '2' && id.length() == 7)
            return(super.setId(id));
        else return false;
    }
    
    @Override
    public boolean setPermission(PermissionType permission)
    {
        if (permission == PermissionType.View || permission == PermissionType.None)
            return(super.setPermission(permission));
        else return false;
    }
    
    public static ArrayList<Guest> filterOnlyCustomerList(ArrayList<User> users)
    {
        ArrayList<Guest> guests = new ArrayList<Guest>();
        for (User user : users)
        {
            if (user.getGuest() != null) 
            {
                Guest other = (Guest) user;
                guests.add(other);
            }
        }
        return guests;
    }
    
    @Override
    public Customer getCustomer()
    {
        return null;
    }
    
    @Override
    public Guest getGuest()
    {
        return this;
    }
    
    @Override
    public Staff getStaff()
    {
        return null;
    }
}
