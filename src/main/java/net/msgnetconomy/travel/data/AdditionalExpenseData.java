package net.msgnetconomy.travel.data;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class AdditionalExpenseData implements Serializable {

    private List<ExpenseData> expenses;
    private List<PayoutData> totalPayout;
}
