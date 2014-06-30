package com.core.monitor;

public interface ServiceMonitor {
    ServiceStatus getServiceStatus() throws Exception;

    String getServiceName();
}
