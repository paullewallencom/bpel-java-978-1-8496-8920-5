package org.packt.log;

import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.fabric.logging.LogFormatter;

public class LogTheBpelExt {
     private static final Logger logger = Logger.getLogger("org.packt.log.Logger");
    
    
     public static final void log(String message) {
        logger.log(Level.WARNING, message);
     }
     
     public static final void logException(String msg, Exception e) {
         logger.logp(Level.SEVERE, "", "", msg, e);
     }

     static {
          LogFormatter.configFormatter(logger);
     }

    public static void main(String[] args) {
        LogTheBpelExt logTheBpelExt = new LogTheBpelExt();
        logTheBpelExt.log("test");
        
        try
        {
            int a= 7 / 0;
        } catch (ArithmeticException ex) {
            logTheBpelExt.logException("Error in calculations", ex);
        }

    }
}
