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

import java.util.ArrayList;

public class Customer extends Billing
{
    private Address customerAddress;
   
    
    public Customer(String id, String firstName, String lastName, String username,
            String password, UserType userType, 
            boolean status, Address billingAddress, String email, Address customerAddress)
    {
        super(id, firstName, lastName, username,
            password, userType, PermissionType.Booking, 
            status, billingAddress, email);
        this.customerAddress = customerAddress;
        if (!(id.charAt(0) == '1' && id.length() == 7))
            super.setId("0");     
    }
    
    public Customer(String id, String firstName, String lastName, String username,
            String password, UserType userType,
            boolean status, Address address, String email)
    {
        super(id, firstName, lastName, username,
            password, userType, PermissionType.Booking, 
            status, address, email);
        this.customerAddress = null;
        if (!(id.charAt(0) == '1' && id.length() == 7))
            super.setId("0");     
    }
    
    public static Customer parseCsv(String line)
    {
        String[] input = line.split(",");
        
        UserType userType = UserType.parseCsv(input[5]);
        boolean status = Boolean.parseBoolean(input[6]);
        Customer customer = null;
        if (input.length == 20)
        {
            State state1 = State.parseCsv(input[11]);
            int postcode1 = Integer.parseInt(input[12]);
            Address address1 = new Address(input[7], input[8], input[9], input[10], state1, postcode1);
            
            State state2 = State.parseCsv(input[18]);
            int postcode2 = Integer.parseInt(input[19]);
            Address address2 = new Address(input[14], input[15], input[16], input[17], state2, postcode2);
            
            customer = new Customer(input[0], input[1], input[2], input[3], input[4], userType, status, address1, input[13], address2);
        }
        else
        {
            State state = State.parseCsv(input[11]);
            int postcode = Integer.parseInt(input[12]);
            Address address = new Address(input[7], input[8], input[9], input[10], state, postcode);
            customer = new Customer(input[0], input[1], input[2], input[3], input[4], userType, status, address, input[13]);
        }
        return customer;  
    }
    
    @Override
    protected boolean setId(String id)
    {
        if (id.charAt(0) == '1' && id.length() == 7) 
            return(super.setId(id));
        else return false;
    }
    
    @Override
    public boolean setPermission(PermissionType permission)
    {
        if (permission == PermissionType.Booking || permission == PermissionType.None)
            return(super.setPermission(permission));
        else return false;
    }
    
    public Address getCustomerAddress()
    {
        return customerAddress;
    }
    
    public void setCustomerAddress(Address customerAddress)
    {
        this.customerAddress = customerAddress;
    }
    
    public static ArrayList<Customer> filterOnlyCustomerList(ArrayList<User> users)
    {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        for (User user : users)
        {
            if (user.getCustomer() != null) 
            {
                Customer other = (Customer) user;
                customers.add(other);
            }
        }
        return customers;
    }
    
    public static ArrayList<Customer> filterOnlyVIPCustomerList(ArrayList<User> users)
    {
        ArrayList<User> userss = (ArrayList<User>) User.filterUserByUserType(users, UserType.VIP);
        ArrayList<Customer> result = new ArrayList<Customer>();
        for (User user : userss)
            result.add( (Customer) user);
        return result;
    }
    
    @Override
    public Customer getCustomer()
    {
        return this;
    }
    
    @Override
    public Guest getGuest()
    {
        return null;
    }
    
    @Override
    public Staff getStaff()
    {
        return null;
    }
}
