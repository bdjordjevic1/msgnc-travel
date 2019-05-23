package net.msgnetconomy.travel.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CurrencyDTO implements Serializable {

    private String name;
    private String isoCode;
    private String symbol;
}
