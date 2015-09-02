package com.codebreeze.templating.beetl;

import com.codebreeze.templating.AbstractTemplateTest;
import com.google.common.base.Throwables;
import org.apache.commons.io.IOUtils;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.StringTemplateResourceLoader;
import org.junit.Test;

import java.io.IOException;

import static com.google.common.io.Resources.getResource;


public class BeetlTest extends AbstractTemplateTest{
    private static final Template TEMPLATE = getTemplate();

    @Test
    public void test() {
        TEMPLATE.binding("users", getUserWrapper().getUsers());
        consume(TEMPLATE.render());
    }

    private static Template getTemplate(){
        try {
            final String templateText =
                    IOUtils.toString(getResource(BeetlTest.class, "/templates/hello.btl").openStream());
            final StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
            final Configuration cfg = Configuration.defaultConfiguration();
            final GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
            return gt.getTemplate(templateText);
        }catch (IOException io){
            throw Throwables.propagate(io);
        }
    }
}
