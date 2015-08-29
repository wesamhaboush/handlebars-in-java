package com.codebreeze.templating.pebble;

import com.codebreeze.templating.AbstractTemplateTest;
import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.error.PebbleException;
import com.mitchellbosecke.pebble.template.PebbleTemplate;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.stringtemplate.v4.ST;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import static com.google.common.io.Resources.getResource;

public class PebbleTest extends AbstractTemplateTest{

    @Test
    public void stringTemplateTest2() throws IOException, PebbleException {
        PebbleEngine engine = new PebbleEngine();
        PebbleTemplate compiledTemplate = engine.getTemplate("templates/hello.peb");
        Writer writer = new StringWriter();

        Map<String, Object> context = new HashMap<>();
        context.put("users", getUserWrapper().getUsers());
        compiledTemplate.evaluate(writer, context);
        System.out.println(writer.toString());
    }
}
