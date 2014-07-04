package com.exam.domain;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * @author hubery
 */
public enum Section {
    One, Two, Three, Four, Five, Six, Seven, Eight, Nine, All;

    public static List<Section> find() {
        return new ArrayList<>(EnumSet.allOf(Section.class));
    }
}
