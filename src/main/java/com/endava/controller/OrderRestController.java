package com.endava.controller;

import com.endava.controller.dto.OrderDTO;
import com.endava.exception.CardException;
import com.endava.exception.OrderException;
import com.endava.model.ClientOrder;
import com.endava.model.Coffee;
import com.endava.service.CoffeeServiceImpl;
import com.endava.service.CreditCardServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderRestController {

    @Autowired
    private CoffeeServiceImpl service;

    @Autowired
    private CreditCardServiceImpl cardService;

    @PostMapping (value = "/pay")
    public ResponseEntity<HttpStatus> pay(@RequestBody OrderDTO orderDTO) {

        Coffee beverage = service.getCoffee(orderDTO.getOrderDetails().getBeverage());
        try {
            cardService.validateCreditCard(orderDTO.getCardDetails());
            service.addOrder(beverage, orderDTO.getOrderDetails().getQuantity(), orderDTO.getOrderDetails().getCustomerName(),orderDTO.getOrderDetails().getPickup().equals("pickup"));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (OrderException | CardException | ParseException e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping(value = "")
    public List<ClientOrder> getOrders() {
        return service.getAll();
    }
}