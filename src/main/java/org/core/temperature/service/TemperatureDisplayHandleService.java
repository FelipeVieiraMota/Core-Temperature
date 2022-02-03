package org.core.temperature.service;

import java.io.IOException;
import java.util.concurrent.*;

import org.core.temperature.shell.LinuxShellProcess;
import org.core.temperature.vo.screen.TemperatureDisplay;

/**
 *
 * @author felipe
 */
public class TemperatureDisplayHandleService extends TemperatureDisplay {
    
    private final TemperatureDisplay screen;

    public TemperatureDisplayHandleService(){
        this.screen = new TemperatureDisplay();
        this.screen.setLocationRelativeTo(null);
        this.screen.setVisible(true);
        singleCoreTemperature();
    }

    public void singleCoreTemperature() {
        var executor = Executors.newSingleThreadExecutor();
        var keepGoing = true;
        while (keepGoing){
            try{
                Future<String> result = executor.submit(new Callable<String>() {
                    public String call() throws Exception {
                        return new SingleCoreService().call();
                    }
                });
                this.screen.setAreaTemperature(result.get());
                // TODO: Remove it after.
                Thread.sleep(8000);
            }catch( Exception ex ){
                ex.printStackTrace();
                keepGoing = false;
            }finally {
                if (!keepGoing) executor.shutdown();
            }
            System.out.println("keepGoing " + keepGoing);
        }
    }
    
    @Deprecated()
    public void showTemperatureByEachCore(String fahrenheit) {
        try{
            while(true){
                int availableProcessors = Runtime.getRuntime().availableProcessors();
                StringBuilder stb = new StringBuilder();
                for (int coreNumber = 0; coreNumber <= availableProcessors-1; coreNumber++){
                    String[] command = { "/bin/sh", "-c", "sensors "+fahrenheit+" | awk '/Core "+coreNumber+"/ {print $3}'"};
                    Process process = Runtime.getRuntime().exec(command);
                    String result = new LinuxShellProcess().getProcessResult(process);
                    if (result != null && !result.isEmpty() && !result.trim().isEmpty()) {
                        stb.append("\n");
                        stb.append(" (Core ");
                        stb.append(coreNumber);
                        stb.append(") ");
                        stb.append(result);
                        stb.append("\n");
                        this.screen.setAreaTemperature(stb.toString());
                    }
                }
                Thread.sleep(3000);
            }
        }
        catch(InterruptedException | IOException ex){
            ex.printStackTrace();
        }
    }
}
