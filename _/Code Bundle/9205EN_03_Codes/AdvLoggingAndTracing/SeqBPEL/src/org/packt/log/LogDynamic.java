package org.packt.log;

import java.io.File;

import java.util.Enumeration;

import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class LogDynamic {
    private static final Logger logger = Logger.getLogger("org.packt.dynamic.log.Logger");
    private static FileAppender fa = null;
    
    public static final void log(String message, String pid) {
        if (fa!= null) {            
            if(fa.getFile().indexOf(pid) == -1)
            {                
               fa.setFile("C:/temp/log_BPEL_" + pid + ".log");
               fa.activateOptions();           
            }
        }       
       logger.log(Level.INFO, message);
    }

    static {
        String sLog4jFile = "C:\\Programs\\Oracle\\Middleware\\user_projects\\domains\\SOA_Dev\\dyna_log4j.properties";                  
        PropertyConfigurator.configure(sLog4jFile);      
        Logger rootLogger= Logger.getRootLogger();
        Enumeration appenders = rootLogger.getAllAppenders();
                
        while(appenders.hasMoreElements()) {
            Appender currAppender = (Appender) appenders.nextElement();
            if(currAppender instanceof FileAppender) {
                fa = (FileAppender) currAppender;
            }
        }
    }

}
