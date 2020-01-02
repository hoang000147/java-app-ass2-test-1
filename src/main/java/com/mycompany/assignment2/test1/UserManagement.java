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
        /*if (user == null)
        {
            user.errorReport.setError(true);
            user.errorReport.setErrorMessage("Invalid username.");
            user.errorReport.printErrorMessage();
            return false;        
        }*/
        /*if (!oldPassword.equals(user.getPassword())) 
        {
            user.errorReport.setError(true);
            user.errorReport.setErrorMessage("Wrong current password.");
            user.errorReport.printErrorMessage();
            return false;            
        }*/
  
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
    
    /*public void initializeUser()
    {
        Customer customer1 = new Customer("1000001", "AA", "AAA", "aaaa", "12345678", 
                UserType.VIP, true, new Address("a", "a", "a", "a", State.NSW, 100), "aaa@xyz.com");
        Guest guest = new Guest("2000001", "BB", "BBB", "bbbb", "12345678", true, "bbb@xyz.com");
        Staff staff1 = new Staff("3000001", "CC", "CCC", "cccc", "12345678", true, "ccc@xyz.com", "Administrator");
        Customer customer2 = new Customer("1000002", "DD", "DDD", "dddd", "12345678", 
                UserType.VIP, true, new Address("d", "d", "d", "d", State.QLD, 200), "ddd@xyz.com");
        Staff staff2 = new Staff("3000002", "EE", "EEE", "eeee", "12345678", true, "eee@xyz.com", "Some position");
        
        if (!customer1.getId().equals("0")) addUser(customer1);
        if (!customer2.getId().equals("0")) addUser(customer2);
        if (!staff1.getId().equals("0")) addUser(staff1);
        if (!staff2.getId().equals("0")) addUser(staff2);
        if (!guest.getId().equals("0")) addUser(guest);
    }*/
    
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
            File file = new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\Assignment2-test1\\customer.csv");
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
            File file = new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\Assignment2-test1\\guest.csv");
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
            File file = new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\Assignment2-test1\\staff.csv");
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
