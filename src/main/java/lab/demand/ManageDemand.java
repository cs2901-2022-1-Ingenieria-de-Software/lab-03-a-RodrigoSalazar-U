package lab.demand;

import java.util.List;

public class ManageDemand {

    private Tax tax;

    public ManageDemand(Tax tax) {
        this.tax = tax;
    }

    public double calculateTotal(List<Order> orders){
        return calculateTotalForWithAdditionalByCountry(orders, tax);
    }

    public double calculateTotalForWithAdditionalByCountry(List<Order> orders, Tax additionalByCountry){
        double taxes = calculateTaxes(orders, additionalByCountry);
        double quantities = calculateQuantities(orders);
        return quantities * taxes;
    }


    private double calculateTaxes(List<Order> orders, Tax taxByCountry){
        double taxes = 0.0;
        for (Order order : orders) {
            taxes += taxByCountry.calculateTax(order.getCountry());
        }
        return taxes;
    }

    private double calculateQuantities(List<Order> orders){
        double quantities = 0.0;
        for (Order order : orders) {
            double temp = order.getQuantity();
            quantities += temp;
        }
        return quantities;
    }
}
