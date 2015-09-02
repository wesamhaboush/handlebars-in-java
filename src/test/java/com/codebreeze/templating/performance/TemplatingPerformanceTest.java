package com.codebreeze.templating.performance;

import com.codebreeze.templating.beetl.BeetlTest;
import com.codebreeze.templating.chunk.ChunkTest;
import com.codebreeze.templating.freemarker.FreeMarkerTest;
import com.codebreeze.templating.handlebars.HandlebarsTest;
import com.codebreeze.templating.httl.HttlTest;
import com.codebreeze.templating.jmte.JmteTest;
import com.codebreeze.templating.jmustache.JMustacheTest;
import com.codebreeze.templating.mustachejava.MustacheJavaTest;
import com.codebreeze.templating.pebble.PebbleTest;
import com.codebreeze.templating.rythm.RythmTest;
import com.codebreeze.templating.stringtemplate.StringTemplateTest;
import com.codebreeze.templating.velocity.VelocityTest;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@Measurement(iterations = 5, time = 1)
@Warmup(iterations = 5, time = 1)
@Fork(3)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Thread)
public class TemplatingPerformanceTest {

    BeetlTest beetlTest;
    ChunkTest chunkTest;
    FreeMarkerTest freeMarkerTest;
    HandlebarsTest handlebarsTest;
    HttlTest httlTest;
    JmteTest jmteTest;
    JMustacheTest jMustacheTest;
    MustacheJavaTest mustacheJavaTest;
    PebbleTest pebbleTest;
    RythmTest rythmTest;
    StringTemplateTest stringTemplateTest;
    VelocityTest velocityTest;


    @Setup
    public void setup() {
        beetlTest = new BeetlTest();
        chunkTest = new ChunkTest();
        freeMarkerTest = new FreeMarkerTest();
        handlebarsTest = new HandlebarsTest();
        httlTest = new HttlTest();
        jmteTest = new JmteTest();
        jMustacheTest = new JMustacheTest();
        mustacheJavaTest = new MustacheJavaTest();
        pebbleTest = new PebbleTest();
        rythmTest = new RythmTest();
        stringTemplateTest = new StringTemplateTest();
        velocityTest = new VelocityTest();
    }

    @Benchmark
    public void beetl() {
        beetlTest.test();
    }

    @Benchmark
    public void chunk() {
        chunkTest.test();
    }

    @Benchmark
    public void freeMarker() {
        freeMarkerTest.test();
    }

    @Benchmark
    public void handlebars() {
        handlebarsTest.test();
    }

    @Benchmark
    public void httl() {
        httlTest.test();
    }

    @Benchmark
    public void jmte() {
        jmteTest.test();
    }

    @Benchmark
    public void jmustache() {
        jMustacheTest.test();
    }

    @Benchmark
    public void mustachejava() {
        mustacheJavaTest.test();
    }

    @Benchmark
    public void pebble() {
        pebbleTest.test();
    }

    @Benchmark
    public void rythm() {
        rythmTest.test();
    }

    @Benchmark
    public void stringTemplate() {
        stringTemplateTest.test();
    }

    @Benchmark
    public void velocity() {
        velocityTest.test();
    }
}