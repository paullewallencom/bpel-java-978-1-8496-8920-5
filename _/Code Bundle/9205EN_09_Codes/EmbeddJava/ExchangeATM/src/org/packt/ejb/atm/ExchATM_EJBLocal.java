package org.packt.ejb.atm;

import javax.ejb.Local;

@Local
public interface ExchATM_EJBLocal {
    
    public double exchangeMoney(double originalAmount, String currency);
}
