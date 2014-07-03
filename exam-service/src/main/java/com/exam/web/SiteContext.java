package com.exam.web;

import com.core.json.JSONBinder;
import com.core.platform.exception.SessionTimeOutException;
import com.core.platform.web.site.session.SessionContext;
import com.exam.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hubery.chen
 */
@Component
public class SiteContext {
    private SessionContext sessionContext;

    public Map<String, Object> getModel() {
        Map<String, Object> model = new HashMap<>();
        model.put("user", getUserName());

        return model;
    }

    public void login(User user) {
        String json = JSONBinder.binder(User.class).toJSON(user);
        sessionContext.set(SessionConstants.LOGGED_IN, Boolean.TRUE);
        sessionContext.set(SessionConstants.USER_DETAILS, json);
    }

    public void signOut() {
        sessionContext.invalidate();
    }

    public User getUser() {
        String json = sessionContext.get(SessionConstants.USER_DETAILS);
        if (StringUtils.isBlank(json))
            throw new SessionTimeOutException("session timeout.");
        return JSONBinder.binder(User.class).fromJSON(json);
    }

    public String getUserName() {
        return getUser().getName();
    }

    boolean loggedIn() {
        Boolean loggedIn = sessionContext.get(SessionConstants.LOGGED_IN);
        return Boolean.TRUE.equals(loggedIn);
    }

    @Inject
    public void setSessionContext(SessionContext sessionContext) {
        this.sessionContext = sessionContext;
    }

}
