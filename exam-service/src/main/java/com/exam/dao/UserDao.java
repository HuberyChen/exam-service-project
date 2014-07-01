package com.exam.dao;

import com.core.database.JPAAccess;
import com.exam.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * @author hubery
 */
@Repository
public class UserDao {

    private JPAAccess jpaAccess;

    @Transactional
    public int save(User user) {
        jpaAccess.save(user);
        return user.getId();
    }

    public User get(int id) {
        return jpaAccess.get(User.class, id);
    }

    @Inject
    public void setJpaAccess(JPAAccess jpaAccess) {
        this.jpaAccess = jpaAccess;
    }
}
