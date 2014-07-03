package com.exam.utils;


import com.core.utils.StringUtils;

import java.math.BigDecimal;

public class DataFormat {

    private static final String STRING_BOOLEAN_TRUE = "Y";

    private static final String STRING_BOOLEAN_FALSE = "N";

    public static int toInt(String value) {
        int result;

        try {
            result = Integer.parseInt(value);
        } catch (Exception e) {
            result = 0;
        }

        return result;
    }

    public static boolean toBoolean(String value) {
        if (null == value || value.isEmpty()) {
            return false;
        }

        if ("Y".equalsIgnoreCase(value)) {
            return true;
        }

        if ("TRUE".equalsIgnoreCase(value)) {
            return true;
        }

        return false;
    }

    public static String booleanToString(Boolean value) {
        if (Boolean.TRUE.equals(value)) {
            return STRING_BOOLEAN_TRUE;
        }
        return STRING_BOOLEAN_FALSE;
    }

    public static BigDecimal toBigDecimal(String value) {
        BigDecimal result = BigDecimal.ZERO;
        if (!StringUtils.hasText(value)) {
            return result;
        }
        try {
            result = new BigDecimal(value).setScale(2);
        } catch (Exception e) {
            result = BigDecimal.ZERO;
        }
        return result;
    }

    public static String bigDecimalToString(BigDecimal value) {
        if (null == value) {
            return String.valueOf(BigDecimal.ZERO.setScale(2));
        }
        return String.valueOf(value);
    }
}
