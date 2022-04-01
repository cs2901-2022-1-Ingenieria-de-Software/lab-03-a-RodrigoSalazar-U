package lab;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import lab.demand.ManageDemand;
import lab.demand.Tax;
import lab.util.TestUtil;
import lab.demand.Order;

import java.util.ArrayList;
import java.util.List;

@Test
public class ManageDemandTest {

    private Tax tax;
    private Tax additional;
    private ManageDemand demand;

    @BeforeClass
    public void setup() {
        tax = new Tax();
        tax.setDefault();
        demand =  new ManageDemand(tax);
        additional = new Tax();
        additional.setTax("CO",0.10);
        additional.setTax("PE",0.20);
        additional.setTax("BR",0.30);
    }
    
    public void test_AllOrdersFromPeru() {
        List<Order> ordersFromPeru = TestUtil.buildOrdersPeru();
        double result = demand.calculateTotal(ordersFromPeru);
        Assert.assertEquals(Math.round(result), 7.0);
    }

    // Add Tests !!
    public void test_AllOrdersFromColombia() {
        List<Order> ordersFromColombia = TestUtil.buildOrdersColombia();
        double result = demand.calculateTotal(ordersFromColombia);
        Assert.assertEquals(Math.round(result), 0);
    }

    public void test_MixedOrders() {
        List<Order> ordersMixed = new ArrayList<>();
        ordersMixed.addAll(TestUtil.buildOrdersPeru());
        ordersMixed.addAll(TestUtil.buildOrdersColombia());
        double result = demand.calculateTotal(ordersMixed);
        Assert.assertEquals(Math.round(result), 14.0);
    }
    public void test_AllOrdersFromPeruAdditional() {
        List<Order> ordersFromPeru = TestUtil.buildOrdersPeru();
        double result = demand.calculateTotalForWithAdditionalByCountry(ordersFromPeru, additional);
        Assert.assertEquals(Math.round(result), 8.0);
    }
    public void test_AllOrdersFromColombiaAdditional() {
        List<Order> ordersFromColombia = TestUtil.buildOrdersColombia();
        double result = demand.calculateTotalForWithAdditionalByCountry(ordersFromColombia, additional);
        Assert.assertEquals(Math.round(result), 4.0);
    }
    public void test_MixedOrdersAdditional() {
        List<Order> ordersMixed = new ArrayList<>();
        ordersMixed.addAll(TestUtil.buildOrdersPeru());
        ordersMixed.addAll(TestUtil.buildOrdersColombia());
        double result = demand.calculateTotalForWithAdditionalByCountry(ordersMixed, additional);
        Assert.assertEquals(Math.round(result), 24.0);
    }

}
