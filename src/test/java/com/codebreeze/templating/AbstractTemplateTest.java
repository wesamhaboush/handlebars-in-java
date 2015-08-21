package com.codebreeze.templating;

import com.codebreeze.templating.model.User;
import com.codebreeze.templating.model.UserWrapper;

import static java.util.Arrays.asList;

public abstract class AbstractTemplateTest {
    protected static UserWrapper getUserWrapper(){
        final UserWrapper users = new UserWrapper(asList(new User("a", "b", "c", "d")));
        return users;
    }
}
