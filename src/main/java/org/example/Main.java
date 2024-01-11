package org.example;

import java.io.IOException;
import java.util.Arrays;

import org.example.data.CPU;
import org.example.data.Computer;
import org.example.data.Disk;
import org.example.data.RAM;
import org.example.programs.Programs;

public class Main {
    static Computer myComputer;
    
    public static void main(String[] args) throws Exception {
        
        try {
            // Get CPU information
            CPU cpu = CPU.getCPUinfo();
            
            // Get RAM information
            RAM ram = RAM.getRAMinfo();
            
            // Get Disk information
            Disk disk = Disk.getDiskInfo();
            
            
            // Create an instance of Computer
            myComputer = new Computer(disk, cpu, ram);
            System.out.println("computer instance");
            
            // Access and print information
            System.out.println("CPU Frequency: " + myComputer.getCpu().getFrequency() + " GHz, Cores: " + myComputer.getCpu().getCores());
            System.out.println("RAM Memory: " + myComputer.getRam().getMemory() + " GB");
            System.out.println("Disk Free Space: " + myComputer.getDisk().getFree() + " GB, Used Space: " + myComputer.getDisk().getUsed() + " GB, Total Space: " + myComputer.getDisk().getTotal() + " GB");
            
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        
        Programs[] programArray = Programs.createSamplePrograms();
        for (Programs p:programArray){
            if (myComputer.getCpu().getFrequency() < p.getCpu().getFrequency() ||
                    myComputer.getCpu().getCores() < p.getCpu().getCores() ||
                    myComputer.getRam().getMemory() < p.getRam().getMemory() ||
                    myComputer.getDisk().getFree() < p.getDisk().getFree() ||
                    myComputer.getDisk().getUsed() < p.getDisk().getUsed() ||
                    myComputer.getDisk().getTotal() < p.getDisk().getTotal()) {
                System.out.println("\u001B[31mYour computer is to week\u001B[0m");
            }else {
                System.out.println("\u001B[32mYour computer is strong enough\u001B[0m");
                
            }
            System.out.println(p);
        }
        
    }
    
    
}


/*
 *
 */
