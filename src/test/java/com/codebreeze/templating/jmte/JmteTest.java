package com.codebreeze.templating.jmte;

import com.codebreeze.templating.AbstractTemplateTest;
import com.floreysoft.jmte.Engine;
import com.google.common.base.Throwables;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import static com.google.common.io.Resources.getResource;

public class JmteTest extends AbstractTemplateTest{
    final String templateText = getTemplateText();

    private static final Map<String, Object> MODEL = new HashMap<String, Object>(){{
        put("users", getUserWrapper().getUsers());
    }};

    private static final Engine TEMPLATE = new Engine();
    @Test
    public void test() {
        consume(TEMPLATE.transform(templateText, MODEL));
    }

    private String getTemplateText() {
        try {
            return IOUtils.toString(getResource(getClass(), "/templates/hello.mte").openStream());
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
    }
}
