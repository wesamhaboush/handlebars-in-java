package com.codebreeze.templating.pebble;

import com.codebreeze.templating.AbstractTemplateTest;
import com.google.common.base.Throwables;
import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.error.PebbleException;
import com.mitchellbosecke.pebble.template.PebbleTemplate;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class PebbleTest extends AbstractTemplateTest{
    private final static Map<String, Object> CONTEXT = new HashMap<String, Object>(){{
        put("users", getUserWrapper().getUsers());
    }};
    private static final PebbleTemplate TEMPLATE = getTemplate();

    @Test
    public void test() {
        try {
            final Writer writer = new StringWriter();
            TEMPLATE.evaluate(writer, CONTEXT);
            consume(writer.toString());
        } catch (PebbleException | IOException e) {
            throw Throwables.propagate(e);
        }
    }

    private static PebbleTemplate getTemplate() {
        try {
            return new PebbleEngine().getTemplate("templates/hello.peb");
        } catch (PebbleException e) {
            throw Throwables.propagate(e);
        }
    }
}
