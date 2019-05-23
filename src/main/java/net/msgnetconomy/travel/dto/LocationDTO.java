package net.msgnetconomy.travel.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class LocationDTO implements Serializable {

    private String country;
    private String isoCode;
    private double dailyRate;
    private CurrencyDTO currency;
    private String city;
}
