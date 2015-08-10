package com.codebreeze.handlebars;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import static java.util.Arrays.asList;

public class HandlebarsTest {
    @Test
    public void testStuff() throws IOException {
        final UserWrapper users = new UserWrapper(asList(new User("a", "b", "c", "d")));
        final Template template = createHandlebarsTemplate();
        final StringWriter sw = new StringWriter();
        template.apply(users, sw);
        System.out.println(sw);
    }

    private Template createHandlebarsTemplate() throws IOException {
        final TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".html");
        final Handlebars handlebars = new Handlebars(loader);
        return handlebars.compile("hello");
    }

    private static class User {
        private String username;
        private String firstName;
        private String lastName;
        private String email;

        private User(String username, String firstName, String lastName, String email) {
            this.username = username;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    private static class UserWrapper {
        private final List<User> users;

        private UserWrapper(List<User> users) {
            this.users = users;
        }

        public List<User> getUsers() {
            return users;
        }
    }

}
