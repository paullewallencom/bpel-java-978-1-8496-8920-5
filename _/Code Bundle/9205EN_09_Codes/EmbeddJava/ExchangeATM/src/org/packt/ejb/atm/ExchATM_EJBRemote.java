package org.packt.ejb.atm;

import javax.ejb.Remote;

@Remote
public interface ExchATM_EJBRemote {
    
    public double exchangeMoney(double originalAmount, String currency);
}
