package com.exam.service;

import com.exam.dao.BlankDao;
import com.exam.domain.Blank;
import com.exam.domain.Level;
import com.exam.domain.Section;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * @author hubery.chen
 */
@Service
public class BlankService {

    private BlankDao blankDao;

    public int save(Blank blank) {
        return blankDao.save(blank);
    }

    public List<Blank> find(Section section, Level level, int num) {
        List<Integer> ids = blankDao.find(section, level, num);
        return blankDao.find(ids);
    }

    @Inject
    public void setBlankDao(BlankDao blankDao) {
        this.blankDao = blankDao;
    }
}
