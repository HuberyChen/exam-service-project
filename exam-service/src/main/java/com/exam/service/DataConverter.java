package com.exam.service;

import com.exam.domain.Blank;
import com.exam.domain.Calculate;
import com.exam.domain.Select;
import com.exam.domain.ShortAnswer;
import com.exam.web.request.EnterRequest;
import org.springframework.stereotype.Service;

/**
 * @author hubery.chen
 */
@Service
public class DataConverter {

    public Select toSelect(EnterRequest request) {
        Select select = new Select();
        select.setName(request.getName());
        select.setSection(request.getSection());
        select.setLevel(request.getLevel());
        select.setQuestion1(request.getQuestion1());
        select.setQuestion2(request.getQuestion2());
        select.setQuestion3(request.getQuestion3());
        select.setQuestion4(request.getQuestion4());
        select.setAnswer(request.getAnswer());
        return select;
    }

    public Blank toBlank(EnterRequest request) {
        Blank blank = new Blank();
        blank.setName(request.getName());
        blank.setSection(request.getSection());
        blank.setLevel(request.getLevel());
        blank.setAnswer(request.getAnswer());
        return blank;
    }

    public Calculate toCalculate(EnterRequest request) {
        Calculate calculate = new Calculate();
        calculate.setName(request.getName());
        calculate.setSection(request.getSection());
        calculate.setLevel(request.getLevel());
        calculate.setAnswer(request.getAnswer());
        return calculate;
    }

    public ShortAnswer toShortAnswer(EnterRequest request) {
        ShortAnswer shortAnswer = new ShortAnswer();
        shortAnswer.setName(request.getName());
        shortAnswer.setSection(request.getSection());
        shortAnswer.setLevel(request.getLevel());
        shortAnswer.setAnswer(request.getAnswer());
        return shortAnswer;
    }
}
