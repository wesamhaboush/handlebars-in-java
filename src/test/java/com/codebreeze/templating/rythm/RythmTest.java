package com.codebreeze.templating.rythm;

import com.codebreeze.templating.AbstractTemplateTest;
import com.google.common.base.Throwables;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.rythmengine.Rythm;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.common.io.Resources.getResource;

public class RythmTest extends AbstractTemplateTest{

    public static final Map<String, Object> PARAMS = new HashMap<String,Object>(){{
        put("users", getUserWrapper().getUsers());
    }};
    private static final String TEMPLATE_TEXT = getTemplateText();

    @Test
    public void test() {
        consume(Rythm.render(TEMPLATE_TEXT, PARAMS));
    }

    private static String getTemplateText() {
        try {
            return IOUtils.toString(getResource(RythmTest.class, "/templates/hello.rythm").openStream());
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
    }
}
