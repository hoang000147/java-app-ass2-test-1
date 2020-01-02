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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BookingManagement 
{
    private ArrayList<BookingRecord> bookings;
    
    public BookingManagement()
    {
        bookings = new ArrayList<BookingRecord>();
    }
    
    public boolean addBookingRecord(BookingRecord booking)
    {
        for (BookingRecord book : bookings)
            if (book == booking)
                return false;
        bookings.add(booking);
        return true;
    }
    
    public ArrayList<BookingRecord> findBookingRecordByUsername(String username)
    {
        return BookingRecord.filterBookingRecordByUsername(bookings, username);
    }
    
    public void preProcess(ArrayList<User> users, ArrayList<Service> services)
    {
        
        try
        {
            File file = new File("booking.csv");
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
                    addBookingRecord(BookingRecord.parseCsv(line, users, services));
                }
            }
           
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }
    
    public ArrayList<BookingRecord> getBookingList()
    {
        return bookings;
    }
}
