package com.exam.dao;

import com.core.database.JPAAccess;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

/**
 * @author hubery.chen
 */
@Repository
public class ShortAnswerDao {

    private JPAAccess jpaAccess;


    @Inject
    public void setJpaAccess(JPAAccess jpaAccess) {
        this.jpaAccess = jpaAccess;
    }
}
