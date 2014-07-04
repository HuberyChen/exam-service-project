package com.exam.service;

import com.exam.dao.SelectDao;
import com.exam.domain.Level;
import com.exam.domain.Section;
import com.exam.domain.Select;

import javax.inject.Inject;
import java.util.List;

/**
 * @author hubery.chen
 */
public class SelectService {

    private SelectDao selectDao;

    public int save(Select select) {
        return selectDao.save(select);
    }

    public List<Select> find(Section section, Level level, int num) {
        List<Integer> ids = selectDao.find(section, level, num);
        return selectDao.find(ids);
    }

    @Inject
    public void setSelectDao(SelectDao selectDao) {
        this.selectDao = selectDao;
    }
}
