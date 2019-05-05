package net.msgnetconomy.travel.service.calculation.additionalexpense;

import net.msgnetconomy.travel.data.AdditionalExpenseData;
import net.msgnetconomy.travel.data.CurrencyData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service("additionalExpenseCalculationService")
public class AdditionalExpenseCalculationServiceImpl implements AdditionalExpenseCalculationService {

    @Override
    public AdditionalExpenseData calculate(AdditionalExpenseData additionalExpense) {
        Map<CurrencyData, Double> totalPayout = new HashMap<>();

        new ArrayList<>(additionalExpense.getExpenses()).forEach(expense -> {
            if (Objects.isNull(totalPayout.get(expense.getCurrency()))) {
                totalPayout.put(expense.getCurrency(), expense.getPrice());
            } else {
                totalPayout.merge(expense.getCurrency(), expense.getPrice(), Double::sum);
            }
        });

        additionalExpense.setTotalPayout(totalPayout);
        return additionalExpense;
    }
}
