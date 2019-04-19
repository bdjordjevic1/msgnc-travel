package net.msgnetconomy.travel.data;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CountryData implements Serializable {

    private String name;
    private String isoCode;
    private double dailyRate;
    private CurrencyData currency;
}
