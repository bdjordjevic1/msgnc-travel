package net.msgnetconomy.travel.service.calculation.additionalexpense;

import net.msgnetconomy.travel.data.AdditionalExpenseData;

public interface AdditionalExpenseTotalPayoutCalculationService {

    AdditionalExpenseData calculate(AdditionalExpenseData additionalExpense);
}
