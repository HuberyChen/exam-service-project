package com.exam.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.inject.Inject;


@Configuration
public class WebConfig {

    @Inject
    Environment env;

}
