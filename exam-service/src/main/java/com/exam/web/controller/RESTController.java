package com.exam.web.controller;

import com.exam.web.interceptor.LoginRequired;
import com.exam.web.interceptor.MasterLayout;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author hubery.chen
 */
@LoginRequired
@MasterLayout
@Controller
public class RESTController {

    @RequestMapping(value = "/exam/entering", method = RequestMethod.POST)
    public String examEntering(Map<String, Object> model) {
        return "exam/entering";
    }
}
