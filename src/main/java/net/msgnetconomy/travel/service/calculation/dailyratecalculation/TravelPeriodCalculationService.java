package net.msgnetconomy.travel.service.calculation.dailyratecalculation;

import net.msgnetconomy.travel.data.TravelPeriodData;

public interface TravelPeriodCalculationService {

    TravelPeriodData calculate(TravelPeriodData travelPeriod);
}
