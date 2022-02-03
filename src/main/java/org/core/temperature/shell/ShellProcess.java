/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.core.temperature.shell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author felipe
 */
public class ShellProcess {
    
    public Process runCommandsOnShell(String[] commands) throws IOException{
        Process process = Runtime.getRuntime().exec(commands);
        return process;
    }
    
    public String getProcessResult(Process process) throws IOException {        
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        String processResult = "";
        while ((line = reader.readLine()) != null) processResult += line;
        return processResult;
    }
    
}
