package org.example;

import org.example.entities.Person;
import org.example.entities.Role;
import org.example.servicesImpl.StoreServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        List<Person> salesReps = new ArrayList<>();
        salesReps.add(new Person("Boniface", Role.SALES_REP));
        salesReps.add(new Person("Chinedu", Role.SALES_REP));
        salesReps.add(new Person("Emeka", Role.SALES_REP));
        Person manager = new Person("Chizy", Role.SALES_REP);

        StoreServiceImpl service = new StoreServiceImpl();
        service.addProduct("Clutch purse", 23, BigDecimal.valueOf(200000.00));
        service.addProduct("Stilleto", 50, BigDecimal.valueOf(500000.00));
        service.addProduct("mule", 50, BigDecimal.valueOf(500000.00));
        service.addProduct("Handbag", 50, BigDecimal.valueOf(550000.00));

        service.displayStock();
        System.out.println();

        service.adjustPrice(salesReps.get(1), "mule", BigDecimal.valueOf(3000000.00));
        service.adjustPrice(manager, "mule", BigDecimal.valueOf(3000000.00));

        service.displayStock();
        System.out.println();

        service.purchaseProduct("mule", 2);
        service.purchaseProduct("Handbag", 9);

        System.out.println();
        service.displayStock();

    }
}


