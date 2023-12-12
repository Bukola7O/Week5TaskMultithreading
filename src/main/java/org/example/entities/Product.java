package org.example.entities;

import jdk.jfr.DataAmount;
import lombok.*;

import java.math.BigDecimal;
import java.util.function.BiConsumer;

@Data
@Builder
@RequiredArgsConstructor

public class Product {
    private String productName;
    private int quantity;
    private BigDecimal price;

    public Product(String productName, int quantity, BigDecimal price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public void stockUp(int quantity) {
        this.quantity = quantity;
    }
    public boolean purchase(int purchaseQuantity){
        synchronized (this) {
            if (purchaseQuantity > 0 && purchaseQuantity <= quantity) {
                quantity -= purchaseQuantity;
                return true;
            } else {
                return false;
            }
        }
    }
    public void displayProductDetails (){
        System.out.println("Product: " + productName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: " + price);
    }
}
