package org.core.temperature.service;

import org.core.temperature.shell.LinuxShellProcess;

import java.io.IOException;
import java.util.concurrent.Callable;

public class SingleCoreService implements Callable<String> {

  public static String runSingleCore() {
    var stb = new StringBuilder();
    try {
      var commands = LinuxShellProcess.simpleAwkOneCoreCommand;
      var process = new LinuxShellProcess().runCommandsOnShell(commands);
      var result = new LinuxShellProcess().getProcessResult(process);
      stb.append("\n").append("     ").append(result);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return stb.toString();
  }

  @Override
  public String call() throws Exception {
    return runSingleCore();
  }
}
