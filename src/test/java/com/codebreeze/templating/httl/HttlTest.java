package com.codebreeze.templating.httl;

import com.codebreeze.templating.AbstractTemplateTest;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class HttlTest extends AbstractTemplateTest{
    @Test
    public void test() throws IOException, ParseException {
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put ("users", getUserWrapper().getUsers());
        httl.Engine engine = httl.Engine.getEngine();
        httl.Template template = engine.getTemplate("/templates/hello.httl");
        template.render (parameters, System.out);
    }
}
