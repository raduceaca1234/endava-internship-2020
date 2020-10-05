package com.endava.controller.dto;

import com.endava.model.CardDetails;
import com.endava.model.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private CardDetails cardDetails;
    private OrderDetails orderDetails;

    @Override
    public String toString() {
        return cardDetails + " " + orderDetails;
    }
}