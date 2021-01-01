package org.packt.log;

import static org.junit.Assert.*;
import org.junit.Test;

public class LogTheBpelTest {
    public LogTheBpelTest() {
    }

    public static void main(String[] args) {
        String[] args2 = { LogTheBpelTest.class.getName() };
        org.junit.runner.JUnitCore.main(args2);
    }

    /**
     * @see LogTheBpel#log(String)
     */
    @Test
    public void testLog() {        
        LogTheBpel.log("Test message");
    }
}
