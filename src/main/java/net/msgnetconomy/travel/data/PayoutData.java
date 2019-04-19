package net.msgnetconomy.travel.data;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PayoutData implements Serializable {

    private double amount;
    private CurrencyData currency;
}
