package com.codebreeze.templating.freemarker;

import com.codebreeze.templating.AbstractTemplateTest;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;

public class FreeMarkerTest extends AbstractTemplateTest {
    @Test
    public void testStuff() throws IOException, TemplateException {
        final Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        cfg.setTemplateLoader(new ClassTemplateLoader(this.getClass(), "/"));
        final Template template = cfg.getTemplate("templates/hello.ftl");
        final StringWriter sw = new StringWriter();
        template.process(getUserWrapper(), sw);
        System.out.println(sw);
    }

}
