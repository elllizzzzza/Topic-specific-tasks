package com.expertsoft.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaymentInfo {

    public enum CardType {
        VISA,
        MASTERCARD
    }

    private CardType cardType;
    private String cardNumber;
    private String securityCode;
}
