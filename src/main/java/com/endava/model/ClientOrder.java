package com.endava.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ClientOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String userName;

    private String beverageName;

    private double price;

    private boolean pickUp;
    private int quantity;

    public ClientOrder(String userName, String beverageName, double price, boolean pickUp , int quantity) {
        this.userName = userName;
        this.beverageName = beverageName;
        this.price = price;
        this.pickUp = pickUp;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "userName='" + userName + '\'' +
                ", beverageName='" + beverageName + '\'' +
                ", price=" + price +
                ", pickUp=" + pickUp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientOrder clientOrder = (ClientOrder) o;
        return price == clientOrder.price &&
                pickUp == clientOrder.pickUp &&
                userName.equals(clientOrder.userName) &&
                beverageName.equals(clientOrder.beverageName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, beverageName, price, pickUp);
    }
}
