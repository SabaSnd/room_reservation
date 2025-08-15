package com.liseMeitnerWohnheim;

import picocli.CommandLine;

public class Main {
    public static void main(String[] args) {
        int exitCode = new CommandLine(new CommandParser()).execute(args);
        
         System.exit(exitCode);
    }
}