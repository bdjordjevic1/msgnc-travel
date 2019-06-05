package net.msgnetconomy.travel.service.calculation.dailyratecalculation;

import net.msgnetconomy.travel.data.DailyRateCalculationData;
import net.msgnetconomy.travel.data.TravelReportData;

public interface DailyRateTotalCalculationService {

    DailyRateCalculationData calculate(TravelReportData travelReportData);
}
