package lab.demand;

import java.util.*;

public class Tax {

    private Map<String, Double> taxByCountry = new HashMap<>();

    public void setDefault(){
        this.setTax("PE",0.18);
        this.setTax("BR",0.12);
        this.setTax("CO",0.0);
    }

    public void setTax(String country, Double tax) {
        taxByCountry.put(country, tax);
    }

    public double calculateTax(String country) {
        Double tax = taxByCountry.get(country);
        return (tax != null) ? tax : 0;
    }

}
