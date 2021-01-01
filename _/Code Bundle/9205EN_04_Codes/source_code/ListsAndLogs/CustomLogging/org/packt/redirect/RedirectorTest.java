package org.packt.redirect;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RedirectorTest {
    public RedirectorTest() {
    }

    public static void main(String[] args) {
        String[] args2 = { RedirectorTest.class.getName() };
        org.junit.runner.JUnitCore.main(args2);
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * @see Redirector#getinstance()
     */
    @Test
    public void testGetinstance() {
        Redirector.getinstance().activate();
        System.out.println("Hello, World out");
        System.err.println("Hello, World err");
        Redirector.getinstance().deactivate();        
    }
}
