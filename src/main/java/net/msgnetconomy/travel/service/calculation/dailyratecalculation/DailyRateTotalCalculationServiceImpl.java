package net.msgnetconomy.travel.service.calculation.dailyratecalculation;

import net.msgnetconomy.travel.data.DailyRateCalculationData;
import net.msgnetconomy.travel.data.TravelPeriodData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dailyRateTotalCalculationService")
public class DailyRateTotalCalculationServiceImpl implements DailyRateTotalCalculationService {

    @Override
    public DailyRateCalculationData calculate(DailyRateCalculationData dailyRateCalculationData) {
        List<TravelPeriodData> travelPeriods = dailyRateCalculationData.getTravelPeriod();
        double dailyRateTotal = travelPeriods.stream()
                .mapToDouble(TravelPeriodData::getDailyRateTotal)
                .sum();

        dailyRateCalculationData.setDailyRateTotal(dailyRateTotal);
        return dailyRateCalculationData;
    }
}
