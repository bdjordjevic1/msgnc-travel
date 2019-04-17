package net.msgnetconomy.travel.data;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ExpenseData implements Serializable {

    private String description;
    private double price;
    private CurrencyData currency;
}
