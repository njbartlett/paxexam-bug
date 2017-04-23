package org.example.paxexam.integration;

import static org.junit.Assert.assertFalse;
import static org.ops4j.pax.exam.CoreOptions.junitBundles;
import static org.ops4j.pax.exam.CoreOptions.options;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

@RunWith(PaxExam.class)
public class ExampleTest {
    
    @Inject
    BundleContext context;

    @Configuration
    public static Option[] configuration() {
        return options(
            junitBundles()
        );
    }
    
    @Test
    public void test_example() {
        Set<String> bsns = Arrays.stream(context.getBundles()).map(Bundle::getSymbolicName).collect(Collectors.toSet());
        assertFalse("Framework should not contain osgi.cmpn. Actual list of bundles: " + bsns.stream().collect(Collectors.joining(", ")),
                bsns.contains("osgi.cmpn"));
    }
}
