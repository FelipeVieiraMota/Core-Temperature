 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.core.temperature.vo.screen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JTextArea;

/**
 *
 * @author felipe
 */
public class TemperatureDisplayHandle extends TemperatureDisplay{
    
    TemperatureDisplay screen;
    
    public TemperatureDisplayHandle(){
        this.screen = new TemperatureDisplay();
        
    }
    
    public void call(){
        this.screen.setLocationRelativeTo(null);
        this.screen.setVisible(true);
        showTemperature("");
    }
    
    private void setTextForTemperature(String text){
        JTextArea area = this.screen.getAreaTemperature();
        area.setText(text);
        this.screen.setAreaTemperature(area);
    }
    
    private String getProcessResult(Process process) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        String processResult = "";
        while ((line = reader.readLine()) != null) processResult += line;
        return processResult;
    }
    
    //sensors | awk '/Core 0/ {print $4} {print $5} {print $6} {print $7} {print $8} {print $9}'
    
    
    public void showTemperature(String fahrenheit){
        try{
            while(true){
                StringBuilder stb = new StringBuilder();
                String[] command = { "/bin/sh", "-c", "sensors "+fahrenheit+" | awk '/Core 0/ {print $3}'"};
                Process process = Runtime.getRuntime().exec(command);
                String result = getProcessResult(process);
                
                stb.append("\n");
                stb.append("     ");
                stb.append(result);
                
                if (result != null && !result.isEmpty() && !result.trim().isEmpty()) 
                    setTextForTemperature(stb.toString());
                
                Thread.sleep(3000);
            }
        }
        catch(InterruptedException | IOException ex){
            ex.printStackTrace();
        }        
    }
    
    public void showTemperatureByEachCore(String fahrenheit) {
        try{
            while(true){
                int availableProcessors = Runtime.getRuntime().availableProcessors();
                StringBuilder stb = new StringBuilder();
                for (int coreNumber = 0; coreNumber <= availableProcessors-1; coreNumber++){
                    String[] command = { "/bin/sh", "-c", "sensors "+fahrenheit+" | awk '/Core "+coreNumber+"/ {print $3}'"};
                    Process process = Runtime.getRuntime().exec(command);
                    String result = getProcessResult(process);
                    if (result != null && !result.isEmpty() && !result.trim().isEmpty()) {
                        stb.append("\n");
                        stb.append(" (Core ");
                        stb.append(coreNumber);
                        stb.append(") ");
                        stb.append(result);
                        stb.append("\n");
                        setTextForTemperature(stb.toString());
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
