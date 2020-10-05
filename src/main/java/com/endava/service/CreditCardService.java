package com.endava.service;

import com.endava.exception.CardException;
import com.endava.model.CardDetails;

import java.text.ParseException;

public interface CreditCardService {
    void validateCreditCard(CardDetails creditCard) throws CardException, ParseException;
}
