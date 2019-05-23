package net.msgnetconomy.travel.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ExpenseDTO implements Serializable {

    private String description;
    private double price;
    private CurrencyDTO currency;
}
