package org.example.data;

import org.example.data.CPU;
import org.example.data.Disk;
import org.example.data.RAM;
import org.example.programs.Programs;

public class Computer implements Comparable {
    private Disk disk;
    private CPU cpu;
    private RAM ram;
    
    
    public Computer(Disk disk, CPU cpu, RAM ram) {
        this.cpu = cpu;
        this.disk = disk;
        this.ram = ram;
    }
    
    
    public CPU getCpu() {
        return cpu;
    }
    
    
    public RAM getRam() {
        return ram;
    }
    
    
    public Disk getDisk() {
        return disk;
    }
    
    
    @Override
    public int compareTo(Object o) {
        Programs p = (Programs) o;
//      cpu freq + cores, ram memory, disc free, used, total
        if (getCpu().getFrequency() < p.getCpu().getFrequency() ||
                getCpu().getCores() < p.getCpu().getCores() ||
                getRam().getMemory() < p.getRam().getMemory() ||
                getDisk().getFree() < p.getDisk().getFree() ||
                getDisk().getUsed() < p.getDisk().getUsed() ||
                getDisk().getTotal() < p.getDisk().getTotal()) {
            return -1;
        }
        if (getCpu().getFrequency() < p.getCpu().getFrequency() &&
                getCpu().getCores() < p.getCpu().getCores() &&
                getRam().getMemory() < p.getRam().getMemory() &&
                getDisk().getFree() < p.getDisk().getFree() &&
                getDisk().getUsed() < p.getDisk().getUsed() &&
                getDisk().getTotal() < p.getDisk().getTotal()) {
            return 0;
        }
        return 1;
    }
    
    
}

