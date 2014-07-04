package com.exam.service;

import com.exam.dao.QuestionDao;
import com.exam.domain.Level;
import com.exam.domain.Question;
import com.exam.domain.Section;
import com.exam.domain.Type;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * @author hubery.chen
 */
@Service
public class QuestionService {

    private QuestionDao questionDao;

    public int save(Question question) {
        return questionDao.save(question);
    }

    public List<Question> find(Type type, Section section, Level level, int num) {
        List<Integer> ids = questionDao.find(type, section, level, num);
        return questionDao.find(ids);
    }

    @Inject
    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }
}
