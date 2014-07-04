package com.exam.dao;

import com.exam.SpringTest;
import com.exam.domain.Level;
import com.exam.domain.Question;
import com.exam.domain.Section;
import com.exam.domain.Type;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import javax.inject.Inject;
import java.util.List;

/**
 * @author hubery.chen
 */
@Ignore
public class QuestionDaoTest extends SpringTest {

    @Inject
    private QuestionDao questionDao;

    @Test
    @Ignore
    public void testSave() {
        questionDao.save(mockQuestion());
    }

    @Test
    public void testGetCount() {
        int count = questionDao.get(Section.One);
        Assert.assertEquals(count, 2);
    }

    @Test
    public void testFind() {
        for (int i = 0; i < 100; i++) {
            List<Integer> ids = questionDao.find(Type.Blank, Section.One, Level.A, 1);
            Assert.assertEquals(ids.get(0).intValue(), 12);
        }
    }

    @Test
    public void testFindById() {
        Question question = questionDao.find(12);
        Assert.assertEquals(question.getSection(), Section.One);
    }

    private Question mockQuestion() {
        Question question = new Question();
        question.setType(Type.Blank);
        question.setName("2+2=?");
        question.setSection(Section.One);
        question.setLevel(Level.A);
        question.setAnswer("4");
        return question;
    }
}
