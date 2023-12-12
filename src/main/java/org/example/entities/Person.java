package org.example.entities;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private Role role;


    public void makePayment(Person person, BigDecimal amount) {
        System.out.println(name + " made payment of #"+ amount);
    }

    public void makePayment(Person person, int amount) {
    }
}
