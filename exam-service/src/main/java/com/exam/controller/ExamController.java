package com.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author hubery.chen
 */
@Controller
public class ExamController {
    @RequestMapping(value = "exam", method = RequestMethod.GET)
    public void exam() {
        return;
    }
}
