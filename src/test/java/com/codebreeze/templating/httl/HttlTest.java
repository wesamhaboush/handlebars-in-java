package com.codebreeze.templating.httl;

import com.codebreeze.templating.AbstractTemplateTest;
import com.google.common.base.Throwables;
import httl.Engine;
import httl.Template;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class HttlTest extends AbstractTemplateTest{
    private static final Map<String, Object> PARAMETERS = new HashMap<String, Object>(){{
        put("users", getUserWrapper().getUsers());
    }};
    private static final Template TEMPLATE = getTemplate();

    @Test
    public void test(){
        try {
            final StringWriter sw = new StringWriter();
            TEMPLATE.render(PARAMETERS, sw);
            consume(sw.toString());
        } catch (IOException | ParseException e) {
            throw Throwables.propagate(e);
        }
    }

    private static Template getTemplate(){
        try {
            final Engine engine = Engine.getEngine();
            return engine.getTemplate("/templates/hello.httl");
        } catch (IOException | ParseException e) {
            throw Throwables.propagate(e);
        }
    }
}
