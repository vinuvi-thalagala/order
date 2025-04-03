package com.example.order.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Order {
    @Id
    
    private int id;
    private int itemId;
    private String orderDate;
    private int amount;

}
