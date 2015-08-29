package com.codebreeze.templating.rythm;

import com.codebreeze.templating.AbstractTemplateTest;
import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.error.PebbleException;
import com.mitchellbosecke.pebble.template.PebbleTemplate;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.rythmengine.Rythm;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import static com.google.common.io.Resources.getResource;

public class RythmTest extends AbstractTemplateTest{

    @Test
    public void test() throws IOException, PebbleException {
        final Map<String, Object> params = new HashMap<>();
        params.put("users", getUserWrapper().getUsers());
        final String templateText = IOUtils.toString(getResource(getClass(), "/templates/hello.rythm").openStream());
        System.out.println(Rythm.render(templateText, params));
    }
}
