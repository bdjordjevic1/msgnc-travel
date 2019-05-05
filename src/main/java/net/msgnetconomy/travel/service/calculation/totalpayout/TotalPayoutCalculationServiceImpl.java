package net.msgnetconomy.travel.service.calculation.totalpayout;

import net.msgnetconomy.travel.data.CurrencyData;
import net.msgnetconomy.travel.data.TravelReportData;

import java.util.Map;

public class TotalPayoutCalculationServiceImpl implements TotalPayoutCalculationService {

    @Override
    public TravelReportData calculate(TravelReportData travelReport) {
        double dailyRateTotal = travelReport.getDailyRateCalculation().getDailyRateTotal();
        CurrencyData dailyRateCurrency = travelReport.getCountryTo().getCurrency();

        Map<CurrencyData, Double> totalPayout = travelReport.getAdditionalExpense().getTotalPayout();
        totalPayout.merge(dailyRateCurrency, dailyRateTotal, Double::sum);
        travelReport.setTotalPayout(totalPayout);
        return travelReport;
    }
}
