package com.exam;

import com.core.platform.DefaultSiteWebConfig;
import com.core.platform.DeploymentSettings;
import com.core.platform.web.site.SiteSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.inject.Inject;
import javax.servlet.ServletContext;

/**
 * @author hubery
 */
@Configuration
public class WebConfig extends DefaultSiteWebConfig {

    @Inject
    Environment env;

    @Inject
    ServletContext servletContext;

    @Bean
    public DeploymentSettings deploymentSettings() {
        DeploymentSettings settings = super.deploymentSettings();
        settings.setHTTPPort(env.getRequiredProperty("site.httpPort", int.class));
        settings.setHTTPSPort(env.getRequiredProperty("site.httpsPort", int.class));
        settings.setDeploymentContext(env.getProperty("site.deploymentContext"), servletContext);
        return settings;
    }

    @Override
    public SiteSettings siteSettings() {
        SiteSettings settings = new SiteSettings();
        settings.setErrorPage("/error");
        settings.setResourceNotFoundPage("forward:/error/resource-not-found");
        settings.setSessionTimeOutPage("redirect:/home");
        settings.setRemoteSessionServers(env.getProperty("site.remoteSessionServers"));
        settings.setJSDir("/dstatic/js");
        settings.setCSSDir("/dstatic/css");
        return settings;
    }
}
