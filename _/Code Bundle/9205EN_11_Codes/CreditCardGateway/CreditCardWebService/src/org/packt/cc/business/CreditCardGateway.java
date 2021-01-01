package org.packt.cc.business;

import java.math.BigDecimal;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.Locale;

import java.util.UUID;

import java.util.Vector;

import javax.jws.WebService;

import javax.xml.ws.Holder;

import org.packt.backend.BackEndSystem;
import org.packt.cc.CreditCardData;
import org.packt.cc.TransactionResponse;
import org.packt.cc.exception.ExpiryDateException;

@WebService(serviceName = "CCGateSvc", portName = "CCGateSvcPort", endpointInterface = "org.packt.cc.business.CCGatePortType")
public class CreditCardGateway {
    public CreditCardGateway() {
    }
    
    public TransactionResponse AuthoriseCreditCard(CreditCardData ccd, BigDecimal amount) throws ExpiryDateException {    
        
        System.out.println("res");
        
         BigDecimal limit = new BigDecimal(10000);

        if (limit.compareTo(amount) <= 0)
            return new TransactionResponse("Limit excedded.", 1000, null);
        
        String ccNo= ccd.getCardNumber();
        if (!ccNo.startsWith("4444"))
            return new TransactionResponse("Not supported credit card.", 1001, null);
        
        String expiry= ccd.getCardExpiry();
        
       
        try {
            Date today = new Date();
            Date date = new SimpleDateFormat("MM/yy", Locale.ENGLISH).parse(expiry);
            
            System.out.println(date);
            
            if (today.after(date))
                return new TransactionResponse("Credit card expired.", 1003, null);
            
            
            
        } catch (ParseException e) {
            throw new ExpiryDateException("Unable to parse date.");            
            //e.printStackTrace();            
            //return new TransactionResponse("Expiry date invalid.", 1002, null);
        } 
    
        return new TransactionResponse("Success.", 10000, UUID.randomUUID().toString());    
    }
    
    private boolean isAuthorised(String token) {
        if (token != null)
            return true;
        else
            return false;            
    }

    private boolean isFraud(String token) {
        if (token.toString().length() < 37)
            return true;
        else
            return false;            
    }
    
    public TransactionResponse Purchase(String token, BigDecimal amount) {
        if ( token != null && isAuthorised(token.toString()) ) {
            BackEndSystem.getInstance().purchaseOp(UUID.fromString(token), amount);
            return new TransactionResponse("Success.", 20000, token);    
        } else {
            return new TransactionResponse("Unauthorized.", 9999, null);         
        }
    }
    
    public TransactionResponse Refund(String token, Holder<BigDecimal> amount) {
//    public TransactionResponse Refund(String token, BigDecimal amount) {        
        if ( token != null && isFraud(token.toString()) ) {
            BigDecimal val= amount.value;
        
            BackEndSystem.getInstance().refundOp(UUID.fromString(token), val);
            //BackEndSystem.getInstance().refundOp(UUID.fromString(token), amount);
            
            double valI= val.doubleValue();
            double fee =  valI * 0.2;
            
            amount.value= new BigDecimal(valI - fee);
            
            
            return new TransactionResponse("Success.", 20001, token);    
        } else {
            return new TransactionResponse("Fraud suspect.", 9998, null);         
        }
    }

    public TransactionResponse VoidOp(String token, BigDecimal amount) {
        if ( token != null && isAuthorised(token) && isFraud(token) ) {
            BackEndSystem.getInstance().voidOp(UUID.fromString(token), amount);
            return new TransactionResponse("Success.", 20002, token);    
        } else {
            return new TransactionResponse("Authorisation invaliad or fraud suspect.", 9997, null);         
        }
    }
    
    public void OutputTransactions() {
        Vector tr = BackEndSystem.getInstance().getTransactions();
        
        System.out.println("-----------------------------");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Performed transactions:" + "    " + new Date());
        for (int i=0; i< tr.size(); i++) {
            System.out.println((String)tr.elementAt(i));
        }
        System.out.println("-----------------------------");
        
    }
    
}
