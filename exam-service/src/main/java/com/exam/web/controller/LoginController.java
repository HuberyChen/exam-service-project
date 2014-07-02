package com.exam.web.controller;

import com.core.json.JSONBinder;
import com.core.platform.DefaultSiteWebConfig;
import com.core.platform.web.site.session.SessionContext;
import com.core.utils.StringUtils;
import com.exam.domain.User;
import com.exam.service.UserService;
import com.exam.web.SessionConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.util.Map;

/**
 * @author hubery
 */
@Controller
public class LoginController extends DefaultSiteWebConfig {

    private UserService userService;
    private SessionContext sessionContext;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Map<String, Object> model) {
        return "login/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "userName") String name, @RequestParam(value = "password") String password, Map<String, Object> model) {
        User user = userService.get(name.trim());
        if (null != user && StringUtils.equals(password.trim(), user.getPassword())) {
            String json = JSONBinder.binder(User.class).toJSON(user);
            sessionContext.set(SessionConstants.LOGGED_IN, Boolean.TRUE);
            sessionContext.set(SessionConstants.USER_DETAILS, json);
            return "redirect:/home";
        }

        model.put("msgType", "error");
        return "login/login";
    }

    @RequestMapping(value = "/signOut", method = RequestMethod.GET)
    public String signOut(Map<String, Object> model) {
        sessionContext.invalidate();
        return "redirect:/login";
    }

    @Inject
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Inject
    public void setSessionContext(SessionContext sessionContext) {
        this.sessionContext = sessionContext;
    }
}
