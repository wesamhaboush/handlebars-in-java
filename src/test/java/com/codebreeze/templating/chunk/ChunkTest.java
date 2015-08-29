package com.codebreeze.templating.chunk;

import com.codebreeze.templating.AbstractTemplateTest;
import com.x5.template.Chunk;
import com.x5.template.Theme;
import freemarker.template.TemplateException;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;

import static com.google.common.io.Resources.getResource;

public class ChunkTest extends AbstractTemplateTest{
    @Test
    public void testStuff() throws IOException, TemplateException {
        final Theme theme = new Theme();
        final Chunk html = theme.makeChunk();
        final String templateText = IOUtils.toString(getResource(getClass(), "/templates/hello.chtml").openStream());
        html.append(templateText);
        html.set("users", getUserWrapper().getUsers());
        System.out.println(html.toString());
    }
}
