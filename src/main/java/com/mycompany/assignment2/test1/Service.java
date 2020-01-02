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
public class Service implements Cloneable,
                                Comparable<Service>
{
    private String id;
    private String name;
    private String detail;
    private String parts;
    private double duration;
    private double pricePerUnit;
    private boolean status;
    
    public Service(String id, String name, String detail, String parts, 
                double duration, double pricePerUnit, boolean status)
    {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.parts = parts;
        this.duration = duration;
        this.pricePerUnit = pricePerUnit;
        this.status = status;
    }
    
    public static Service parseCsv(String line)
    {
        String[] input = line.split(",");
        double duration = Double.parseDouble(input[4]);
        double pricePerUnit = Double.parseDouble(input[5]);
        boolean status = Boolean.parseBoolean(input[6]);
        Service service = new Service(input[0], input[1], input[2], input[3], duration, pricePerUnit, status);
        return service;        
    }
    
    protected void setId(String id)
    {
        this.id = id;
    }
    
    public String getId()
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setDetail(String detail)
    {
        this.detail = detail;
    }
    
    public String getParts()
    {
        return parts;
    }
    
    public void setParts(String parts)
    {
        this.parts = parts;
    }
    
    public double getDuration()
    {
        return duration;
    }
    
    public void setDuration(double duration)
    {
        this.duration = duration;
    }
    
    public void setPricePerUnit(double pricePerUnit)
    {
        this.pricePerUnit = pricePerUnit;
    }
    
    public boolean getStatus()
    {
        return status;
    }
    
    public void setStatus(boolean status)
    {
        this.status = status;
    }
    
    @Override
    public String toString()
    {
        return "Service[ID: " + id + ", name: " + name + ", detail: " + detail
                + ", parts: " + parts + ", duration: " + duration 
                + ", price per unit: " + pricePerUnit 
                + ", status: " + status + "] ";
    }
    
    @Override
    public Service clone() throws CloneNotSupportedException
    {
        try
        {
            Service other = (Service) super.clone();
            return other;
        }
        catch (CloneNotSupportedException e)
        {
            throw new RuntimeException(e);
        }
    }
    
    @Override 
    public int compareTo(Service service)
    {
        return this.getId().compareTo(service.getId());
    }
    
    public String getAttributeDescriptionForSavingToFile()
    {
        return "id,name,detail,parts,duration,pricePerUnit,status";
    }
    
    public String getDataToSaveToFile()
    {
        return id + "," + name + "," + detail + "," + parts
               + "," + duration + "," + pricePerUnit + "," + status;
    }
    
    public static Service findServiceById(ArrayList<Service> services, String id)
    {
        for (Service service : services)
            if (service.getId().equals(id))
                return service;
        return null;
    }
    
    
    public static ArrayList<Service> findServiceByKeywordSearchOnName(ArrayList<Service> services, String name)
    {
        ArrayList<Service> result = new ArrayList<Service>();
        for (Service service : services)
            if (service.getName().toLowerCase().contains(name.toLowerCase()))
                result.add(service);
        return result;
    }
    
    public static ArrayList<Service> findServiceByDuration(ArrayList<Service> services, double duration)
    {
        ArrayList<Service> result = new ArrayList<Service>();
        for (Service service : services)
            if (service.getDuration() == duration)
                result.add(service);
        return result;
    }  
    
    /*@Override
    public String getProductDescription()
    {
        return name + duration;
    }
    
    @Override
    public String getDetail()
    {
        return detail;
    }
    
    @Override 
    public double getPricePerUnit()
    {
        return pricePerUnit;
    }
    
    @Override
    public String getUnitDescription()
    {
        return "hours";
    }
    
    @Override
    public String getProductId()
    {
        return "";
    }*/
}
