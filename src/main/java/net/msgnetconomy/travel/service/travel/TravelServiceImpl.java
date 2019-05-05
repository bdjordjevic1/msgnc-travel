package net.msgnetconomy.travel.service.travel;

import net.msgnetconomy.travel.data.CountryData;
import net.msgnetconomy.travel.data.TravelData;
import net.msgnetconomy.travel.service.calculation.additionalexpense.AdditionalExpenseCalculationService;
import net.msgnetconomy.travel.service.calculation.dailyratecalculation.DailyRateTotalCalculationService;
import net.msgnetconomy.travel.service.calculation.dailyratecalculation.TravelPeriodCalculationService;
import net.msgnetconomy.travel.service.calculation.totalpayout.TotalPayoutCalculationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

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
        calculateTravelPeriod(travelData);
        dailyRateTotalCalculationService.calculate(travelData.getTravelReport().getDailyRateCalculation());
    }

    private void calculateTravelPeriod(TravelData travelData) {
        new ArrayList<>(travelData.getTravelReport().getDailyRateCalculation().getTravelPeriod())
                .forEach(travelPeriod -> {
                    travelPeriod.setDailyRate(getDailyRate(travelData));
                    travelPeriodCalculationService.calculate(travelPeriod);
                });
    }

    private double getDailyRate(TravelData travel) {
        CountryData destCountry = travel.getTravelReport().getCountryTo();
        return destCountry != null ? destCountry.getDailyRate() : 0;
    }

}
