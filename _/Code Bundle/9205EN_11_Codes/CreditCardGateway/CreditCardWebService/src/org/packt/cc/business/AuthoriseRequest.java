package org.packt.cc.business;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import javax.jws.WebParam;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import javax.xml.bind.annotation.XmlType;

import org.packt.cc.CreditCardData;
import org.packt.cc.TransactionResponse;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "auth", propOrder = {
    "ccd",
    "amount"
})
public class AuthoriseRequest {
    private CreditCardData ccd;
    private BigDecimal amount;
    
    public AuthoriseRequest() {
        
    }
    
    public AuthoriseRequest(CreditCardData ccd, BigDecimal amount) {
        this.ccd= ccd;
        this.amount= amount;
    }


    public void setCcd(CreditCardData ccd) {
        this.ccd = ccd;
        System.out.println("set ccd");
    }

    public CreditCardData getCcd() {
        System.out.println("get ccd");
        return ccd;
    }

    public void setAmount(BigDecimal amount) {
        System.out.println("set amnt");
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        System.out.println("get amnt");
        return amount;
    }
}
