package com.core.platform.monitor.web;

public interface ServiceMonitor {
    ServiceStatus getServiceStatus() throws Exception;

    String getServiceName();
}
