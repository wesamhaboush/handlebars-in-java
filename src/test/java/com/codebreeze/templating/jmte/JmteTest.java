package com.codebreeze.templating.jmte;

import com.codebreeze.templating.AbstractTemplateTest;
import com.floreysoft.jmte.Engine;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import static com.google.common.io.Resources.getResource;

public class JmteTest extends AbstractTemplateTest{
    @Test
    public void test() throws IOException, ParseException {
        final String templateText = IOUtils.toString(getResource(getClass(), "/templates/hello.mte").openStream());
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("users", getUserWrapper().getUsers());
        Engine engine = new Engine();
        String transformed = engine.transform(templateText, model);
        System.out.println(transformed);
    }
}
