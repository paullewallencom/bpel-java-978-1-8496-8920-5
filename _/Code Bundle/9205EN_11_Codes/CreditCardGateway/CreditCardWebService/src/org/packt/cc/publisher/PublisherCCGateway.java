package org.packt.cc.publisher;

import javax.xml.ws.Endpoint;

import org.packt.cc.business.CreditCardGateway;

public class PublisherCCGateway {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/cc/gateway", new CreditCardGateway());
    }
}
