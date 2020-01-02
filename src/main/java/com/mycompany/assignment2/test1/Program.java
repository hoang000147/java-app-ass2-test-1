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
import static java.lang.System.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Program 
{
    private UserManagement userManagement = new UserManagement(); 
    private ServicesManagement servicesManagement = new ServicesManagement();
    private BookingManagement bookingManagement = new BookingManagement();
    private String username;
    private String password;
    private ArrayList<User> users ;
    private ArrayList<Service> services;
    private ArrayList<BookingRecord> bookings;
	private Scanner input;
    
    
    
    public static void main(String[] args)
    {
        Program program = new Program();
        //program.runCoreLevel();
        program.displayMenu();
    }
    
    
    
    public void preProcess()
    {               
        userManagement.preProcess();
        users = userManagement.getUserList();
        servicesManagement.preProcess();
        services = servicesManagement.getServiceList();
        bookingManagement.preProcess(users, services);
        bookings = bookingManagement.getBookingList();
		input = new Scanner(in);
    }
    
    public UserType logIn()
    {
        //Scanner userInput = new Scanner(in);
        
        while (true)        
        {            
            out.print("Enter username: ");
            username = input.next();
            out.print("Enter password: ");
            password = input.next();
            
            if (userManagement.logIn(username, password) != null)
                return userManagement.logIn(username, password);
            else out.println("Login failed. Try again.");
        }
    }
    
    public void displayMenu()
    {
        preProcess();
        UserType userType = logIn();
        out.println("The User Type is " + userType);
        
        if (userType == UserType.Staff) displayMenuForStaff();
        else displayMenuForCustomerAndGuest();
        
        
    }   
    
    public void menu1()
    {
        out.println(userManagement.getUserFullNameByUserName(username));
    }
    
    public void menu2()
    {
        out.println("Please enter new password: ");
        //Scanner input = new Scanner(in);
        
        String newPassword = input.next();
        if (userManagement.changePassword(username, password, newPassword) == false) 
            out.println("Error. Password change uncessfully.");     
        else 
        {
            password = newPassword;  
            //update password (the one is used for this current log in session)
            out.println("Password changed successfully");
        }
    }
    
    public void menu3()
    {
        ArrayList<Customer> customers = Customer.filterOnlyCustomerList(userManagement.getUserList());
        out.println("The customers' emails are: ");
        for (Customer customer : customers)
            out.println(customer.getEmail());
    }
    
    public void menu4()
    {
        //Scanner input = new Scanner(in);
        out.println("Please choose what attribute to sort by: ");
        out.println("Sort by id: 1");
        //out.println("Sort by first name: 2");
        out.println("Sort by username: 2");
        //out.println("Sort by email: 4");
        int select = input.nextInt();              
        ArrayList<Billing> billings = Billing.sortCustomer(users, select);
        for (Billing billing : billings)
            out.println(billing);

    }
    
    public void menu5()
    {
        ArrayList<Customer> customers = Customer.filterOnlyVIPCustomerList(users);
        out.println("The list of VIP Customers' emails are: ");
        for (Customer customer : customers)
            out.println(customer.getEmail());
    }
    
    public void menu6()
    {
        //input = new Scanner(in);
        out.print("Please enter the keyword you want to search: ");
        String name = input.next();
        ArrayList<Service> result = Service.findServiceByKeywordSearchOnName(services, name);
        out.println("The services found are: ");
        for (Service service : result)
            out.println(service);
    }
    
    public void menu7()
    {
        //Scanner input = new Scanner(in);
        out.println("Please enter the username you want to search: ");
        String username = input.next();
        ArrayList<BookingRecord> result = bookingManagement.findBookingRecordByUsername(username);
        out.println("The booking records found are: ");
        if (!result.isEmpty())
            for (BookingRecord booking : result)
                out.println(booking.getCoreInformation());
        else out.println("Not found.");
        
    }
    
    public void displayMenuForCustomerAndGuest()
    {
        //Scanner menuInput = new Scanner(in);
        boolean c = true;
        
        while (c)
        {
            out.println("**********");
            out.println("Press 0 to exit");
            out.println("Menu 1: Display the full name of the user.");
            out.println("Menu 2: Change password.");
            out.println("Menu 3: List all Customer's email.");
            out.println("Menu 6: Search for service name by keyword.");
            int select = input.nextInt();
            
            switch (select)
            {
                case 1:
                    menu1();
                    break;
                
                case 2:
                    menu2();
                    break;
                
                case 3:
                    menu3();
                    break;
                
                case 6:
                    menu6();
                    break;
                    
                default: 
                    out.println("Goodbye!");
                    c = false;
            }
        }
    }
    
    public void displayMenuForStaff()
    {
        //Scanner menuInput = new Scanner(in);
        boolean c = true;
        
        while (c)
        {
            out.println("**********");
            out.println("Press 0 to exit.");
            out.println("Menu 1: Display the full name of the user.");
            out.println("Menu 2: Change password.");
            out.println("Menu 3: List all Customer's email.");
            out.println("Menu 4: Sort customers by condition.");
            out.println("Menu 5: Filter VIP customers.");
            out.println("Menu 7: Search for booking record by customer's username.");
            
            int select = input.nextInt();
            
            switch (select)
            {
                case 1:
                    menu1();
                    break;
                
                case 2:
                    menu2();
                    break;
                
                case 3:
                    menu3();
                    break;
                
                case 4:
                    menu4();
                    break;
                
                case 5:
                    menu5();
                    break;
                    
                case 7:
                    menu7();
                    break;
                    
                default: 
                    out.println("Goodbye!");
                    c = false;
            }
        }
    }
    
    public void runCoreLevel()
    {
        preProcess();
        Customer customer = null;
        Guest guest = null;
        Staff staff = null;
        for (User user : users)
            if (user.getUsername().equals("petere"))
            {
                customer = (Customer) user;
            }
        
        for (User user : users)
            if (user.getUsername().equals("tucao"))
            {
                guest = (Guest) user;
            }
        
        for (User user : users)
            if (user.getUsername().equals("nh16"))
            {
                staff = (Staff) user;
            }

        out.println(customer);
        out.println(customer.getId());
        out.println(customer.getFirstName());
        out.println(customer.getEmail());
        //customer.setPassword("123");
        out.println(customer.getPassword());
        out.println(customer.compareTo(guest));  //compare by id
        out.println(customer.getCustomerAddress());
        customer.setCustomerAddress(new Address("A", "A", "A", "A", State.NSW, 0));
        out.println(customer.getCustomerAddress());
        
        out.println();
        
        out.println(guest);
        out.println(guest.getEmail());
        out.println(guest.getFullName());
        out.println(guest.getUserType());
        guest.setPermission(PermissionType.Edit);
        out.println(guest.getPermission());
        guest.setPermission(PermissionType.None);
        out.println(guest.getPermission());
        
        out.println();
        
        staff.setBillingAddress(new Address("c", "c", "c", "c", State.NSW, 0));
        out.println(staff.getBillingAddress());
        out.println(staff.getUsername());
        staff.setLastName("CC");
        out.println(staff.getLastName());
        staff.setEmail("abc");
        out.println(staff.getEmail());
        out.println(staff.compareTo(guest));  //compare by id
        
        out.println();
        
        out.println(userManagement.verifyLogIn("nh16", "password"));
        out.println(userManagement.verifyLogIn("", "123"));
        
        out.println(userManagement.changePassword("nh16", "12345678", "123456789"));
        out.println(userManagement.changePassword("nh16", "password", "123"));
        out.println(userManagement.changePassword("nh16", "password", "12345678"));
        
        out.println(userManagement.getUserFullNameByUserName("nh16"));
    }
}
