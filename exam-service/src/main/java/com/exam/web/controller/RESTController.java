package com.exam.web.controller;

import com.exam.domain.Type;
import com.exam.service.BlankService;
import com.exam.service.CalculateService;
import com.exam.service.DataConverter;
import com.exam.service.SelectService;
import com.exam.service.ShortAnswerService;
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

    private SelectService selectService;
    private BlankService blankService;
    private CalculateService calculateService;
    private ShortAnswerService shortAnswerService;
    private DataConverter dataConverter;

    @RequestMapping(value = "/exam/simulation", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> simulation(@Valid @RequestBody SimulateRequest request) {
        Map<String, Object> model = new HashMap<>();
        if (Type.Select.equals(request.getType()) || Type.All.equals(request.getType())) {
            model.put("selects", selectService.find(request.getSection(), request.getLevel(), SimulationConstant.BLANK_NUM));
        }
        if (Type.Blank.equals(request.getType()) || Type.All.equals(request.getType())) {
            model.put("blanks", blankService.find(request.getSection(), request.getLevel(), SimulationConstant.BLANK_NUM));
        }
        if (Type.Calculate.equals(request.getType()) || Type.All.equals(request.getType())) {
            model.put("calculates", calculateService.find(request.getSection(), request.getLevel(), SimulationConstant.BLANK_NUM));
        }
        if (Type.ShortAnswer.equals(request.getType()) || Type.All.equals(request.getType())) {
            model.put("shortAnswers", shortAnswerService.find(request.getSection(), request.getLevel(), SimulationConstant.BLANK_NUM));
        }
        return model;
    }

    @RequestMapping(value = "/exam/entering", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> entering(@Valid @RequestBody EnterRequest request) {
        Map<String, Object> model = new HashMap<>();
        if (Type.Select.equals(request.getType())) {
            selectService.save(dataConverter.toSelect(request));
        }
        if (Type.Blank.equals(request.getType())) {
            blankService.save(dataConverter.toBlank(request));
        }
        if (Type.Calculate.equals(request.getType())) {
            calculateService.save(dataConverter.toCalculate(request));
        }
        if (Type.ShortAnswer.equals(request.getType())) {
            shortAnswerService.save(dataConverter.toShortAnswer(request));
        }
        model.put("errMsg", "success");
        return model;
    }

    @Inject
    public void setDataConverter(DataConverter dataConverter) {
        this.dataConverter = dataConverter;
    }

    @Inject
    public void setSelectService(SelectService selectService) {
        this.selectService = selectService;
    }

    @Inject
    public void setBlankService(BlankService blankService) {
        this.blankService = blankService;
    }

    @Inject
    public void setCalculateService(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    @Inject
    public void setShortAnswerService(ShortAnswerService shortAnswerService) {
        this.shortAnswerService = shortAnswerService;
    }

}
