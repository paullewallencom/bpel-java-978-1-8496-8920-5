package org.packt.cc.test;

import java.math.BigDecimal;

import javax.xml.ws.Holder;

import org.packt.cc.CardHolderName;
import org.packt.cc.CreditCardData;
import org.packt.cc.TransactionResponse;
import org.packt.cc.business.AuthoriseRequest;
import org.packt.cc.business.CreditCardGateway;

public class TestGateway {
    public static void main(String[] args) throws Exception {
        CreditCardGateway ccgateway= new CreditCardGateway();
        
        CardHolderName chn= new CardHolderName("Jurij", "Laznik");
        CreditCardData ccd= new CreditCardData(chn, "4444-5555-6666-7777", "05/15");
        
        TransactionResponse resp= ccgateway.AuthoriseCreditCard(ccd, new BigDecimal(1000));        
        
        System.out.println("Response: ");        
        System.out.println("   Text .....: " + resp.getResponseText());        
        System.out.println("   Status ...: " + resp.getResponseStatus());  
        System.out.println("   Token  ...: " + resp.getToken());  
        
        
        ccgateway.Purchase(resp.getToken(), new BigDecimal(100));
        ccgateway.Purchase(resp.getToken(), new BigDecimal(102));
        
        ccgateway.OutputTransactions();
        
        ccgateway.Purchase(resp.getToken(), new BigDecimal(104));
        //ccgateway.Refund(resp.getToken(), new Holder(new BigDecimal(105)) );
        
        ccgateway.OutputTransactions();
        
        ccgateway.VoidOp(resp.getToken(), new BigDecimal(109));
        
        ccgateway.OutputTransactions();
    }
}
