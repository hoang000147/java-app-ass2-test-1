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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BookingRecord 
{
    private User user;
    private Service service;
    private LocalDate bookingDate;
    private LocalDate endDate;
    private boolean status;
    
    public BookingRecord(User user, Service service)
    {
        this.user = user;
        this.service = service;
    }
    
    public BookingRecord(User user, Service service, LocalDate bookingDate,
                        LocalDate endDate, boolean status)
    {
        this.user = user;
        this.service = service;
        this.bookingDate = bookingDate;
        this.endDate = endDate;
        this.status = status;
    }
    
    public static BookingRecord parseCsv(String line, ArrayList<User> users, ArrayList<Service> services)
    {
        String[] input = line.split(",");
        DateTimeFormatter dobFormat= DateTimeFormatter.ofPattern("MM/dd/yyyy");
        User user = User.findUserByUsername(users, input[0]);
        Service service = Service.findServiceById(services, input[1]);
        LocalDate bookingDate = LocalDate.parse(input[2], dobFormat);
        LocalDate endDate = LocalDate.parse(input[3], dobFormat);
        boolean status = Boolean.parseBoolean(input[4]);
        BookingRecord booking = new BookingRecord(user, service, bookingDate, endDate, status);
        return booking;
    }
    
    public User getUser()
    {
        return user;
    }
    
    public String getAttributeDescriptionForSavingToFile()
    {
        return user.getAttributeToSaveToFile() + ","
                + service.getAttributeDescriptionForSavingToFile() +
                ",bookingDate,endDate,status";
    }
    
    public String getDataToSaveToFile()
    {
        return user.getDataToSaveToFile() + "," + service.getDataToSaveToFile() 
                + "," + bookingDate + "," + endDate + "," + status;
    }
    
    @Override
    public String toString()
    {
        return "BookingRecord[user: " + user + ", service: " + service
                + ", booking date: " + bookingDate + ", end date: " + endDate
                + ", status: " + status;
    }
    
    public static ArrayList<BookingRecord> filterBookingRecordByUsername(ArrayList<BookingRecord> bookingRecords, String username)
    {
        ArrayList<BookingRecord> result = new ArrayList<BookingRecord>();
        for (BookingRecord bookingRecord : bookingRecords)
            if (bookingRecord.getUser().getUsername().equals(username))
                result.add(bookingRecord);
        return result;
    }
    
    public String getCoreInformation()
    {
        return "Booking record: Username: " + user.getUsername() + ", Service name: "
                + service.getName() + ", Booking date: " + bookingDate 
                + ", End date: " + endDate + ", Status: " + status;
    }
}
