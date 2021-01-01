package org.packt.log;

import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.fabric.logging.LogFormatter;

public class LogTheBpel {
     //private static final Logger logger = Logger.getLogger("oracle.soa.Logger");
     private static final Logger logger = Logger.getLogger("org.packt.log.Logger");
    
    
     public static final void log(String message) {
        logger.log(Level.WARNING, message);
     }

     static {
          LogFormatter.configFormatter(logger);
     }

}
