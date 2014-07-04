package com.exam.domain;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * @author hubery.chen
 */
public enum Type {
    Select, Blank, Calculate, ShortAnswer, All;

    public static List<Type> find() {
        return new ArrayList<>(EnumSet.allOf(Type.class));
    }
}
