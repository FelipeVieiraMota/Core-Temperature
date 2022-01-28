package org.core.temperature;


import java.io.IOException;
import org.core.temperature.service.TemperatureDisplayService;
import org.core.temperature.vo.screen.TemperatureDisplayHandle;


public class App extends Thread
{
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main( String[] args ) throws IOException {
        
       new TemperatureDisplayService(new TemperatureDisplayHandle()).start();
    }
}
