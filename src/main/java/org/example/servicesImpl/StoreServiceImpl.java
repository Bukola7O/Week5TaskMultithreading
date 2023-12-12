package org.example.servicesImpl;

import org.example.entities.Person;
import org.example.entities.Product;
import org.example.entities.Role;
import org.example.services.StoreService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StoreServiceImpl implements StoreService {
    private final List<Product> productsInStock = new ArrayList<>();
    @Override
    public void addProduct(String productName, int initialQuantity, BigDecimal price) {
     productsInStock.add(new Product(productName, initialQuantity, price));
    }

    @Override
    public void adjustPrice(Person person, String productName, BigDecimal newPrice) {
        if (person.getRole() == Role.MANAGER) {
            Optional<Product> optionalProduct = findProductByName(productName);
            if (optionalProduct.isPresent()) {
                Product product = optionalProduct.get();
                product.setPrice(newPrice);
                System.out.println("Manager " + person.getName() + "adjusted the price of " + productName + "to #" + newPrice);
            }else{
                System.out.println(person.getName() + "does not have permission to adjust price");
            }
        }
    }

        private Optional<Product> findProductByName (String productName){
            return productsInStock.stream()
                    .filter(product -> product.getProductName().equals(productName))
                    .findFirst();
        }
    @Override
    public void displayStock() {
        System.out.println("current stock");
        productsInStock.forEach(product -> {
            System.out.println("Product name: " + product.getProductName() + " Quantity" + product.getQuantity());
        });

    }

    @Override
    public void purchaseProduct(String productName, int quantity) {
        Product product = findProductByName(productName).orElse(null);
        if (product != null && product.purchase(quantity)) {
            BigDecimal totalAmount = product.getPrice().multiply(BigDecimal.valueOf(quantity));
            System.out.println("Purchased " + quantity + " " + product.getProductName() +
                    "(s) at # " + product.getPrice() + " each. Total amount: #" + totalAmount
                    + ". Remaining quantity: " + product.getQuantity());
        } else {
            System.out.println("Not enough " + productName + "In stock to purchase " + quantity + " items");
        }

    }

    @Override
    public void restockProducts(String productName, int quantity) {
        Product product = findProductByName(productName).orElse(null);
        if (product != null && product.purchase(quantity)) {
            BigDecimal totalAmount = product.getPrice().multiply(BigDecimal.valueOf(quantity));
            System.out.println("Restocked " + quantity + " " + product.getProductName() +
                    "(s).New quantity: " + product.getQuantity());
        }else {
            System.out.println("Invalid restock for " + productName + ".");
        }
    }

    @Override
    public void processPayment(Person person, int amount) {
        person.makePayment(person, amount);
    }
}
