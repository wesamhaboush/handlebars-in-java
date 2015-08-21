package com.codebreeze.templating.handlebars;

import com.codebreeze.templating.AbstractTemplateTest;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;

public class HandlebarsTest extends AbstractTemplateTest{
    @Test
    public void testStuff() throws IOException {
        final Template template = createHandlebarsTemplate();
        final StringWriter sw = new StringWriter();
        template.apply(getUserWrapper(), sw);
        System.out.println(sw);
    }

    private Template createHandlebarsTemplate() throws IOException {
        final TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        final Handlebars handlebars = new Handlebars(loader);
        return handlebars.compile("hello");
    }

}
