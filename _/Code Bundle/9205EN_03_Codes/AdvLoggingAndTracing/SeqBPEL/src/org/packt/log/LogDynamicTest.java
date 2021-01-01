package org.packt.log;

import java.io.File;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;

public class LogDynamicTest {
    public LogDynamicTest() {
    }

    public static void main(String[] args) {
        String[] args2 = { LogDynamicTest.class.getName() };
        JUnitCore.main(args2);
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * @see LogDynamic#log(String)
     */
    @Test
    public void testLog() {                
        LogDynamic.log("test my message", "12");
    }
}
