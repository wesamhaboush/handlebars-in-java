package com.codebreeze.templating.freemarker;

import com.codebreeze.templating.AbstractTemplateTest;
import com.google.common.base.Throwables;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;

public class FreeMarkerTest extends AbstractTemplateTest {
    private final static Template TEMPLATE = getTemplate();

    @Test
    public void test() {
        try {
            final StringWriter sw = new StringWriter();
            TEMPLATE.process(getUserWrapper(), sw);
            consume(sw.toString());
        } catch (TemplateException | IOException e) {
            Throwables.propagate(e);
        }
    }

    private static Template getTemplate(){
        try {
            final Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
            cfg.setTemplateLoader(new ClassTemplateLoader(FreeMarkerTest.class, "/"));
            return cfg.getTemplate("templates/hello.ftl");
        }catch (IOException e){
            throw Throwables.propagate(e);
        }
    }

}
