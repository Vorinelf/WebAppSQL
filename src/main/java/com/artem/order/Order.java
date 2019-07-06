package com.artem.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Order {
    private int id;
    private String dateOrder, firstName, secondName, brand,
            model;
    private int price;
    private String country, city, street, postIndex, phone;
}

