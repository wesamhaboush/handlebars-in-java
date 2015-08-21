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
    @Test
    public void testTemplatingInVelocity(){
        Velocity.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        Velocity.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        Velocity.init();
        Template template = Velocity.getTemplate( "/templates/hello.vm" );
        VelocityContext context = new VelocityContext();
        context.put("users", getUserWrapper().getUsers());
        final StringWriter writer = new StringWriter();
        template.merge(context, writer);
        System.out.println( writer.toString() );
    }

}
