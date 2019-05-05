package net.msgnetconomy.travel.service.calculation.totalpayout;

import net.msgnetconomy.travel.data.TravelReportData;

public interface TotalPayoutCalculationService {

    TravelReportData calculate(TravelReportData travelReport);
}
