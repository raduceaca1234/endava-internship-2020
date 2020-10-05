package com.endava.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class CardDetails {
    private String cardNumber;
    private String cardholderName;
    private String expiryDate;
    private String cvv;
}