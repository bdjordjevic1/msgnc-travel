package net.msgnetconomy.travel.service.travel;

import net.msgnetconomy.travel.data.TravelData;
import net.msgnetconomy.travel.service.calculation.additionalexpense.AdditionalExpenseCalculationService;
import net.msgnetconomy.travel.service.calculation.dailyratecalculation.DailyRateTotalCalculationService;
import net.msgnetconomy.travel.service.calculation.dailyratecalculation.TravelPeriodCalculationService;
import net.msgnetconomy.travel.service.calculation.totalpayout.TotalPayoutCalculationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("travelService")
public class TravelServiceImpl implements TravelService {

    @Resource
    private TravelPeriodCalculationService travelPeriodCalculationService;

    @Resource
    private DailyRateTotalCalculationService dailyRateTotalCalculationService;

    @Resource
    private AdditionalExpenseCalculationService additionalExpenseCalculationService;

    @Resource
    private TotalPayoutCalculationService totalPayoutCalculationService;

    @Override
    public TravelData calculate(TravelData travelData) {
        if (travelData.getTravelReport() != null && travelData.getTravelReport().getDailyRateCalculation() != null) {
            calculateDailyRateCalculation(travelData);
            calculateAdditionalExpenses(travelData);
            calculateTotalPayout(travelData);
        }
        return travelData;
    }

    private void calculateTotalPayout(TravelData travelData) {
        totalPayoutCalculationService.calculate(travelData.getTravelReport());
    }

    private void calculateAdditionalExpenses(TravelData travelData) {
        additionalExpenseCalculationService.calculate(travelData.getTravelReport().getAdditionalExpense());
    }

    private void calculateDailyRateCalculation(TravelData travelData) {
        dailyRateTotalCalculationService.calculate(travelData.getTravelReport());
    }

}
