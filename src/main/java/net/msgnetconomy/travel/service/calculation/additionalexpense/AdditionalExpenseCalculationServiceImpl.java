package net.msgnetconomy.travel.service.calculation.additionalexpense;

import net.msgnetconomy.travel.data.AdditionalExpenseData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("additionalExpenseCalculationService")
public class AdditionalExpenseCalculationServiceImpl implements AdditionalExpenseCalculationService {

    @Resource
    private AdditionalExpenseTotalPayoutCalculationService additionalExpenseTotalPayoutCalculationService;

    @Override
    public AdditionalExpenseData calculate(AdditionalExpenseData additionalExpense) {
        additionalExpenseTotalPayoutCalculationService.calculate(additionalExpense);
        return null;
    }
}
