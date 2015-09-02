package com.codebreeze.templating.chunk;

import com.codebreeze.templating.AbstractTemplateTest;
import com.google.common.base.Throwables;
import com.x5.template.Chunk;
import com.x5.template.Theme;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;

import static com.google.common.io.Resources.getResource;

public class ChunkTest extends AbstractTemplateTest{
    private static final Chunk TEMPLATE = getTemplate();

    @Test
    public void test() {
        TEMPLATE.set("users", getUserWrapper().getUsers());
        consume(TEMPLATE.toString());
    }

    private static Chunk getTemplate(){
        try {
            final Theme theme = new Theme();
            final Chunk html = theme.makeChunk();
            final String templateText =
                    IOUtils.toString(getResource(ChunkTest.class, "/templates/hello.chtml").openStream());
            html.append(templateText);
            return html;
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
    }
}
