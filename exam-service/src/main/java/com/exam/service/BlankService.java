package com.exam.service;

import com.exam.dao.BlankDao;
import com.exam.domain.Blank;
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

    public List<Blank> find(Section section, int num) {
        List<Integer> blankIds = blankDao.find(section, num);
        return blankDao.find(blankIds);
    }

    @Inject
    public void setBlankDao(BlankDao blankDao) {
        this.blankDao = blankDao;
    }
}
