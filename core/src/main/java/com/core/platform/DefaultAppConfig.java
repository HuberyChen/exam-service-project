package com.core.platform;

import com.core.platform.context.Messages;
import com.core.platform.context.PropertyContext;
import com.core.platform.monitor.ServerStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.io.IOException;
import java.util.Properties;

/**
 * @author hubery
 */
public class DefaultAppConfig {
    @Inject
    private ConfigurableEnvironment environment;

    @Bean
    Messages messages() throws IOException {
        Resource[] messageResources = new PathMatchingResourcePatternResolver().getResources("classpath*:messages/*.properties");
        Messages messages = new Messages();
        String[] baseNames = new String[messageResources.length];
        for (int i = 0, messageResourcesLength = messageResources.length; i < messageResourcesLength; i++) {
            Resource messageResource = messageResources[i];
            String filename = messageResource.getFilename();
            baseNames[i] = "messages/" + filename.substring(0, filename.indexOf('.'));
        }
        messages.setBasenames(baseNames);
        return messages;
    }

    @Bean
    static PropertyContext propertyContext() throws IOException {
        PropertyContext propertySource = new PropertyContext();
        propertySource.setLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:*.properties"));
        propertySource.loadAllProperties();
        return propertySource;
    }

    @PostConstruct
    void configureEnvironment() throws IOException {
        environment.setIgnoreUnresolvableNestedPlaceholders(true);
        Properties properties = propertyContext().getAllProperties();
        environment.getPropertySources().addLast(new PropertiesPropertySource("properties", properties));
    }

    @Bean
    ServerStatus serverStatus() {
        return new ServerStatus();
    }
}

