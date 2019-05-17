package net.msgnetconomy.travel.data;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class LocationData implements Serializable {

    private String country;
    private String isoCode;
    private double dailyRate;
    private CurrencyData currency;
    private String city;
}
