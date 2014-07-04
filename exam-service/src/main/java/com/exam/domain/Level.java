package com.exam.domain;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * @author hubery
 */
public enum Level {
    A, B, C, All;

    public static List<Level> find() {
        return new ArrayList<>(EnumSet.allOf(Level.class));
    }
}
