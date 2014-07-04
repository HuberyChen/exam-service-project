package com.exam.web.controller;

import com.exam.domain.Question;
import com.exam.domain.Type;
import com.exam.service.QuestionService;
import com.exam.service.SimulationConstant;
import com.exam.web.interceptor.LoginRequired;
import com.exam.web.interceptor.MasterLayout;
import com.exam.web.request.EnterRequest;
import com.exam.web.request.SimulateRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hubery.chen
 */
@LoginRequired
@MasterLayout
@Controller
public class RESTController {

    private QuestionService questionService;

    @RequestMapping(value = "/exam/simulation", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> simulation(@Valid @RequestBody SimulateRequest request) {
        Map<String, Object> model = new HashMap<>();
        if (!Type.All.equals(request.getType())) {
            Type type = request.getType();
            model.put(type.name(), questionService.find(type, request.getSection(), request.getLevel(), SimulationConstant.getNum(type)));
        } else {
            for (Type type : Type.find()) {
                model.put(type.name(), questionService.find(type, request.getSection(), request.getLevel(), SimulationConstant.getNum(type)));
            }
        }
        return model;
    }

    @RequestMapping(value = "/exam/entering", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> entering(@Valid @RequestBody EnterRequest request) {
        Map<String, Object> model = new HashMap<>();
        questionService.save(toQuestion(request));
        model.put("errMsg", "success");
        return model;
    }

    private Question toQuestion(EnterRequest request) {
        Question question = new Question();
        question.setName(request.getName());
        question.setSection(request.getSection());
        question.setLevel(request.getLevel());
        question.setType(request.getType());
        if (Type.Select.equals(request.getType())) {
            question.setQuestion1(request.getQuestion1());
            question.setQuestion2(request.getQuestion2());
            question.setQuestion3(request.getQuestion3());
            question.setQuestion4(request.getQuestion4());
        }
        question.setAnswer(request.getAnswer());
        return question;
    }


    @Inject
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }
}
