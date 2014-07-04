package com.exam.web.request;

import com.exam.domain.Level;
import com.exam.domain.Section;
import com.exam.domain.Type;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author hubery.chen
 */
@XmlRootElement(name = "enter-quest")
@XmlAccessorType(XmlAccessType.FIELD)
public class EnterRequest {

    @XmlElement(name = "type")
    private Type type;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "section")
    private Section section;

    @XmlElement(name = "level")
    private Level level;

    @XmlElement(name = "question1")
    private String question1;

    @XmlElement(name = "question2")
    private String question2;

    @XmlElement(name = "question3")
    private String question3;

    @XmlElement(name = "question4")
    private String question4;

    @XmlElement(name = "answer")
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

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
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

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getQuestion3() {
        return question3;
    }

    public void setQuestion3(String question3) {
        this.question3 = question3;
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
}
