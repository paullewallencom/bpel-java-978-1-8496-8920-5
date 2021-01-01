package org.packt.backend;

import java.math.BigDecimal;

import java.util.UUID;
import java.util.Vector;

public class BackEndSystem {
    public static BackEndSystem m_Instance= null;
    private Vector Transactions= new Vector(); 
    
    
    public static BackEndSystem getInstance() {
        if (m_Instance == null)
            m_Instance= new BackEndSystem();
        
        return m_Instance;
    }
    
    public void purchaseOp(UUID token, BigDecimal amount) {
        Transactions.add("P-" + token.toString() + "-" + amount.toString());
    }

    public void refundOp(UUID token, BigDecimal amount) {
        Transactions.add("R-" + token.toString() + "-" + amount.toString());
    }


    public void voidOp(UUID token, BigDecimal amount) {
        Transactions.add("V-" + token.toString() + "-" + amount.toString());
    }

    public void setTransactions(Vector Transactions) {
        this.Transactions = Transactions;
    }

    public Vector getTransactions() {
        return Transactions;
    }
}
