package net.msgnetconomy.travel.service.calculation.totalpayout;

import net.msgnetconomy.travel.data.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TotalPayoutCalculationServiceImplTest {

    @InjectMocks
    TotalPayoutCalculationServiceImpl totalPayoutCalculationService;

    @Test
    public void calculate() {
        TravelReportData travelReport = new TravelReportData();
        DailyRateCalculationData dailyRateCalculation = new DailyRateCalculationData();
        dailyRateCalculation.setDailyRateTotal(237.8d);

        CountryData country = new CountryData();
        CurrencyData currencyEuro = new CurrencyData();
        currencyEuro.setIsoCode("EUR");
        country.setCurrency(currencyEuro);

        CurrencyData currencyRSD = new CurrencyData();
        currencyEuro.setIsoCode("RSD");
        AdditionalExpenseData additionalExpense = new AdditionalExpenseData();

        Map<CurrencyData, Double> additionalExpenseTotalPayout = new HashMap<>();
        additionalExpenseTotalPayout.put(currencyRSD, 8730.95);
        additionalExpenseTotalPayout.put(currencyEuro, 48d);
        additionalExpense.setTotalPayout(additionalExpenseTotalPayout);

        travelReport.setCountryTo(country);
        travelReport.setDailyRateCalculation(dailyRateCalculation);
        travelReport.setAdditionalExpense(additionalExpense);

        totalPayoutCalculationService.calculate(travelReport);

        assertThat(travelReport.getTotalPayout().get(currencyEuro), is(285.8));
        assertThat(travelReport.getTotalPayout().get(currencyRSD), is(8730.95));
    }
}