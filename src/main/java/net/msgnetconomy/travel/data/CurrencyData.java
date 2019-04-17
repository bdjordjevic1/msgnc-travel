package net.msgnetconomy.travel.data;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CurrencyData implements Serializable {

    private String name;
    private String isoCode;
    private String symbol;
}
