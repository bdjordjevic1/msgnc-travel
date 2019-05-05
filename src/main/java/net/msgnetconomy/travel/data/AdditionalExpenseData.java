package net.msgnetconomy.travel.data;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class AdditionalExpenseData implements Serializable {

    private List<ExpenseData> expenses;
    private Map<CurrencyData, Double> totalPayout;
}
