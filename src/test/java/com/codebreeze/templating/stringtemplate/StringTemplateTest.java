package com.codebreeze.templating.stringtemplate;

import com.codebreeze.templating.AbstractTemplateTest;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupDir;
import org.stringtemplate.v4.STGroupFile;

import java.io.IOException;

import static com.google.common.io.Resources.getResource;

public class StringTemplateTest extends AbstractTemplateTest{

    @Test
    public void stringTemplateTest2() throws IOException {
        final ST template = new ST(IOUtils.toString(getResource(getClass(), "/templates/hello.st").openStream()),
                '$', '$');
        template.add("users", getUserWrapper().getUsers());

        System.out.println(template.render());
    }
}
