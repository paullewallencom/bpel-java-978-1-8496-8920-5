package org.packt.redirect;

import java.io.PrintStream;

public class Redirector {
    private static Redirector m_Instrance;
    private static PrintStream origOut;
    private static PrintStream origErr;
    
    public Redirector() {
        super();
    }
    
    public static  Redirector getinstance() {
        if (m_Instrance == null) {
            m_Instrance = new Redirector();
        }
        return m_Instrance;
    }
    
    public static void activate() {
        origOut= System.out;                
        System.setOut(new LogStream(System.out));
        origErr= System.err;
        System.setErr(new LogStream(System.err));
    }
    
    public static void deactivate() {        
        System.setOut(origOut);
        System.setErr(origErr);
    }
    
}
