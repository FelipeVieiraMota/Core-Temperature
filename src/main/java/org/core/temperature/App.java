package org.core.temperature;

import org.core.temperature.service.TemperatureDisplayHandleService;

public class App extends Thread
{
    /**
     * @param args the command line arguments
     */
    public static void main( String[] args ) {
        
        TemperatureDisplayHandleService temperatureDisplayHandleService = 
                new TemperatureDisplayHandleService();
        System.out.println(temperatureDisplayHandleService);
    }
}
