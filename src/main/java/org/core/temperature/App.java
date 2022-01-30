package org.core.temperature;

import org.core.temperature.service.v1.TemperatureDisplayService;
import org.core.temperature.vo.screen.v1.TemperatureDisplayHandle;

import org.core.temperature.service.v2.CoreService;
import org.core.temperature.vo.screen.v2.Core;


public class App extends Thread
{
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main( String[] args ) {
        
       new TemperatureDisplayService(new TemperatureDisplayHandle()).start();
      //new CoreService(new Core());
    }
}
