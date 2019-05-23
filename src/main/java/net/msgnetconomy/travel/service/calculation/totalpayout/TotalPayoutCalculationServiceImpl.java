package net.msgnetconomy.travel.service.calculation.totalpayout;

import net.msgnetconomy.travel.data.CurrencyData;
import net.msgnetconomy.travel.data.TravelReportData;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("totalPayoutCalculationService")
public class TotalPayoutCalculationServiceImpl implements TotalPayoutCalculationService {

    @Override
    public TravelReportData calculate(TravelReportData travelReport) {
        double dailyRateTotal = travelReport.getDailyRateCalculation().getDailyRateTotal();
        CurrencyData dailyRateCurrency = travelReport.getLocationTo().getCurrency();

        Map<CurrencyData, Double> totalPayout = travelReport.getAdditionalExpense().getTotalPayout();
        totalPayout.merge(dailyRateCurrency, dailyRateTotal, Double::sum);
        travelReport.setTotalPayout(totalPayout);
        return travelReport;
    }
}
