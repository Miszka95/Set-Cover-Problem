package pl.edu.wat;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

public class Metrics {

    public static long getUsedMemory() {
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        return memoryBean.getHeapMemoryUsage().getUsed() + memoryBean.getNonHeapMemoryUsage().getUsed();
    }
}
