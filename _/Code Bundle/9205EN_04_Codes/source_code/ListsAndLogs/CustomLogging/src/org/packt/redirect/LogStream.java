package org.packt.redirect;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.packt.log.LogTheBpelExt;

public class LogStream extends PrintStream {
    public LogStream(File file, String string) throws FileNotFoundException,
                                                      UnsupportedEncodingException {
        super(file, string);
    }

    public LogStream(File file) throws FileNotFoundException {
        super(file);
    }

    public LogStream(String string, String string1) throws FileNotFoundException,
                                            UnsupportedEncodingException {
        super(string, string1);
    }

    public LogStream(String string) throws FileNotFoundException {
        super(string);
    }

    public LogStream(OutputStream outputStream, boolean b, String string) throws UnsupportedEncodingException {
        super(outputStream, b, string);
    }

    public LogStream(OutputStream outputStream, boolean b) {
        super(outputStream, b);
    }

    public LogStream(OutputStream outputStream) {
        super(outputStream);
    }


    @Override
    public void println(String x) {
        
        StackTraceElement caller = Thread.currentThread().getStackTrace()[2];
        
        LogTheBpelExt.log( caller.getClassName() + "  " + caller.getMethodName() +
                           "  " + caller.getLineNumber() + ": " + x);
        
        //super.println(x);
    }
}
