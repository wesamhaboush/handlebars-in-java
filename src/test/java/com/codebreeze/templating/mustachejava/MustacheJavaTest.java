package com.codebreeze.templating.mustachejava;

import com.codebreeze.templating.AbstractTemplateTest;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import com.github.mustachejava.resolver.ClasspathResolver;
import org.junit.Test;

import java.io.StringWriter;

public class MustacheJavaTest extends AbstractTemplateTest{
    private static final Mustache TEMPLATE = getTemplate();

    @Test
    public void test(){
        final StringWriter sw = new StringWriter();
        TEMPLATE.execute(sw, getUserWrapper());
        consume(sw.toString());
    }

    private static Mustache getTemplate() {
        final MustacheFactory mf = new DefaultMustacheFactory(new ClasspathResolver());
        return mf.compile("templates/hello.mustache");
    }
}
