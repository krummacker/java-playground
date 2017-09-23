package de.krummacker.hello;

import java.util.Arrays;

public class Hello {

    public static void main(String[] args) {
        ProcessHandle.Info processInfo = ProcessHandle.current().info();
        System.out.println("Process arguments: " + Arrays.toString(processInfo.arguments().orElse(new String[0])));
        System.out.println("Process executable: " + processInfo.command().orElse(""));
        System.out.println("Process command line: " + processInfo.commandLine().orElse(""));
        System.out.println("Process start time: " + processInfo.startInstant().orElse(null));
        System.out.println("Process total cputime accumulated: " + processInfo.totalCpuDuration().orElse(null));
        System.out.println("Process user: " + processInfo.user().orElse(""));
    }
}
