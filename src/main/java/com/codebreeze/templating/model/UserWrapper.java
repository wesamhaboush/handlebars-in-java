package com.codebreeze.templating.model;

import java.util.List;

public class UserWrapper {
    private final List<User> users;

    public UserWrapper(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }
}
