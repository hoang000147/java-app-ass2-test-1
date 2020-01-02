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

public class ErrorReport 
{
    private String errorMessage;
    private boolean error;
    
    public ErrorReport()
    {
        this(false, "");
    }
    
    public ErrorReport(boolean error, String errorMessage)
    {
        this.error = error;
        this.errorMessage = errorMessage;
    }
    
    public void setError(boolean error)
    {
        this.error = error;
    }
    
    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }
    
    public boolean getError()
    {
        return error;
    }
    
    public String getErrorMessage()
    {
        return "Error. " + errorMessage;
    }
    
    public void printErrorMessage()
    {
        out.println(getErrorMessage() + " Try again.");
    }
}
