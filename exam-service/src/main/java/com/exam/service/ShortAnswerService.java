package com.exam.service;

import com.exam.dao.ShortAnswerDao;
import com.exam.domain.Level;
import com.exam.domain.Section;
import com.exam.domain.ShortAnswer;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * @author hubery.chen
 */
@Service
public class ShortAnswerService {

    private ShortAnswerDao shortAnswerDao;

    public int save(ShortAnswer shortAnswer) {
        return shortAnswerDao.save(shortAnswer);
    }

    public List<ShortAnswer> find(Section section, Level level, int num) {
        List<Integer> ids = shortAnswerDao.find(section, level, num);
        return shortAnswerDao.find(ids);
    }

    @Inject
    public void setShortAnswerDao(ShortAnswerDao shortAnswerDao) {
        this.shortAnswerDao = shortAnswerDao;
    }
}
