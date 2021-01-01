package logging;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import java.net.InetAddress;

import java.net.UnknownHostException;

import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Handler;

import java.util.logging.LogRecord;


public class CustomLogger extends Handler {
    FileOutputStream fileOutputStream;
    PrintWriter printWriter;
    
    
    public CustomLogger() {
        try {
            InetAddress iAddress = InetAddress.getLocalHost();
            String hostName = iAddress.getHostName();
            
            String tempDir= System.getProperty("java.io.tmpdir");
            
            String fileLoc= tempDir + hostName + ".log";
            System.out.println(fileLoc);
            fileOutputStream = new FileOutputStream(fileLoc);
            printWriter = new PrintWriter(fileOutputStream);            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
                e.printStackTrace();
        }   
        
    }

    public static void main(String[] args) {
        CustomLogger myHandler = new CustomLogger();
    }

    public void publish(LogRecord record) {
        if (!isLoggable(record))
            return;

        printWriter.println(getFormatter().format(record));     
    }

    public void flush() {
        printWriter.flush();
    }

    public void close() {
        printWriter.close();
    }

}
