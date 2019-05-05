package net.msgnetconomy.travel.service.calculation.additionalexpense;

import net.msgnetconomy.travel.data.AdditionalExpenseData;
import net.msgnetconomy.travel.data.CurrencyData;
import net.msgnetconomy.travel.data.ExpenseData;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AdditionalExpenseTotalPayoutCalculationServiceImplTest {

    @InjectMocks
    AdditionalExpenseTotalPayoutCalculationServiceImpl additionalExpenseTotalPayoutCalculationService;

    @Test
    public void calculate() {
        CurrencyData currencyEuro = new CurrencyData();
        currencyEuro.setIsoCode("EUR");
        CurrencyData currencyRSD = new CurrencyData();
        currencyEuro.setIsoCode("RSD");
        AdditionalExpenseData additionalExpense = new AdditionalExpenseData();

        ExpenseData expense1 = new ExpenseData();
        expense1.setCurrency(currencyEuro);
        expense1.setPrice(48d);

        ExpenseData expense2 = new ExpenseData();
        expense2.setCurrency(currencyRSD);
        expense2.setPrice(8102.95);

        ExpenseData expense3 = new ExpenseData();
        expense3.setCurrency(currencyRSD);
        expense3.setPrice(308d);

        ExpenseData expense4 = new ExpenseData();
        expense4.setCurrency(currencyRSD);
        expense4.setPrice(320d);

        additionalExpense.setExpenses(Arrays.asList(expense1, expense2, expense3, expense4));
        additionalExpenseTotalPayoutCalculationService.calculate(additionalExpense);
        Map<CurrencyData, Double> totalPayout = additionalExpense.getTotalPayout();
        assertThat(totalPayout.size(), is(2));
        assertThat(totalPayout.get(currencyEuro), is(48d));
        assertThat(totalPayout.get(currencyRSD), is(8730.95));
    }
}