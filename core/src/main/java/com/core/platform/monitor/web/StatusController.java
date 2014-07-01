package com.core.platform.monitor.web;

import com.core.platform.SpringObjectFactory;
import com.core.platform.monitor.ServerStatus;
import com.core.platform.monitor.ServiceMonitor;
import com.core.platform.monitor.Status;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

@Controller
public class StatusController {
    private SpringObjectFactory objectFactory;
    private ServerStatus serverStatus;

    @RequestMapping(value = "/monitor/status", produces = "application/xml", method = RequestMethod.GET)
    @ResponseBody
    public String status() {
        Status status = new Status();
        List<ServiceMonitor> monitors = objectFactory.getBeans(ServiceMonitor.class);
        status.check(monitors);
        return status.toXML(serverStatus);
    }

    @Inject
    public void setObjectFactory(SpringObjectFactory objectFactory) {
        this.objectFactory = objectFactory;
    }

    @Inject
    public void setServerStatus(ServerStatus serverStatus) {
        this.serverStatus = serverStatus;
    }
}
