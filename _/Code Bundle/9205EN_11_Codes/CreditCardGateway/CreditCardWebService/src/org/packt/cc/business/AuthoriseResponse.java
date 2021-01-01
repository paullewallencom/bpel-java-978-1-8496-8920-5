package org.packt.cc.business;

import java.util.UUID;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.packt.cc.TransactionResponse;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuthoriseResponse", propOrder = {
    "response"
})
public class AuthoriseResponse {
    
    @XmlElement(name = "return")
    private TransactionResponse response;
    
    
    public AuthoriseResponse() {
        super();
    }


    public void setResponse(TransactionResponse response) {
        this.response = response;
    }

    public TransactionResponse getResponse() {
        return response;
    }
}
