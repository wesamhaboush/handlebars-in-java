package com.codebreeze.templating.velocity;

import com.codebreeze.templating.AbstractTemplateTest;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.junit.Test;

import java.io.StringWriter;

public class VelocityTest extends AbstractTemplateTest{
    private static final Template TEMPLATE = getTemplate();
    private static final VelocityContext CONTEXT = new VelocityContext(){
        {
            put("users", getUserWrapper().getUsers());
        }
    };

    @Test
    public void test(){
        final StringWriter writer = new StringWriter();
        TEMPLATE.merge(CONTEXT, writer);
        consume( writer.toString() );
    }

    private static Template getTemplate(){
        Velocity.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        Velocity.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        Velocity.init();
        return Velocity.getTemplate( "/templates/hello.vm" );
    }

}
