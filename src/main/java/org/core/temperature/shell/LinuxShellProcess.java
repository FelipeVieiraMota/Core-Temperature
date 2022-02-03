/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.core.temperature.shell;

/**
 *
 * @author felipe
 */
public class LinuxShellProcess extends ShellProcess{

    public final static String[] simpleAwkOneCoreCommand = { "/bin/sh", "-c", "sensors | awk '/Core 0/ {print $3}'"};

}
