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
public enum State 
{
    NSW("NSW"), QLD("QLD"), SA("SA"), Tas("TAS"), Vic("VIC"), WA("WA");
    
    private String name;
    
    State(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    @Override
    public String toString()
    {
        return name;
    }
    
    public static State parseCsv(String string)
    {
        switch(string)
        {
            case "NSW":
                return State.NSW;

            case "QLD":
                return State.QLD;

            case "SA":
                return State.SA;

            case "TAS":
                return State.Tas;
                
            case "VIC":
                return State.Vic;
                
            case "WA":
                return State.WA;

            default: return null;
        }
    }
}
