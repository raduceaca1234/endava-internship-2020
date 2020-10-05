package com.endava.repository;

import com.endava.model.ClientOrder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Repository
public class OrderOfUser {
        List<ClientOrder> clientOrders;

        public OrderOfUser(List<ClientOrder> clientOrders) {
                this.clientOrders = clientOrders;
        }

        public OrderOfUser(){
                clientOrders = new ArrayList<>();
        }

        public void addOrder(ClientOrder clientOrder){
                clientOrders.add(clientOrder);
        }

        public List<ClientOrder> getAll(){return clientOrders;}

        public double returnProfit(){
                return clientOrders.stream()
                        .mapToDouble(ClientOrder::getPrice)
                        .sum();
        }

}
