package com.exam.service;

import com.exam.domain.Type;


/**
 * @author hubery.chen
 */
public class SimulationConstant {

    public static final int SELECT_NUM = 20;
    public static final int BLANK_NUM = 10;
    public static final int CALCULATE_NUM = 5;
    public static final int SHORT_ANSWER_NUM = 5;

    public static int getNum(Type type) {
        int num = 0;
        switch (type) {
            case Select:
                num = SELECT_NUM;
                break;
            case Blank:
                num = BLANK_NUM;
                break;
            case Calculate:
                num = CALCULATE_NUM;
                break;
            case ShortAnswer:
                num = SHORT_ANSWER_NUM;
                break;
            default:
                num = 0;
        }
        return num;
    }
}
