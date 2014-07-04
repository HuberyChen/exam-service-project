package com.exam.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author hubery.chen
 */

@Entity(name = "Question")
public class Question {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "Type")
    private Type type;

    @Column(name = "Name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "Section")
    private Section section;

    @Enumerated(EnumType.STRING)
    @Column(name = "Level")
    private Level level;

    @Column(name = "Question1")
    private String question1;

    @Column(name = "Question2")
    private String question2;

    @Column(name = "Question3")
    private String question3;

    @Column(name = "Question4")
    private String question4;

    @Column(name = "Answer")
    private String answer;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion2() {
        return question2;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getQuestion4() {
        return question4;
    }

    public void setQuestion4(String question4) {
        this.question4 = question4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion3() {
        return question3;
    }

    public void setQuestion3(String question3) {
        this.question3 = question3;
    }
}
