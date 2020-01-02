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
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.io.*;

public class UserManagement 
{
    private ArrayList<User> users;
    private Map<String, User> usersMap;
    
    public UserManagement()
    {
        users = new ArrayList<User>();
        usersMap = new HashMap<String, User>();
    }
    
    public boolean verifyLogIn(String username, String password)
    {
        return User.verifyLogInByUsernameAndPassword(users, username, password);
    }
    
    public boolean addUser(User user)
    {
        for (User user1 : users)
            if (user == user1) return false;  //already in list
        if (!user.getId().equals("0")) 
        {
            users.add(user);
            return true;
        }
        return false;
    }
    
    public boolean changePassword(String username, String oldPassword, String newPassword)
    {
        User user = User.findUserByUsername(users, username);
  
        if (!user.setPassword(newPassword))
        {
            return false;
        }
        return true;
    }
    
    public String getUserFullNameByUserName(String username)
    {
        return User.findUserByUsername(users, username).getFullName();
    }
    
    public User findUserByUsername(String username)
    {
        return User.findUserByUsername(users, username);
    }
    
    public ArrayList<User> getUserList()
    {
        return users;
    }
    
    public UserType logIn(String username, String password)
    {
        if (verifyLogIn(username, password))
            return findUserByUsername(username).getUserType();
        return null;
    }
    
    public void preProcess()
    {
        try
        {
            File file = new File("./customer.csv");
            if (file.exists())
            {
                FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader);
                
                while (true)
                {
                    String line = reader.readLine();
                    if (line == null)
                    {
                        reader.close();
                        break;
                    }
                    addUser(Customer.parseCsv(line));
                }
            }
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
        
        try
        {
            File file = new File("./guest.csv");
            if (file.exists())
            {
                FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader);
                
                while (true)
                {
                    String line = reader.readLine();
                    if (line == null)
                    {
                        reader.close();
                        break;
                    }
                    addUser(Guest.parseCsv(line));
                }
            }
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
        
        try
        {
            File file = new File("./staff.csv");
            if (file.exists())
            {
                FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader);
                
                while (true)
                {
                    String line = reader.readLine();
                    if (line == null)
                    {
                        reader.close();
                        break;
                    }
                    addUser(Staff.parseCsv(line));
                }
            }
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }
}
