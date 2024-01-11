package org.example.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RAM {
    
    private long memory;
    
    
    public long getMemory() {
        return memory;
    }
    
    
    public void setMemory(long memory) {
        this.memory = memory;
    }
    
    
    public RAM(long memory) {
        this.memory = memory;
    }
    
    
    public static RAM getRAMinfo() throws IOException, InterruptedException {
       
        Process process = Runtime.getRuntime().exec("wmic memorychip get capacity");
        process.waitFor();
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        
        long memory = 0;
        
        // Skip the header line
        reader.readLine();
        
        while ((line = reader.readLine()) != null) {
            
            if (line != null && !line.isBlank()) {
                memory = Long.parseLong(line.strip());
                
            }
        }
        
        reader.close();
        memory = memory / (1024 * 1024 * 1024);
        return new RAM(memory);
    }
    
    
}
