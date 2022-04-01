package lab;

import lab.demand.ManageDemand;
import lab.demand.Order;
import lab.demand.Tax;
import lab.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

@Test
public class TaxTest {
    private Tax tax;

    @BeforeClass
    public void setup() {
        tax = new Tax();
    }

    public void test_DefaultTaxes() {
        tax.setDefault();
        Assert.assertEquals(tax.calculateTax("PE"), 0.18);
        Assert.assertEquals(tax.calculateTax("BR"), 0.12);
        Assert.assertEquals(tax.calculateTax("CO"), 0.0);
    }
    // Add Tests !
    public void test_TaxNotDefined() {
        Assert.assertEquals(tax.calculateTax("JP"), 0.0);
    }

    public void test_CustomTaxes() {
        tax.setTax("AU",0.18);
        Assert.assertEquals(tax.calculateTax("AU"), 0.18);
        tax.setTax("AU",0.9);
        Assert.assertEquals(tax.calculateTax("AU"), 0.9);
    }

    public void test_SetDefaultClear() {
        tax.setTax("AU",0.18);
        Assert.assertEquals(tax.calculateTax("AU"), 0.18);
        tax.setDefault();
        Assert.assertEquals(tax.calculateTax("AU"), 0.0);
    }

    public void test_OverwriteTaxes() {
        tax.setDefault();
        tax.setTax("PE",0.5);
        tax.setTax("BR",0.4);
        tax.setTax("CO",0.3);
        Assert.assertEquals(tax.calculateTax("PE"), 0.5);
        Assert.assertEquals(tax.calculateTax("BR"), 0.4);
        Assert.assertEquals(tax.calculateTax("CO"), 0.3);
    }
}
