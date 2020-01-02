/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment2.test1;

import static java.lang.System.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Asus
 */
public abstract class User implements Cloneable, Comparable<User>
{
    protected ErrorReport errorReport = new ErrorReport();
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private UserType userType;
    private PermissionType permission;
    private boolean status;
    
    public User(String id, String firstName, String lastName, String username,
            String password, UserType userType, PermissionType permission, 
            boolean status)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.permission = permission;
        this.status = status;
        if (password.length() <= 7) 
            this.id = "0";
    }
    
    protected boolean setId(String id)
    {
        this.id = id;
        return true;
    }
    
    public String getId()
    {
        return id;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public boolean setPassword(String password)
    {
        if ((password.length() <= 7)) 
            return false; 
        this.password = password;
        return true;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public boolean setFirstName(String firstName)
    {
        if (!firstName.matches("[a-z,A-Z]+")) 
            return false;
        this.firstName = firstName;
        return true;
    }
    
    public String getLastName()
    {
        return firstName;
    }
    
    public boolean setLastName(String lastName)
    {
        if (!firstName.matches("[a-z,A-Z]+")) 
            return false;
        this.lastName = lastName;
        return true;
    }
    
    public UserType getUserType()
    {
        return userType;
    }
    
    public boolean setUserType(UserType userType)
    {
        this.userType = userType;
        return true;
    }
    
    public PermissionType getPermission()
    {
        return permission;
    }
    
    public boolean setPermission(PermissionType permission)
    {
        this.permission = permission;
        return true;
    }
    
    public String getFullName()
    {
        return firstName +  " " + lastName;
    }
    
    public boolean verifyUsernameAndPassword(String username, String password)
    {
        if ((username.equals(this.username)) && (password.equals(this.password)))
                return true;
        else return false;
    }
    
    public boolean verifyUsername(String username)
    {
        if (username.equals(this.username)) return true;
        else return false;
    }
    
    public boolean veifyUserType(UserType userType)
    {
        if (this.userType == userType) return true;
        else return false;
    }
    
    public boolean veifyPermissionType(PermissionType permission)
    {
        if (this.permission == permission) return true;
        else return false;
    }
    
    @Override
    public User clone() throws CloneNotSupportedException
    {
        try
        {
            User other = (User) super.clone();
            return other;
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public int compareTo(User other)
    {
        return this.getId().compareTo(other.getId());
    }
    
    @Override
    public String toString()
    {
        return "id = " + id + ", First name = " + firstName + ", Last name = "
                + lastName + ", Username = " + username + ", User type = " +
                userType + ", Permission type = " + permission + ", Status = "
                + status;
    }
    
    public String getAttributeToSaveToFile()
    {
        return "id,firstName,lastName,username,userType,permission,status";
    }
    
    public String getDataToSaveToFile()
    {
        return id + "," + firstName + "," + lastName + "," + username
                + "," + userType + "," + permission + "," + status;
    }
    
    public static User findUserByUsername(ArrayList<User> users, String username)
    {
        for (User user : users)
            if (user.verifyUsername(username)) return user;
        return null;
    }
    
    public static boolean verifyLogInByUsernameAndPassword(ArrayList<User> users, 
                                        String username, String password)
    {
        for (User user : users)
            if (user.verifyUsernameAndPassword(username, password)) return true;
        return false;
    }
    
    public static ArrayList<User> filterUserByUserType(ArrayList<User> users, UserType userType)
    {
        ArrayList<User> result = new ArrayList<User>();
        
        for (User user : users)
        {
            if (user.getUserType() == userType) 
                result.add(user);
        }
        return result;
    }
    
    public static ArrayList<String> getListOfUserFullName(ArrayList<User> users)
    {
        ArrayList<String> stringList = new ArrayList<String>();
        for (User user : users)
            stringList.add(user.getFullName());
        return stringList;
    }
    
    public static Map<String,User> getMapOfUserWithUsernameAsKey(ArrayList<User> users)
    {
        Map<String, User> userMap = new HashMap<String, User>();
        for (User user : users)
            userMap.put(user.getUsername(), user);
        return userMap;
    }
    
    public static Map<String, User> getMapOfUserWithLastNameAsKey(ArrayList<User> users)
    {
        Map<String, User> userMap = new HashMap<String, User>();
        for (User user : users)
            userMap.put(user.getLastName(), user);
        return userMap;
    }
    
    
    
    public abstract Customer getCustomer();
    public abstract Guest getGuest();
    public abstract Staff getStaff();
    public abstract Address getBillingAddress();
}

