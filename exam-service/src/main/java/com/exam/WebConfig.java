package com.exam;

import com.core.platform.DefaultSiteWebConfig;
import com.core.platform.web.DeploymentSettings;
import com.core.platform.web.site.SiteSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

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

    @Bean
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

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // on server env, /mstatic will be handled by apache or CDN, this only
        // apply to local dev
        registry.addResourceHandler("/dstatic/**").addResourceLocations("/dstatic/");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/login");
    }

}
