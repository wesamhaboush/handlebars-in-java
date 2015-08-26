package com.codebreeze.templating.jmustache;

import com.codebreeze.templating.AbstractTemplateTest;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import static com.google.common.io.Resources.getResource;
import static org.apache.commons.io.IOUtils.toBufferedReader;

public class JMustacheTest extends AbstractTemplateTest{
    @Test
    public void testJMustache() throws IOException {
        final Reader reader = toBufferedReader(new InputStreamReader(
                        getResource(getClass(), "/templates/hello.mustache").openStream())
        );
        Template template = Mustache.compiler().compile(reader);
        final String result = template.execute(new Object() {
            Object users = getUserWrapper().getUsers();
        });
        System.out.println(result);
    }
}
