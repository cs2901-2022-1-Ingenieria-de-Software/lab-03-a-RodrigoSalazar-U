package lab;

import lab.demand.ManageDemand;
import lab.demand.Tax;
import lab.demand.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main (String [ ] args) {
        System.out.println("===INICIO====");

        Tax tax = new Tax();
        tax.setDefault();

        ManageDemand mg = new ManageDemand(tax);

        List<Order> testOrders = buildSampleOrders();
        
        double resultFirst = mg.calculateTotal(testOrders);
        System.out.println(String.format("RESULTADO TOTAL 1 => %s", resultFirst));

        // double resultSecond = mg.calculateTotalForWithAdditionalByCountry(testOrders, 0.10, 0.20, 0.30);
        Tax testAdditionalByCountry = buildSampleAdditionalByCountry();

        double resultSecond = mg.calculateTotalForWithAdditionalByCountry(testOrders, testAdditionalByCountry);
        System.out.println(String.format("RESULTADO TOTAL 2 => %s", resultSecond));
    }

    private static List<Order> buildSampleOrders() {
        List<Order> testOrders = new ArrayList<>();
        testOrders.add(new Order("PE", 10L));
        testOrders.add(new Order("PE", 20L));
        testOrders.add(new Order("CO", 10L));
        testOrders.add(new Order("BR", 10L));
        return testOrders;
    }

    private static Tax buildSampleAdditionalByCountry() {
        Tax testAdditionalByCountry = new Tax();
        testAdditionalByCountry.setTax("CO",0.10);
        testAdditionalByCountry.setTax("PE",0.20);
        testAdditionalByCountry.setTax("BR",0.30);
        return testAdditionalByCountry;
    }

}
