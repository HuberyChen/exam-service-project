package com.exam.dao;

import com.exam.SpringTest;
import com.exam.domain.Permission;
import com.exam.domain.User;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import javax.inject.Inject;

/**
 * @author hubery
 */
@Ignore
public class UserDaoTest extends SpringTest {

    @Inject
    private UserDao userDao;

    @Test
    public void testSave() {
        userDao.save(mockUser());
    }

    @Test
    public void testGet() {
        User user = userDao.get(3);
        Assert.assertEquals("Hubery", user.getName());
    }

    private User mockUser() {
        User user = new User();
        user.setName("hubery");
        user.setPermission(Permission.Admin);
        return user;
    }
}
