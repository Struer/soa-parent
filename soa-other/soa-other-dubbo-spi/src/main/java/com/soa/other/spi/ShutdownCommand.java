package com.soa.other.spi;

public class ShutdownCommand implements Command{  
    public void execute() {  
        System.out.println("shutdown....");  
    }  
}  