package org.packt.cc.business;

import java.math.BigDecimal;

import java.rmi.Remote;

import java.rmi.RemoteException;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import javax.jws.soap.SOAPBinding;

import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;

import javax.xml.ws.ResponseWrapper;

import org.packt.cc.CreditCardData;
import org.packt.cc.TransactionResponse;

@WebService(name = "CCGateSvc")
public interface CCGatePortType extends Remote {
    @RequestWrapper(localName = "auth", className = "org.packt.cc.business.AuthoriseRequest", targetNamespace = "http://www.mastercard.com/proc/")
    @ResponseWrapper(localName = "authResponse", className = "org.packt.cc.business.AuthoriseResponse", targetNamespace = "http://www.mastercard.com/proc/")
    @WebMethod
    public TransactionResponse AuthoriseCreditCard(@WebParam(name = "ccd")
        CreditCardData ccd, @WebParam(name = "amount")
        BigDecimal amount) throws RemoteException;

    @WebMethod
    @WebResult(name = "PurchaseResponse")
    public TransactionResponse Purchase(String token, BigDecimal amount) throws RemoteException;

    @WebMethod
    @WebResult(name = "RefundResponse")
    public TransactionResponse Refund(@WebParam(name = "token", mode = WebParam.Mode.IN) String token, 
                                      @WebParam(name = "amount", mode = WebParam.Mode.INOUT) Holder<BigDecimal> amount) throws RemoteException;
//    public TransactionResponse Refund(String token, BigDecimal amount) throws RemoteException;


    @WebMethod
    @WebResult(name = "VoidResponse")
    public TransactionResponse VoidOp(String token, BigDecimal amount) throws RemoteException;

    @WebMethod
    @Oneway
    public void OutputTransactions() throws RemoteException;
}
