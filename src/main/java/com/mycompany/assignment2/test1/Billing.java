/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment2.test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Asus
 */
public abstract class Billing extends User
{
    
    private Address billingAddress;
    private String email;
    
    public Billing(String id, String firstName, String lastName, String username,
            String password, UserType userType, PermissionType permission, 
            boolean status, Address billingAddress, String email)
    {
        super(id, firstName, lastName, username, password, userType, permission, status);
        this.billingAddress = billingAddress;
        this.email = email;
        if (!isValid(email))
            super.setId("0");
    }
    
    public Billing(String id, String firstName, String lastName, String username,
            String password, UserType userType, PermissionType permission, 
            boolean status, String email)
    {
        super(id, firstName, lastName, username, password, userType, permission, status);        
        this.billingAddress = null;  //blank default
        this.email = email; 
        if (!isValid(email))
            super.setId("0");
    }
    
    public Billing(String id, String firstName, String lastName, String username,
            String password, UserType userType, PermissionType permission, 
            boolean status)
    {
        super(id, firstName, lastName, username, password, userType, permission, status);
        this.billingAddress = null;  //default
        this.email = null;  //default
    }
    
    public boolean isValid(String email)
    {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
        return email.matches(regex);
    }
    
    @Override
    public Address getBillingAddress()
    {
        return billingAddress;
    }
    
    public void setBillingAddress(Address billingAddress)
    {
        this.billingAddress = billingAddress;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public boolean setEmail(String email)
    {
        if (!isValid(email))
            return false;
        this.email = email;
        return true;
    }
    
    @Override
    public String toString()
    {
        return super.toString() + ", billing address: " + billingAddress + 
                ", email: " + email;
    }
    
    /*@Override
    public String getAttributeToSaveToFile()
    {
        return super.getAttributeToSaveToFile() + 
                "," + billingAddress.getAttributeToSaveToFile() + ",email";
    }
    
    @Override
    public String getDataToSaveToFile()
    {
        return super.getDataToSaveToFile() + "," + billingAddress.getDataToSaveToFile()
                + "," + email;
    }*/
    
    public static ArrayList<Billing> filterOnlyBillingList(ArrayList<User> users)
    {
        ArrayList<Billing> billings = new ArrayList<Billing>();
        for (User user : users)
        {
            if (user.getBillingAddress() != null) 
            {
                Billing other = (Billing) user;
                billings.add(other);
            }
        }
        return billings;
    }
    
    public static Comparator<Billing> LastNameComparator = new Comparator<Billing>()
    {
        @Override
        public int compare(Billing object1, Billing object2)
        {
            return object1.getLastName().compareTo(object2.getLastName());
        }
    };
    
    public static Comparator<Billing> FirstNameComparator = new Comparator<Billing>()
    {
        @Override
        public int compare(Billing object1, Billing object2)
        {
            return object1.getFirstName().compareTo(object2.getFirstName());
        }
    };
    
    public static Comparator<Billing> UsernameComparator = new Comparator<Billing>()
    {
        @Override
        public int compare(Billing object1, Billing object2)
        {
            return object1.getUsername().compareTo(object2.getUsername());
        }
    };
    
    public static Comparator<Billing> EmailComparator = new Comparator<Billing>()
    {
        @Override
        public int compare(Billing object1, Billing object2)
        {
            return object1.getEmail().compareTo(object2.getEmail());
        }
    };
    
    @Override
    public int compareTo(User other)
    {
        return this.getUsername().compareTo(other.getUsername());
    }
    
    public static ArrayList<Billing> sortCustomer(ArrayList<User> users, int number)
    {
        ArrayList<Billing> billings = filterOnlyBillingList(users);
        if (number == 1) 
        {
            Collections.sort(users);
            return filterOnlyBillingList(users);
        }
        if (number == 2) 
        {
            Collections.sort(billings);
            return billings;
        }
        //if (number == 3) Collections.sort(billings, UsernameComparator);
        //if (number == 4) Collections.sort(billings, EmailComparator);
        return null;
    }
    
    public static void sortedListByEmail(ArrayList<Billing> billings)
    {
        Collections.sort(billings, EmailComparator);
    }
    
    @Override
    public abstract Customer getCustomer();
    @Override
    public abstract Guest getGuest();
    @Override
    public abstract Staff getStaff();
}
