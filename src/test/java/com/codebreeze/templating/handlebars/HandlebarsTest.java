package com.codebreeze.templating.handlebars;

import com.codebreeze.templating.AbstractTemplateTest;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;
import com.google.common.base.Throwables;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;

public class HandlebarsTest extends AbstractTemplateTest{
    private final static Template TEMPLATE = getTemplate();

    @Test
    public void test(){
        try {
            final StringWriter sw = new StringWriter();
            TEMPLATE.apply(getUserWrapper(), sw);
            consume(sw.toString());
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
    }

    private static Template getTemplate() {
        try {
            final TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
            final Handlebars handlebars = new Handlebars(loader);
            return handlebars.compile("hello");
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
    }

}
