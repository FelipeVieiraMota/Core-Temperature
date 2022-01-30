/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.core.temperature.service.v1;

import org.core.temperature.vo.screen.v1.TemperatureDisplayHandle;

/**
 *
 * @author felipe
 */
public class TemperatureDisplayService {
    private final TemperatureDisplayHandle handle;

    public TemperatureDisplayService(TemperatureDisplayHandle handle) {
        this.handle = handle;
    }
    
    public void start(){ this.handle.call();}
    
}
