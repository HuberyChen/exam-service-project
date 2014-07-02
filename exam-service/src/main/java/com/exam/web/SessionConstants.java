package com.exam.web;


import com.core.collection.Key;

public class SessionConstants {
    public static final Key<Boolean> LOGGED_IN = Key.booleanKey("loggedIn");

    public static final Key<String> USER_DETAILS = Key.stringKey("user");

}
