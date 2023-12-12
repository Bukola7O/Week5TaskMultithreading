package org.example.services;

import org.example.entities.Person;

import java.math.BigDecimal;

public interface StoreService {
    void addProduct(String productName, int initialQuantity, BigDecimal price);
    void adjustPrice(Person person, String productName, BigDecimal price);
    void displayStock();
    void purchaseProduct(String productName, int quantity);
    void restockProducts(String productName, int quantity);
    void processPayment(Person person, int amount);
}
