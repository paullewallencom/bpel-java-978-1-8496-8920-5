package org.packt.ejb.atm;

import java.util.Hashtable;

import javax.ejb.Stateless;

@Stateless(mappedName = "ExchangeATM_EJB")
public class ExchATM_EJB implements ExchATM_EJBRemote, ExchATM_EJBLocal {
    Hashtable rates= new Hashtable();

    public ExchATM_EJB() {
        rates.put("USD", 0.876);
        rates.put("CHF", 0.996);
        rates.put("GBP", 1.012);
        rates.put("EUR", 1.000);
    }

    public double exchangeMoney(double originalAmount, String currency) {
        double fee= 0.95; //5 %        
        double rate= ((Double)rates.get(currency)).doubleValue();
        
        double excMoneyNoFee= originalAmount * rate;
        double excMoneyWFee= excMoneyNoFee * fee;
        
        return excMoneyWFee;
    }
}
