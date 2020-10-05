package com.endava.service;

import com.endava.exception.CardException;
import com.endava.model.CardDetails;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CreditCardServiceImpl implements CreditCardService {
    public void validateCreditCard(CardDetails creditCard) throws CardException, ParseException {
        luhnValidation(creditCard.getCardNumber());
        cvvValidation(creditCard.getCvv());
        validateCardholderName(creditCard.getCardholderName());
        validateExpirationDate(creditCard.getExpiryDate());
    }

    private void luhnValidation(String cardNumber) throws CardException {
        int[] cardNumbers = new int[cardNumber.length()];
        for (int number = 0; number < cardNumber.length(); number++) {
            cardNumbers[number] = Integer.parseInt(cardNumber.substring(number, number + 1));
        }
        for (int i = cardNumbers.length - 2; i >= 0; i = i - 2) {
            int j = cardNumbers[i];
            j = j * 2;
            if (j > 9) {
                j = j % 10 + 1;
            }
            cardNumbers[i] = j;
        }
        int sumOfNumbers = 0;
        for (int number : cardNumbers) {
            sumOfNumbers += number;
        }
        if (sumOfNumbers % 10 != 0) {
            throw new CardException("Invalid card number");
        }

    }

    private void cvvValidation(String cvv) throws CardException {
        if (!cvv.matches("^[0-9]{3}$")) {
            throw new CardException("CVV number is not valid!");
        }
    }

    private void validateCardholderName(String cardholderName) throws CardException {
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(cardholderName);
        boolean b = m.find();
        if (cardholderName.length() < 2 || b) {
            throw new CardException("Invalid cardholder name");
        }
    }

    private void validateExpirationDate(String expiryDate) throws CardException, ParseException {
        if (!expiryDate.matches("^[0-9]{2}/[0-9]{2}$")) {
            throw new CardException("Invalid expiration date");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
        simpleDateFormat.setLenient(false);
        Date expiry = simpleDateFormat.parse(expiryDate);
        boolean expired = expiry.before(new Date());
        if (expired){
            throw new CardException("The card has expired");
        }
    }
}