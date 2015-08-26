package com.codebreeze.templating.mustachejava;

import com.codebreeze.templating.AbstractTemplateTest;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import com.github.mustachejava.resolver.ClasspathResolver;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class MustacheJavaTest extends AbstractTemplateTest{
    @Test
    public void testMustacheJava() throws IOException {
        final MustacheFactory mf = new DefaultMustacheFactory(new ClasspathResolver());
        final Mustache mustache = mf.compile("templates/hello.mustache");
        final StringWriter sw = new StringWriter();
        mustache.execute(sw, getUserWrapper());
        System.out.println(sw);
    }
}
