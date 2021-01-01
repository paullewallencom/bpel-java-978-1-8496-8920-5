package org.packt.cc;

public class CreditCardData {
    
    private CardHolderName holderData;
    private String         cardNumber;
    private String         cardExpiry;

    public CreditCardData() {     
    }

    public CreditCardData(CardHolderName holderData, String cardNumber,
                          String cardExpiry) {
        this.holderData = holderData;
        this.cardNumber = cardNumber;
        this.cardExpiry = cardExpiry;
    }


    public void setHolderData(CardHolderName holderData) {
        this.holderData = holderData;
    }

    public CardHolderName getHolderData() {
        return holderData;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardExpiry(String cardExpiry) {
        this.cardExpiry = cardExpiry;
    }

    public String getCardExpiry() {
        return cardExpiry;
    }
}
