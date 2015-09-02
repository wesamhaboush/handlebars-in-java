package com.codebreeze.templating.jmustache;

import com.codebreeze.templating.AbstractTemplateTest;
import com.google.common.base.Throwables;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import static com.google.common.io.Resources.getResource;
import static org.apache.commons.io.IOUtils.toBufferedReader;

public class JMustacheTest extends AbstractTemplateTest{
    private static final Template TEMPLATE = getTemplate();

    @Test
    public void test(){
        consume(TEMPLATE.execute(new Object() {
            Object users = getUserWrapper().getUsers();
        }));
    }

    private static Template getTemplate(){
        try {
            final Reader reader = toBufferedReader(new InputStreamReader(
                            getResource(JMustacheTest.class, "/templates/hello.mustache").openStream())
            );
            return Mustache.compiler().compile(reader);
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
    }
}
