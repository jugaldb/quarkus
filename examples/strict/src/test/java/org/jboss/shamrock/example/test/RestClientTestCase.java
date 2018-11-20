package org.jboss.shamrock.example.test;

import org.jboss.shamrock.test.URLTester;
import org.jboss.shamrock.test.ShamrockTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(ShamrockTest.class)
public class RestClientTestCase {

    @Test
    public void testMicroprofileClient() {
        Assert.assertEquals("TEST", URLTester.relative("rest/client/manual").invokeURL().asString());
    }

    @Test
    public void testMicroprofileClientCDIIntegration() {
        Assert.assertEquals("TEST", URLTester.relative("rest/client/cdi").invokeURL().asString());
    }
}
