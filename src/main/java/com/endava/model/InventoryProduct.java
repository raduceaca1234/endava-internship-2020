package com.endava.model;

import lombok.*;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NamedQuery(name="InventoryProduct.decreaseAmount", query = "update InventoryProduct ip set ip.quantity = ip.quantity - ?2 where ip.type = ?1")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InventoryProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String type;

    private int quantity;

    private int price;



}
