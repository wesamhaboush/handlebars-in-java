package com.codebreeze.templating.stringtemplate;

import com.codebreeze.templating.AbstractTemplateTest;
import com.google.common.base.Throwables;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.stringtemplate.v4.ST;

import java.io.IOException;

import static com.google.common.io.Resources.getResource;

public class StringTemplateTest extends AbstractTemplateTest{
    private static final ST TEMPLATE = getTemplate();

    @Test
    public void test() {
        TEMPLATE.add("users", getUserWrapper().getUsers());
        consume(TEMPLATE.render());
    }

    private static ST getTemplate() {
        try {
            return new ST(IOUtils.toString(getResource(StringTemplateTest.class, "/templates/hello.st").openStream()),
                    '$', '$');
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
    }
}
