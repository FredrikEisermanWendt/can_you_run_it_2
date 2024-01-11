package org.example.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CPU {
    
    private double frequency;
    private int cores;
    private final static String getFrequencyCommand = "wmic cpu get maxclockspeed";
    private final static String getCoresCommand = "wmic cpu get numberOfCores";
    
    
    public CPU(double frequency, int cores) {
        this.frequency = frequency;
        this.cores = cores;
    }
    
    
    public double getFrequency() {
        return frequency;
    }
    
    
    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }
    
    
    public int getCores() {
        return cores;
    }
    
    
    public void setCores(int cores) {
        this.cores = cores;
    }
    
    
    public static CPU getCPUinfo() throws IOException, InterruptedException {
        double frequency = getCPinfo(getFrequencyCommand);
        int cores = (int) getCPinfo(getCoresCommand);
        return new CPU(frequency, cores);
    }
    
    
    public static double getCPinfo(String command) throws IOException, InterruptedException {
        
        double tempValue = 0;
        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        
        
        // Skip the header line
        reader.readLine();
        
        while ((line = reader.readLine()) != null) {
            
            if (line != null && !line.isBlank()) {
                tempValue = Double.parseDouble(line);
            }
            
        }
        
        
        reader.close();
        return tempValue;
    }
    
    
}
