package com.endava.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class OrderDetails {
    private String beverage;
    private Integer quantity;
    private String customerName;
    private String pickup;
}