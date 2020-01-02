/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment2.test1;

import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class Staff extends Billing
{
    String position;
    
    public Staff(String id, String firstName, String lastName, String username,
            String password, boolean status, String email, String position)
    {
        super(id, firstName, lastName, username, password, UserType.Staff, 
                PermissionType.Edit, status, email);
        if (!(id.charAt(0) == '3' && id.length() == 7))
            super.setId("0");
       this.position = position;
    }
    
    public static Staff parseCsv(String line)
    {
        String[] input = line.split(",");
        boolean status = Boolean.parseBoolean(input[5]);
        Staff staff = new Staff(input[0], input[1], input[2], input[3], input[4], status, input[6], input[7]);        
        return staff;  
    }
    
    @Override
    protected boolean setId(String id)
    {
        if (id.charAt(0) == '3' && id.length() == 7) 
            return(super.setId(id));
        else
            return false;
    }
    
    @Override
    public boolean setPermission(PermissionType permission)
    {
        if (permission == PermissionType.Booking || permission == PermissionType.None)
            return(super.setPermission(permission));
        else return false;
    }
    
    public static ArrayList<Staff> filterOnlyStaffList(ArrayList<User> users)
    {
        ArrayList<Staff> staffs = new ArrayList<Staff>();
        for (User user : users)
        {
            if (user.getStaff() != null) 
            {
                Staff other = (Staff) user;
                staffs.add(other);
            }
        }
        return staffs;
    }
    
    @Override
    public Customer getCustomer()
    {
        return null;
    }
    
    @Override
    public Guest getGuest()
    {
        return null;
    }
    
    @Override
    public Staff getStaff()
    {
        return this;
    }
}
