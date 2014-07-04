package com.exam.service;

import com.exam.dao.CalculateDao;
import com.exam.domain.Calculate;
import com.exam.domain.Level;
import com.exam.domain.Section;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * @author hubery.chen
 */
@Service
public class CalculateService {

    private CalculateDao calculateDao;

    public int save(Calculate calculate) {
        return calculateDao.save(calculate);
    }

    public List<Calculate> find(Section section, Level level, int num) {
        List<Integer> ids = calculateDao.find(section, level, num);
        return calculateDao.find(ids);
    }

    @Inject
    public void setCalculateDao(CalculateDao calculateDao) {
        this.calculateDao = calculateDao;
    }
}
