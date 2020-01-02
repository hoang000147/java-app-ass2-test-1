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
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.*;

public class ServicesManagement
{
    private ArrayList<Service> services;
    private Map<String, Service> servicesMaps;
    
    public ServicesManagement()
    {
        services = new ArrayList<Service>();
        servicesMaps = new HashMap<String, Service>();
    }
    
    public boolean addService(Service service)
    {
        if (servicesMaps.get(service.getId()) == null)
        {
            services.add(service);
            servicesMaps.put(service.getId(), service);
            return true;
        }
        return false;
    }
    
    public Service finServiceById(String id)
    {
        return servicesMaps.get(id);
    }
    
    public ArrayList<Service> getServiceList()
    {
        return services;
    }
    
    public void preProcess()
    {
        
        try
        {
            File file = new File("services.csv");
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
                    addService(Service.parseCsv(line));
                }
            }
           
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }
}
