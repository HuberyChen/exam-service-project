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
@XmlRootElement(name = "simulate-request")
@XmlAccessorType(XmlAccessType.FIELD)
public class SimulateRequest {

    @XmlElement(name = "type")
    private Type type;

    @XmlElement(name = "section")
    private Section section;

    @XmlElement(name = "level")
    private Level level;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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
}
