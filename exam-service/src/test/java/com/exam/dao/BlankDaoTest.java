package com.exam.dao;

import com.exam.SpringTest;
import com.exam.domain.Blank;
import com.exam.domain.Level;
import com.exam.domain.Section;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import javax.inject.Inject;
import java.util.List;

/**
 * @author hubery.chen
 */
public class BlankDaoTest extends SpringTest {

    @Inject
    private BlankDao blankDao;

    @Test
    @Ignore
    public void testSave() {
        blankDao.save(mockBlank());
    }

    @Test
    public void testGetCount() {
        int count = blankDao.get(Section.One);
        Assert.assertEquals(count, 2);
    }

    @Test
    public void testFind() {
        List<Integer> ids = blankDao.find(Section.One, 1);
        Assert.assertEquals(ids.size(), 1);
        Assert.assertEquals(ids.get(0).intValue(), 1);
    }

    private Blank mockBlank() {
        Blank blank = new Blank();
        blank.setName("2+2=?");
        blank.setSection(Section.One);
        blank.setLevel(Level.A);
        blank.setAnswer("4");
        return blank;
    }
}
