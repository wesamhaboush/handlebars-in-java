package com.codebreeze.templating.beetl;

import com.codebreeze.templating.AbstractTemplateTest;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;


public class BeetlTest extends AbstractTemplateTest{
    @Test
    public void test() throws IOException {
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate("/templates/hello.btl");
        t.binding("users", getUserWrapper().getUsers());
        System.out.println(t.render());
    }
}
