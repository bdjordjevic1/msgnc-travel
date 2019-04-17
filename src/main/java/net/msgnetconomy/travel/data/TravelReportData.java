package net.msgnetconomy.travel.data;

import java.time.LocalDateTime;
import java.util.List;

public class TravelReportData {

    private LocalDateTime dateOfSubmission;
    private String firstName;
    private String lastName;
    private CountryData countryFrom;
    private CountryData countryTo;
    private DailyRateCalculationData dailyRateCalculation;
    private TransportationType transportationType;
    private AdditionalExpenseData additionalExpense;
    private List<PayoutData> totalPayout;
}
