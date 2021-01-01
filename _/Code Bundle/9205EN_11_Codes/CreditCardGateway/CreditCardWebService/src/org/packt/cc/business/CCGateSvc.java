package org.packt.cc.business;

import java.math.BigDecimal;

import java.rmi.Remote;

import java.rmi.RemoteException;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.packt.cc.CreditCardData;
import org.packt.cc.TransactionResponse;

@WebService
public interface CCGateSvc extends Remote {
    @WebMethod
    public void OutputTransactions() throws RemoteException;

    @WebMethod
    public TransactionResponse Void(String token, BigDecimal amount);

    @WebMethod
    public TransactionResponse Refund(String token, BigDecimal amount);

    @WebMethod
    public TransactionResponse Purchase(String token, BigDecimal amount);

    @WebMethod
    public TransactionResponse AuthoriseCreditCard(CreditCardData ccd,
                                                   BigDecimal amount);
}
