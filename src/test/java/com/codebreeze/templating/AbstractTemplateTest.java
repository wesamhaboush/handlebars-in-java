package com.codebreeze.templating;

import com.codebreeze.templating.model.User;
import com.codebreeze.templating.model.UserWrapper;

import java.util.function.Consumer;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.BooleanUtils.toBoolean;

public abstract class AbstractTemplateTest {

    private static final Consumer<String> CONSUMER =
            consumer();

    private static Consumer<String> consumer() {
        return toBoolean(System.getProperty("performance", "false"))
        ? (s -> {})
        : (s -> System.out.println(s));
    }

    public static final UserWrapper USER_WRAPPER = new UserWrapper(asList(
                    new User("a", "b", "c", "d"),
                    new User("e", "f", "g", "h"),
                    new User("i", "j", "k", "l")
    ));

    protected static UserWrapper getUserWrapper(){
        return USER_WRAPPER;
    }

    protected static void consume(final String value){
        CONSUMER.accept(value);
    }
}
